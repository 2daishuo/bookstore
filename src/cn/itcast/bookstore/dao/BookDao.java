package cn.itcast.bookstore.dao;

import java.util.List;

import cn.itcast.bookstore.domain.Book;

public interface BookDao {
	void add(Book book);
	Book find(String id);
	public int getTotalRecord();
	public List<Book>getPageDate(int startindex,int pagesize);
	public List<Book>getPageDate(int startindex,int pagesize,String category_id);
	public int getTotalRecord(String category_id);

}