package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class RegisterServlet extends HttpServlet {
private BusinessServiceImpl service= new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form =WebUtils.request2Bean(request, User.class);
		String confirmPsd = request.getParameter("confirm");
		form.setUid(WebUtils.makeID());
		
		//输入校验，创建一个map，用来封装错误信息，其中key位表单字段名称，值为错误信息
		Map<String,String> error= new HashMap<String,String>();
		//获得表单form中的username，password，email进行校验
		String username=form.getUsername();
		
		if(username==null||username.trim().isEmpty())
		{
			error.put("username", "用户名不能为空");	
		
		}
		
		else if(username.length()<6||username.length()>20){
			error.put("username", "用户名的长度为6~20");
			
		}
		
		
		String password=form.getPassword();
		if(password==null||password.trim().isEmpty())
		{
			error.put("password", "密码不能为空");	
		
		}else if(password.length()<6||password.length()>20){
			error.put("password", "密码的长度为6~20");
			
		}
		
		if(confirmPsd==null||confirmPsd.trim().isEmpty())
		{
			error.put("confirm", "确认密码不能为空");	
		
		}else if(!confirmPsd.equals(password)){
			error.put("confirm", "密码不一致");
			
		}
		
		
		
		
		//邮箱格式的正则表达式验证

		String email=form.getEmail();
		if(email==null||email.trim().isEmpty())
		{
			error.put("email", "Email不能为空");	
		
		}else
			
		if(!email.matches("\\w+@\\w+\\.\\w+"))
		{
			error.put("email", "邮箱格式错误");
		}
		
		
		//判断邮箱是否注册
		
		User user = service.findByemail(email);
		if(user != null)
		{
			error.put("email", "邮箱已被注册");
		}
		
		//判断用户名是否存在
		User user1 = service.findByUsername(username);
		if(user1 != null)
		{
			error.put("username", "用户名已存在");
		}
		
		
		//判断是否存在错误信息
		
		if(error.size()>0)
		{//1保存错误信息，保存表单数据，发送到register.jsp
			request.setAttribute("error", error);
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsps/user/register.jsp").forward(request, response);
		
			return ;
		}

		System.out.println(form.getCellphone()+form.getUsername());
		service.register(form);
		request.setAttribute("msg", "注册成功");
		
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

	
}
