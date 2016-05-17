package cn.itcast.bookstore.web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class ConfirmOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		String orderid = request.getParameter("orderid");
		BusinessServiceImpl service= new BusinessServiceImpl();
		service.confirmOrder(orderid);
		request.setAttribute("msg", "������Ϊ����״̬");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "���÷���״̬ʧ��");
			
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
		
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
