package cn.itcast.bookstore.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {
	

	public void add(Category category){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into category(cid,cname,description) values(?,?,?)";
			Object params[] = {category.getCid(),category.getCname(),category.getDescription()};
			runner.update(sql, params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	public Category find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category where id=?";
			return (Category) runner.query(sql, id, new BeanHandler(Category.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Category> getAll(){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category";
			return  (List<Category>) runner.query(sql, new BeanListHandler(Category.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		
	}

}
