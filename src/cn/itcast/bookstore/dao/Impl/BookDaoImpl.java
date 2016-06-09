package cn.itcast.bookstore.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	
	
	public void add(Book book){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into book(bid,bname,price,author,image,category_id,description,del) values(?,?,?,?,?,?,?,?)";
			Object params[] = {book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory_id(),book.getDescription(),false};
			runner.update(sql, params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public Book find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where bid=?";
			return  (Book) runner.query(sql, id, new BeanHandler(Book.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	
	public List<Book>getPageDate(int startindex,int pagesize){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where del=false limit ?,?";
			Object params[]={startindex,pagesize};
			return  (List<Book>) runner.query(sql, params,new BeanListHandler(Book.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public int getTotalRecord() {
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book where del=false";
			
			long totalrecord= (Long) runner.query(sql,new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	 public List getSearchBook(String search){
		 
		
		 try{
				QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
				String sql = "select * from book where bname like '%"+search+"%'";
				List<Book> book=(List<Book>) runner.query(sql,new BeanListHandler(Book.class));
				for (Book b : book) {
					System.out.println(b.getBname());
					
				}
				return  (List<Book>) runner.query(sql,new BeanListHandler(Book.class));
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		 
	 }


	
	public List<Book>getPageDate(int startindex,int pagesize,String category_id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where category_id=?and del=false limit ?,?";
			Object params[]={category_id,startindex,pagesize};
			return  (List<Book>) runner.query(sql, params,new BeanListHandler(Book.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public int getTotalRecord(String category_id) {
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book where del=false and category_id=?";
			
			long totalrecord= (Long) runner.query(sql,category_id,new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//É¾³ýÍ¼Êé¡£¼ÙÉ¾³ý¡£½«delÖÃÎªtrueÎªÉ¾³ý¡£
	public void deleteBook(String bid){
		try {
			String sql="update book set del=true where bid=?";
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			runner.update(sql,bid);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}		
	}
	 public void updateBook(Book book){
		 
		 try{
				QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
				String sql = "update book set bname=?,price=?,author=?,image=?,category_id=?,description=?,del=? where bid=?";
				Object params[] = {book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory_id(),book.getDescription(),false,book.getBid()};
				runner.update(sql, params);
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
	 }

}
