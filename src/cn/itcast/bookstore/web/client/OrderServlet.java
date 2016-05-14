package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;

public class OrderServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			User user=(User) request.getSession().getAttribute("user");
			if(user==null){
				request.setAttribute("msg", "对不起，请先登录");
				request.getRequestDispatcher("/msg.jsp");
			}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

	

}
