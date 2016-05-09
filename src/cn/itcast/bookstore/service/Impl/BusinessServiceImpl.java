package cn.itcast.bookstore.service.Impl;

import java.util.List;

import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.utils.DaoFactory;

public class BusinessServiceImpl {
																
	private CategoryDao dao = DaoFactory.getInstance().createDao("cn.itcast.bookstore.dao.Impl.CategoryDaoImpl",CategoryDao.class);
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
	

}
