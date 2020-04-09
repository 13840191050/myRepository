package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.IUserServiceImpl;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户注册
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user_name=request.getParameter("username");
		String user_password=request.getParameter("userpassword");
		String user_email=request.getParameter("usermail");
		String user_phone=request.getParameter("userphone");
		String user_realname=request.getParameter("userrealname");
		String user_idcard=request.getParameter("useridcard");
		User user=new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setUser_email(user_email);
		user.setUser_phone(user_phone);
		user.setUser_realname(user_realname);
		user.setUser_idcard(user_idcard);
		IUserService us=new IUserServiceImpl();
		try {
			int result=us.adduser(user);
			if(result>0) {
				System.out.println("用户添加成功");
				request.setAttribute("regError", "添加成功");
				request.getRequestDispatcher("/regMainMenu.jsp").forward(request, response);
			}else {
				System.out.println("用户添加失败");
				request.setAttribute("regError", "添加失败，请联系开发部");
				request.getRequestDispatcher("/regMainMenu.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
