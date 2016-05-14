package cn.itcast.bookstore.web.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class BuyServlet extends HttpServlet {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		 String bookid=request.getParameter("bookid");
		 System.out.println("书号"+bookid);
		BusinessServiceImpl service= new BusinessServiceImpl();
		Book book=service.findBook(bookid);
		 System.out.println("书名"+book.getBname());
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart= new Cart();
			request.getSession().setAttribute("cart", cart);			
		}
		service.buyBook(cart,book);
		request.getRequestDispatcher("/jsps/user/listcart.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "添加购物车失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
			
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

	
}
