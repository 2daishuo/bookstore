package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getSession().invalidate();
		request.setAttribute("msg", "ÍË³ö³É¹¦£¡");
		response.setHeader("refresh",
				"1;URL=http://127.0.0.1:8080/bookstore/index.jsp");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


}
