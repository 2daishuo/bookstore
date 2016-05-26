package cn.itcast.bookstore.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.itcast.bookstore.Exception.CategoryException;
import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.dao.OrderDao;
import cn.itcast.bookstore.dao.UserDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Cart;
import cn.itcast.bookstore.domain.CartItem;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.DaoFactory;
import cn.itcast.bookstore.utils.WebUtils;

public class BusinessServiceImpl {
																
	private CategoryDao dao = DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.CategoryDaoImpl",CategoryDao.class);
	private BookDao   bdao=DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.BookDaoImpl", BookDao.class);
	private UserDao udao= DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.UserDaoImpl", UserDao.class);
	private OrderDao odao=DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.OrderDaoImpl", OrderDao.class);
	
			
	/**
	 * 添加分类
	 * **/
	public void addCategory(Category category){
		dao.add(category);
	}
	/**查找分类**/
	public Category findCategory(String id){
		return dao.find(id);
	}
	/**得到所有分类**/
	public List<Category> getAllCategory(){
		return dao.getAll();
	}
	public void deleteCategory(String cid) throws CategoryException{
		
		int count=bdao.getTotalRecord(cid);
		if(count >0)			
			throw new CategoryException("该分类下有图书，不能删除！");
			dao.deleteCategory(cid);
		
	}
	/**添加图书
	 * 
	 * **/
	public void addBook(Book book){
	bdao.add(book);
	
	}
	/***
	 * 查看图书
	 * */
	public Book findBook(String id){
		return bdao.find(id);
	}
	/**
	 * 
	 * 获取书的分页数据
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
	public void buyBook(Cart cart, Book book ,int quantity) {
		// TODO Auto-generated method stub
		cart.add(book,quantity);
		
	}
	public void clearCart(Cart cart){
		cart.clear();
	}
	public void deleteItemCart( Cart cart,String bid){
		cart.delete(bid);
	}
	public void deleteBook(String bid){
		bdao.deleteBook(bid);
		
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
	 public  void updateUserDetail(User user){
		 udao.updateUser(user);
		 
	 }
	 public User login(User form){
		 
		User user= udao.findByUsername(form.getUsername());
		if (user==null||!user.getPassword().equals(form.getPassword())) {
			
			return null;
		}
		
		return user;
		
	 }
	 public void createOrder(Order order){
		 
		 
		 odao.add(order);
	 }
	 public List<Order> myOrder(User user){
		
		 
		 return odao.getMyOrder(user);
	 }
	public List <Order> listOrder(String state) {
		return odao.getAllOrder((Boolean.parseBoolean(state)?1:0));
		
	}
	public Order findOrderDetail(String id){
		
		return odao.find(id);
	}
	public void confirmOrder(String orderid) {
		Order order=odao.find(orderid);
		order.setState(1);
		odao.updateOrderState(order);
		
		
	}
	public Category findCategoryByName(String name) {
		return dao.findCategoryByName(name);
		
	}
	public void updateCategory(Category category) {
		dao.updateCategory(category);
		
	}
	public void updateBook(Book book) {
		bdao.updateBook(book);
		
	}

}
