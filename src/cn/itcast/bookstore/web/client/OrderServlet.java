package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.domain.CartItem;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class OrderServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try{
			User user=(User) request.getSession().getAttribute("user");
			if(user==null){
				request.setAttribute("msg", "对不起，请先登录");
				request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
				return;
			}
			Cart cart =(Cart) request.getSession().getAttribute("cart");
			BusinessServiceImpl service=new BusinessServiceImpl();
			
			
			
			if(cart ==null){
				request.setAttribute("msg", "对不起，你没有购买任何东西");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			 }
			 Order order= new Order();
			 order.setOid(WebUtils.makeID());
			 order.setOrdertime(new Date());
			 order.setTotalprice(cart.getPrice());
			 order.setState(0);//未付款
			 order.setUser(user);
			 for(Map.Entry<String, CartItem> me :cart.getMap().entrySet()){
			 CartItem cartitem=me.getValue();
			 OrderItem orderitem= new OrderItem();
			 orderitem.setBook(cartitem.getBook());
			 orderitem.setIid(WebUtils.makeID());
			 orderitem.setQuantity(cartitem.getQuantity());
			 orderitem.setSubtotal(cartitem.getPrice());
			 order.getOrderitems().add(orderitem);		 
			 }
			 
			 service.createOrder(order);
			
			
			
			
			
			service.clearCart(cart);
			request.setAttribute("order", order);
			request.setAttribute("msg", "订单已生成，请准备好钱");
			request.getRequestDispatcher("/jsps/user/createorder.jsp").forward(request, response);
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
