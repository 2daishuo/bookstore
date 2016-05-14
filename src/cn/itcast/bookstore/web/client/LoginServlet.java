package cn.itcast.bookstore.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		User form = WebUtils.request2Bean(request, User.class);
		User user = service.login(form);
		// System.out.println(resultMsg);

		if (user == null) {
			request.setAttribute("msg", "密码或用户名错误");
			request.getRequestDispatcher("/jsps/user/login.jsp").forward(
					request, response);

		} else {

			request.getSession().setAttribute("msg",
					"登录成功！ 欢迎:" + user.getUsername());
			request.getSession().setAttribute("user", user);
			response.setHeader("refresh",
					"1;URL=http://127.0.0.1:8080/bookstore/index.jsp");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			// request.getRequestDispatcher("/jsps/user/right.jsp").forward(request,
			// response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
