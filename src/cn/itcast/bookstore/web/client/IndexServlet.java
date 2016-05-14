package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class IndexServlet extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
if(method.equalsIgnoreCase("getAll"))
{
	getAll(request,response);
}else if(method.equalsIgnoreCase("listBookWithCategory"))
	
	listBookWithCategory(request,response);	
	}
public void listBookWithCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String category_id=request.getParameter("category_id");
	String pagenum=request.getParameter("pagenum");
	BusinessServiceImpl service=new BusinessServiceImpl();
	List category=service.getAllCategory();
	Page page=service.getBookPageDate(pagenum,category_id);
	 request.setAttribute("page", page);
	 request.setAttribute("category", category);
	 request.getRequestDispatcher("/jsps/user/right.jsp").forward(request, response);
	
}
public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	BusinessServiceImpl service=new BusinessServiceImpl();
List category=service.getAllCategory();
request.setAttribute("category", category);
 String pagenum=request.getParameter("pagenum");
 Page page=service.getBookPageDate(pagenum);

 request.setAttribute("page", page);
 request.getRequestDispatcher("/jsps/user/right.jsp").forward(request, response);
 
		
 
	
	
}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request,response);
	}

	

}
