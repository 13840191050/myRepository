package com.neuedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/java24new?characterEncoding=UTF-8&useUnicode=true";
			String username="root";
			String password="root";
			Connection conn=DriverManager.getConnection(url, username, password);
			return conn;
	}
	//2、【事务】开启事务
		public static void begintransaction(Connection conn) throws SQLException{
			conn.setAutoCommit(false);
		}
		//4、【事务】提交
		public static void commit(Connection conn) throws SQLException{
			conn.commit();
		}
		//5、【事务回滚】
		public static void rollback(Connection conn) throws SQLException{
			conn.rollback();
		}
		//6、关闭链接
		public static void closeDB(ResultSet rs,Statement ppst,Connection conn) throws SQLException{
			if(rs!=null){
				rs.close();
			}
			if(ppst!=null){
				ppst.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
}
