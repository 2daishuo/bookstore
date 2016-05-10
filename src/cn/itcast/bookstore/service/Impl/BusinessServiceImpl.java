package cn.itcast.bookstore.service.Impl;

import java.util.List;

import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.utils.DaoFactory;

public class BusinessServiceImpl {
																
	private CategoryDao dao = DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.CategoryDaoImpl",CategoryDao.class);
	private BookDao   bdao=DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.BookDaoImpl", BookDao.class);
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

}
