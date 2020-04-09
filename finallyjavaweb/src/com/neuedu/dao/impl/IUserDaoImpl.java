package com.neuedu.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.IUserDao;
import com.neuedu.pojo.User;
import com.neuedu.util.DBUtil;

public class IUserDaoImpl implements IUserDao {

	//用户注册	
	@Override
	public int addUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("insert into t_user values(null,?,?,?,?,?,?,0,null)");
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getUser_password());
		ps.setString(3, user.getUser_email());
		ps.setString(4, user.getUser_phone());
		ps.setString(5, user.getUser_realname());
		ps.setString(6, user.getUser_idcard());
		int result=ps.executeUpdate();
		DBUtil.closeDB(null, ps, conn);
		return result;
	}
	
	//修改个人信息
	@Override
	public int modfiyselfById(User user) throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement ppst=null;
		conn=DBUtil.getConnection();
		ppst=conn.prepareStatement("update t_user set user_password=?,user_email=?,user_phone=?,user_head=? where user_id=?");
		ppst.setString(1, user.getUser_password());
		ppst.setString(2, user.getUser_email());
		ppst.setString(3, user.getUser_phone());
		ppst.setString(4, user.getUser_head());
		ppst.setInt(5, user.getUser_id());
		int resultNum=ppst.executeUpdate();
		return resultNum;
	}

	@Override
	public int modfiyuserById(int userid) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return 0;
	}
	 //查询全部账户信息
	@Override
	public List<User> findall()throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ppst=null;
		ResultSet rs=null;
		List<User> userList=new ArrayList();
		conn=DBUtil.getConnection();
		ppst=conn.prepareStatement("select * from t_user");
		rs=ppst.executeQuery();
		while (rs.next()) {
			User user=new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_realname(rs.getString("user_realname"));
			user.setUser_idcard(rs.getString("user_idcard"));
			user.setUser_role(rs.getString("user_role"));
			user.setUser_head(rs.getString("user_head"));
			userList.add(user);
		}
		return userList;
		
	}
	
	@Override
	public User finduser(String username) throws ClassNotFoundException, SQLException{
		Connection conn=null;
		PreparedStatement ppst=null;
		ResultSet rs=null;
		conn=DBUtil.getConnection();
		ppst=conn.prepareStatement("select * from t_user where user_name=?");
		ppst.setString(1, username);
		rs=ppst.executeQuery();
		if (rs.next()) {
			User user=new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_realname(rs.getString("user_realname"));
			user.setUser_idcard(rs.getString("user_idcard"));
			user.setUser_role(rs.getString("user_role"));
			user.setUser_head(rs.getString("user_head"));
			return user;
		}else {
			return null;
		}
	}

	@Override
	public int deluserById(int userid) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deluserById(String[] ids) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	//查询人工人数
	@Override
	public int findUserNum() throws ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ppst=null;
		ResultSet rs=null;
		conn=DBUtil.getConnection();
		ppst=conn.prepareStatement("select count(*) as result from t_user");
		rs=ppst.executeQuery();
		if (rs.next()) {
			int result=rs.getInt("result");
			return result;
		}else {
			return 0;
		}
		
	}

}
