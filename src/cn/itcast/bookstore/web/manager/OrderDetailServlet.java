package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;

public class OrderDetailServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid=request.getParameter("orderid");
		BusinessServiceImpl service= new BusinessServiceImpl();
		Order order=service.findOrderDetail(oid);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/jsps/manager/orderdetail.jsp").forward(request, response);
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


}
