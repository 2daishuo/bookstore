package cn.itcast.bookstore.dao;

import java.util.List;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Category;

public interface CategoryDao {

	public abstract void add(Category category);

	public abstract Category find(String id);

	public abstract List<Category> getAll();

	
	public void deleteCategory(String cid);

	public  Category findCategoryByName(String name);

	public  void updateCategory(Category category);

}