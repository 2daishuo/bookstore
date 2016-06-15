package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class userorderconfirmgoods extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		String oid=request.getParameter("oid");
		BusinessServiceImpl service= new BusinessServiceImpl();
		service.confirmOrderIs4(oid);
		request.setAttribute("msg", "确认收货成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}catch (Exception e)
		{
			request.setAttribute("msg", "确认收货失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		}
		
	}

  public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  doGet(request,response);
	}

}
