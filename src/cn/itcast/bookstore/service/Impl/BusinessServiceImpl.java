package cn.itcast.bookstore.service.Impl;

import java.util.List;

import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.utils.DaoFactory;

public class BusinessServiceImpl {
																
	private CategoryDao dao = DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.CategoryDaoImpl",CategoryDao.class);
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
	

}
