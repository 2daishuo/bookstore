package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;


import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class BookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if(method.equals("addUI")){
		
			addUI(request,response);
		}
		if(method.equalsIgnoreCase("add")){
			add(request,response);//�ɷ�����
		}
	}

	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����
		try{
		Book book=doupload(request);
		BusinessServiceImpl service= new BusinessServiceImpl();
		book.setBid(WebUtils.makeID());
		service.addBook(book);
		request.setAttribute("msg", "��ӳɹ�����");
		}catch(Exception e){
			request.setAttribute("msg", "���ʧ�ܣ���");
		}
		
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}

	private Book doupload(HttpServletRequest request){
	//���ϴ���ͼƬ���浽imagesĿ¼�У�����request�е����������װ��book��
		DiskFileItemFactory factory =new DiskFileItemFactory();
		return null;
	}


	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl  service= new BusinessServiceImpl();
	
		List category = service.getAllCategory();
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/jsps/manager/addbook.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}


}
