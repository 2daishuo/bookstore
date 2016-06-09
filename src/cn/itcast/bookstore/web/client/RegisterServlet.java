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
		
		//����У�飬����һ��map��������װ������Ϣ������keyλ���ֶ����ƣ�ֵΪ������Ϣ
		Map<String,String> error= new HashMap<String,String>();
		//��ñ�form�е�username��password��email����У��
		String username=form.getUsername();
		
		if(username==null||username.trim().isEmpty())
		{
			error.put("username", "�û�������Ϊ��");	
		
		}
		
		else if(username.length()<6||username.length()>20){
			error.put("username", "�û����ĳ���Ϊ6~20");
			
		}
		
		
		String password=form.getPassword();
		if(password==null||password.trim().isEmpty())
		{
			error.put("password", "���벻��Ϊ��");	
		
		}else if(password.length()<6||password.length()>20){
			error.put("password", "����ĳ���Ϊ6~20");
			
		}
		
		if(confirmPsd==null||confirmPsd.trim().isEmpty())
		{
			error.put("confirm", "ȷ�����벻��Ϊ��");	
		
		}else if(!confirmPsd.equals(password)){
			error.put("confirm", "���벻һ��");
			
		}
		
		
		
		
		//�����ʽ��������ʽ��֤

		String email=form.getEmail();
		if(email==null||email.trim().isEmpty())
		{
			error.put("email", "Email����Ϊ��");	
		
		}else
			
		if(!email.matches("\\w+@\\w+\\.\\w+"))
		{
			error.put("email", "�����ʽ����");
		}
		
		
		//�ж������Ƿ�ע��
		
		User user = service.findByemail(email);
		if(user != null)
		{
			error.put("email", "�����ѱ�ע��");
		}
		
		//�ж��û����Ƿ����
		User user1 = service.findByUsername(username);
		if(user1 != null)
		{
			error.put("username", "�û����Ѵ���");
		}
		
		
		//�ж��Ƿ���ڴ�����Ϣ
		
		if(error.size()>0)
		{//1���������Ϣ����������ݣ����͵�register.jsp
			request.setAttribute("error", error);
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsps/user/register.jsp").forward(request, response);
		
			return ;
		}

		System.out.println(form.getCellphone()+form.getUsername());
		service.register(form);
		request.setAttribute("msg", "ע��ɹ�");
		
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
		
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

	
}
