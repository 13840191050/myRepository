package com.neuedu.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.IUserServiceImpl;

/**
 * Servlet implementation class RemServlet
 */
@WebServlet("/remServlet")
@MultipartConfig
public class RemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		String useremail=request.getParameter("useremail");
		String userphone=request.getParameter("userphone");
		String userrealname=request.getParameter("userrealname");
		String usericard=request.getParameter("usericard");
		String userid=request.getParameter("userid");
//		Collection<part> parts=request.getParts();
		Part file=request.getPart("userhead");//单个文件
		String old_file=file.getSubmittedFileName();
		//为图片生成一个文件夹
		String savePath=request.getServletContext().getRealPath("/images");
		//为新的图片重新生成一个文件名 用UUID生成
		String preffix=UUID.randomUUID().toString().replace("-", "");
		//获取原始文件的后缀
		String suffix=old_file.substring(old_file.lastIndexOf("."));
		//用上面三个路径和文件名，拼成完整的文件路径
		String path=savePath+File.separator+preffix+suffix;
		System.out.println(path);
		String filename=preffix+suffix;
		System.out.println(filename);
		//把文件存到硬盘
		file.write(path);
		User user=new User();
		user.setUser_id(Integer.parseInt(userid));
		user.setUser_password(userpassword);
		user.setUser_email(useremail);
		user.setUser_phone(userphone);
		user.setUser_name(username);
		user.setUser_realname(userrealname);
		user.setUser_idcard(usericard);
		user.setUser_head(filename);
		IUserService us=new IUserServiceImpl();
		try {
			int resultNum=us.modfiyselfById(user);
			if(resultNum>0) {
				System.out.println("修改成功");
				HttpSession session=request.getSession();
				session.setAttribute("db_user", user);
				request.getRequestDispatcher("/remUserMenu.jsp").forward(request, response);
			}else {
				System.out.println("修改失败");
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
