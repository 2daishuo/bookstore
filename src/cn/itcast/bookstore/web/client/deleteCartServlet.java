package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class deleteCartServlet extends HttpServlet {

	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("clearAllCart")){
			clearAllCart(request,response);
		}
		if(method.equalsIgnoreCase("clearItemCart")){
			clearItemCart(request,response);
		}

		
		
		
		
	}
public void clearAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	BusinessServiceImpl service= new BusinessServiceImpl();
	Cart cart=(Cart) request.getSession().getAttribute("cart");
	if(cart!=null){
	service.clearCart(cart);
	request.getRequestDispatcher("/jsps/user/listcart.jsp").forward(request, response);
}
}
public void clearItemCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	BusinessServiceImpl service= new BusinessServiceImpl();
	Cart cart=(Cart) request.getSession().getAttribute("cart");
	String bid= request.getParameter("bookid");
	service.deleteItemCart(cart, bid);
	request.getRequestDispatcher("/jsps/user/listcart.jsp").forward(request, response);
	
	
	
	
	
}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	

}
