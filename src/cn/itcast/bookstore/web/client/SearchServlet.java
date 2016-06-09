package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class SearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search=request.getParameter("ch");
		System.out.println(search);
		BusinessServiceImpl service=new BusinessServiceImpl();
		List book=service.getSearchBook(search);
		if(book!=null)
		System.out.println("÷¥––¡Àserch");
		
		
		 request.setAttribute("book", book);
		
		 request.getRequestDispatcher("/jsps/user/searchBook.jsp").forward(request, response);
		

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
