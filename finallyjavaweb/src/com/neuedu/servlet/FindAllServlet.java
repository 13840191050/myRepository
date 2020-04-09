package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.IUserServiceImpl;
import com.neuedu.util.DBUtil;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllServlet() {
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
		//查找全部用户账户信息
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IUserService us=new IUserServiceImpl();
		try {
			List<User> userList=us.findall();
			if(userList!=null) {
				System.out.println("结果查询成功");
				request.setAttribute("userFindAll", userList);
				request.getRequestDispatcher("/findAllMenu.jsp").forward(request, response);
			}else {
				request.setAttribute("userFindAll", "查询失败");
				request.getRequestDispatcher("/findAllMenu.jsp").forward(request, response);
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
