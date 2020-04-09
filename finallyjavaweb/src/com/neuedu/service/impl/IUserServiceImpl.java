package com.neuedu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.dao.IUserDao;
import com.neuedu.dao.impl.IUserDaoImpl;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;

public class IUserServiceImpl implements IUserService {
	IUserDao userdao=new IUserDaoImpl();
	
	//用户注册
	@Override
	public int adduser(User user) throws ClassNotFoundException, SQLException {
		int result=userdao.addUser(user);
		return result;
	}
	//
	@Override
	public int modfiyselfById(User user) throws ClassNotFoundException, SQLException {
		int result=userdao.modfiyselfById(user);
		return result;
	}

	@Override
	public int modfiyuserById(int userid) throws ClassNotFoundException, SQLException {
		int result=userdao.modfiyuserById(userid);
		return result;
	}
	
	//查询用户全部信息
	@Override
	public List<User> findall() throws ClassNotFoundException, SQLException {
		List<User> userList=userdao.findall();
		return userList;
		
	}

	//删除用户
	@Override
	public int deluserById(int userid) throws ClassNotFoundException, SQLException {
		int result=userdao.deluserById(userid);
		return result;
	}
	
	//批量删除用户
	@Override
	public int delallByIds(String[] ids) throws ClassNotFoundException, SQLException {
		int result=userdao.deluserById(ids);
		return result;
	}
	
	//登录
	@Override
	public User finduser(String username) throws ClassNotFoundException, SQLException {
		IUserDao ud=new IUserDaoImpl();
		User db_user=ud.finduser(username);
		return db_user;
	}
	@Override
	public int findUserNum() throws ClassNotFoundException, SQLException {
		int result=userdao.findUserNum();
		return result;
	}

}
