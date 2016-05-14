package cn.itcast.bookstore.web.manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Page;
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
			add(request,response);//派发请求
		}
		if(method.equalsIgnoreCase("list")){
			list(request,response);//派发请求
		}
	}

	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("查看图书1");
		String pagenum=request.getParameter("pagenum");
		System.out.println(pagenum+"查看图书2");
	BusinessServiceImpl service= new BusinessServiceImpl();
	Page page=service.getBookPageDate(pagenum);
	request.setAttribute("page", page);
	System.out.println("查看图书3");
	request.getRequestDispatcher("/jsps/manager/listbook.jsp").forward(request, response);
	
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//处理
		try{
		Book book=doupload(request);
		BusinessServiceImpl service= new BusinessServiceImpl();
		book.setBid(WebUtils.makeID());
		service.addBook(book);
		request.setAttribute("msg", "添加成功！！");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "添加失败！！");
		}
		
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}

	private Book doupload(HttpServletRequest request){
	//把上传的图片保存到images目录中，并把request中的请求参数封装到book中
		Book book= new Book();
		
		try{
		DiskFileItemFactory factory =new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> list=upload.parseRequest(request);
		for(FileItem item : list){
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				System.out.println(name+":" +value);
				BeanUtils.setProperty(book, name, value);
			}else{
				String filename = item.getName();
				String savefilename = makeFileName(filename);//得到保存在硬盘的文件名
				String savepath = this.getServletContext().getRealPath("/images");
				InputStream in = item.getInputStream();
				FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
				int len = 0;
				byte buffer[] = new byte[1024];
				while((len=in.read(buffer))>0){
					out.write(buffer,0,len);
				}
				in.close();
				out.close();
				item.delete();
				book.setImage(savefilename);
			}
		}
				return book;
				
			}
			catch(Exception e){
				new RuntimeException(e);
				}
		return book;
				
			
	//	return null;
	}


	public String makeFileName(String filename) {
	String ext=	filename.substring(filename.lastIndexOf("."));
		return UUID.randomUUID().toString()+"_"+ext;
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
