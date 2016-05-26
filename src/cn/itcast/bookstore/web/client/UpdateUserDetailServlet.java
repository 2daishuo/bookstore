package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.Globals;

public class UpdateUserDetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=request.getParameter("username");
		BusinessServiceImpl service= new BusinessServiceImpl();
		try{
		User user=service.findByUsername(username);
		request.setAttribute("preferences", Globals.preferences);
		
		request.setAttribute("user", user);
		System.out.println(user.getPreferences());
		request.getRequestDispatcher("/jsps/user/updateuser.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("msg", "用户名不存在");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
