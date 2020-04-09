package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.IUserServiceImpl;
import com.neuedu.util.DBUtil;
import com.neuedu.util.SystemTime;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/logServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在Get方法中调用Post方法
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求响应编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取前台输入的信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		IUserService us=new IUserServiceImpl();
	
		try {
			User db_user=us.finduser(username);
			if(db_user==null) {
				request.setAttribute("logErrorCode", "用户名错误");
				System.out.println("用户名错误");
				request.getRequestDispatcher("/logMenu.jsp").forward(request, response);				
			}else {
				if (db_user.getUser_password().equals(password)) {
					HttpSession session=request.getSession();
					session.setAttribute("db_user", db_user);
					String time=SystemTime.hour();
					session.setAttribute("logUserTime", time);
					int resultNumByDb=us.findUserNum();
					session.setAttribute("resultNumByDb",resultNumByDb );
					if(db_user.getUser_role().equals("0")) {
						request.getRequestDispatcher("/userMainMenu.jsp").forward(request, response);
						response.sendRedirect("/userMainMenu.jsp");
					}else if(db_user.getUser_role().equals("1")) {
						request.getRequestDispatcher("/userMainMenu.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("logErrorCode", "密码错误");
					request.getRequestDispatcher("/logMenu.jsp").forward(request, response);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("数据库异常");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL异常");
			e.printStackTrace();
		}
		
	}

}
