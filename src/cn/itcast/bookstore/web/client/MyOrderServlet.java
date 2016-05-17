package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class MyOrderServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		BusinessServiceImpl service=new BusinessServiceImpl();
		List<Order> orders=service.myOrder(user);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/jsps/user/myorderdetail.jsp").forward(request, response);
		


		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

	
}
