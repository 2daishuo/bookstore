package cn.itcast.bookstore.web.client;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class BuyBookPreServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid=request.getParameter("bid");	
		System.out.println(bid);
		BusinessServiceImpl service= new BusinessServiceImpl();
		Book book=service.findBook(bid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/jsps/user/showbuyonebook.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
