package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class OrderServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try{
			User user=(User) request.getSession().getAttribute("user");
			if(user==null){
				request.setAttribute("msg", "对不起，请先登录");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
			Cart cart =(Cart) request.getSession().getAttribute("cart");
			BusinessServiceImpl service=new BusinessServiceImpl();
			service.createOrder(cart, user);
			service.clearCart(cart);
			request.setAttribute("msg", "订单已生成，请准备好钱");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("msg", "订单生成失败");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
			

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

	

}
