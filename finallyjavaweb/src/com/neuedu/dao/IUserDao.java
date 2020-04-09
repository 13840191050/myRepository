package com.neuedu.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.pojo.User;

public interface IUserDao {
	//添加用户
	int addUser(User user) throws ClassNotFoundException, SQLException;
	//修改个人信息
	int modfiyselfById(User user) throws ClassNotFoundException, SQLException;
	//修改用户信息
	int modfiyuserById(int userid) throws ClassNotFoundException, SQLException;
	//查询全部用户信息
	List<User> findall() throws ClassNotFoundException, SQLException;
	//用户登录
	User finduser(String username) throws ClassNotFoundException, SQLException;

	int deluserById(int userid) throws ClassNotFoundException, SQLException;

	int deluserById(String[] ids) throws ClassNotFoundException, SQLException;
	//员工人数
	int findUserNum() throws ClassNotFoundException, SQLException;

}
