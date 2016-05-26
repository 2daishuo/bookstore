package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import cn.itcast.bookstore.Exception.CategoryException;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.service.Impl.BusinessServiceImpl;
import cn.itcast.bookstore.utils.WebUtils;

public class CategotyServlet extends HttpServlet {

	
	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("add")){
			add(request,response);
		}else if(method.equals("delete")){
			delete(request,response);
		}else if(method.equals("update")){
			update(request,response);
		}else if(method.equals("updatepre")){
			updatepre(request,response);
		}else if(method.equals("listall")){
			listall(request,response);
		}else{
			request.setAttribute("msg", "不支持此类操作");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	private void listall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		List<Category> categorys = service.getAllCategory();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/jsps/manager/listcategory.jsp").forward(request, response);
		
	}

	private void updatepre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		BusinessServiceImpl service= new BusinessServiceImpl();
		request.setAttribute("category",service.findCategory(cid));
		request.getRequestDispatcher("/jsps/manager/modefy.jsp").forward(request, response);
		
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			System.out.println("执行servlet的update方法");
			String cid=request.getParameter("cid");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			System.out.println(cid+"cid===");
			BusinessServiceImpl service = new BusinessServiceImpl();
			//if(service.findCategoryByName(name)==null){
		Category category = new Category();
			category.setCname(name);
			category.setDescription(description);
			category.setCid(cid);
			
			
			service.updateCategory(category);
			listall(request, response);
		
	
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
		String cid=request.getParameter("cid");
		BusinessServiceImpl service= new BusinessServiceImpl();
		service.deleteCategory(cid);
		listall(request, response);
		
		
		}
		catch(CategoryException e){
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		}
		
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.println("执行servlet的add方法");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			Category category = new Category();
			category.setCname(name);
			category.setDescription(description);
			category.setCid(WebUtils.makeID());
			
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addCategory(category);
			request.setAttribute("msg", "添加成功！！");
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加失败!!");
		}
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}


	

}
