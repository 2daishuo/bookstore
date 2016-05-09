package cn.itcast.bookstore.dao;

import java.util.List;

import cn.itcast.bookstore.domain.Category;

public interface CategoryDao {

	public abstract void add(Category category);

	public abstract Category find(String id);

	public abstract List<Category> getAll();

}