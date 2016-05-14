package cn.itcast.bookstore.service.Impl;

import java.util.List;

import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.dao.UserDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.DaoFactory;

public class BusinessServiceImpl {
																
	private CategoryDao dao = DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.CategoryDaoImpl",CategoryDao.class);
	private BookDao   bdao=DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.BookDaoImpl", BookDao.class);
	private UserDao udao= DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.UserDaoImpl", UserDao.class);
	/**
	 * ��ӷ���
	 * **/
	public void addCategory(Category category){
		dao.add(category);
	}
	/**���ҷ���**/
	public Category findCategory(String id){
		return dao.find(id);
	}
	/**�õ����з���**/
	public List<Category> getAllCategory(){
		return dao.getAll();
	}
	/**���ͼ��
	 * 
	 * **/
	public void addBook(Book book){
	bdao.add(book);
	
	}
	/***
	 * �鿴ͼ��
	 * */
	public Book findBook(String id){
		return bdao.find(id);
	}
	/**
	 * 
	 * ��ȡ��ķ�ҳ����
	 * **/
	public Page getBookPageDate(String pagenum){
		int totalrecord=bdao.getTotalRecord();
		Page page = null;
		if(pagenum==null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = bdao.getPageDate(page.getStartindex(),page.getPagesize());
		page.setList(list);
		return page;
	}
	public Page getBookPageDate(String pagenum ,String category_id){
		
		int totalrecord=bdao.getTotalRecord(category_id);
		Page page = null;
		if(pagenum==null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum),totalrecord);
		}
		List list = bdao.getPageDate(page.getStartindex(),page.getPagesize(),category_id);
		page.setList(list);
		return page;
		
		
	}
	public void buyBook(Cart cart, Book book) {
		// TODO Auto-generated method stub
		cart.add(book);
		
	}
	public void register(User user){
		
		udao.add(user);
		
	}
	public User findByemail(String email){
						
		return udao.findByemail(email);
		
	}
	public User findByUsername(String username){
		return udao.findByUsername(username);
	}
	 public void updateState(String uid, boolean state)
	 {
		 udao.updateState(uid, state);
		 
	 }
	 public User login(User form){
		 
		User user= udao.findByUsername(form.getUsername());
		if (user==null||!user.getPassword().equals(form.getPassword())) {
			
			return null;
		}
		
		return user;
		
	 }

}
