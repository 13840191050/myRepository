package com.neuedu.service;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.pojo.User;

public interface IUserService {

	int adduser(User user) throws ClassNotFoundException, SQLException;//用户注册
	//修改个人信息
	int modfiyselfById (User user) throws ClassNotFoundException, SQLException;
	//修改普通用户信息
	int modfiyuserById (int userid) throws ClassNotFoundException, SQLException;
	//查询所有人信息
	List<User>findall() throws ClassNotFoundException, SQLException;
	//查询个人信息
	User finduser(String username) throws ClassNotFoundException, SQLException;
	//删除用户信息
	int deluserById(int userid)throws ClassNotFoundException, SQLException;
	//批量删除用户信息
	int delallByIds(String[] ids) throws ClassNotFoundException, SQLException;
	//查询用户人数
	int findUserNum()throws ClassNotFoundException, SQLException;
}
