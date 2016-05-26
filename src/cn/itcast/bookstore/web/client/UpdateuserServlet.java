package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class UpdateuserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try{
			User user =WebUtils.request2Bean(request, User.class);
			System.out.println("5667"+user.getPreferences()+new java.sql.Date(user.getBirth().getTime())+"  hahah");
		
		BusinessServiceImpl service= new BusinessServiceImpl();
		service.updateUserDetail(user);
		request.setAttribute("msg", "更新成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
		}catch(Exception e){
			request.setAttribute("msg", "更新失败");
			e.printStackTrace();
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
			
			
		}
		
		

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
