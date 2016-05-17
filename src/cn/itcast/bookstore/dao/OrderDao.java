package cn.itcast.bookstore.dao;

import java.util.List;

import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.User;

public interface OrderDao {

	public void add(Order order);

	public Order find(String oid);
	public List<Order> getAllOrder(int state);
	public void  updateOrderState(Order order);
	public List<Order> getMyOrder(User user);

}