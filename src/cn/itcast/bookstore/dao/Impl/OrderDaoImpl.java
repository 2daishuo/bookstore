package cn.itcast.bookstore.dao.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.dao.OrderDao;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	public void add(Order order) {
		// 插入订单，插入条目
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into orders(oid,ordertime,totalprice,state,uid)values(?,?,?,?,?)";
			Object params[] = { order.getOid(), order.getOrdertime(),
					order.getTotalprice(), order.getState(),
					order.getUser().getUid() };
			runner.update(sql, params);
			Set<OrderItem> set = order.getOrderitems();
			for (OrderItem item : set) {
				sql = "insert into orderitem(iid,quantity,subtotal,oid,bid)values(?,?,?,?,?)";
				params = new Object[] { item.getIid(), item.getQuantity(),
						item.getSubtotal(), order.getOid(),
						item.getBook().getBid() };
				runner.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	// 查看订单详细信息，比如书名，多少本
	public Order find(String oid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where oid=?";
			Order order = (Order) runner.query(sql, oid, new BeanHandler(
					Order.class));
			sql = "select * from orderitem where oid=?";
			List<OrderItem> list = (List<OrderItem>) runner.query(sql, oid,
					new BeanListHandler(OrderItem.class));
			for (OrderItem item : list) {
				sql = "select book.* from orderitem,book where iid=? and book.bid=orderitem.bid";
				Book book = (Book) runner.query(sql, item.getIid(),
						new BeanHandler(Book.class));
				item.setBook(book);
				System.out.println("item有几本书" + item.getQuantity());

			}

			// 把找出的订单项放进order
			order.getOrderitems().addAll(list);
			sql = "select tb_user.* from tb_user,orders where oid=? and orders.uid=tb_user.uid";
			User user = (User) runner.query(sql, oid, new BeanHandler(
					User.class));
			order.setUser(user);
			return order;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	public List<Order> getMyOrder(User user) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where uid=?";
			List<Order> listorder = (List<Order>) runner.query(sql,
					user.getUid(), new BeanListHandler(Order.class));
			for (Order order : listorder) {
				sql = "select * from orderitem where oid=?";
				List<OrderItem> list = (List<OrderItem>) runner.query(sql,
						order.getOid(), new BeanListHandler(OrderItem.class));
				for (OrderItem item : list) {
					sql = "select book.* from orderitem,book where iid=? and book.bid=orderitem.bid";
					Book book = (Book) runner.query(sql, item.getIid(),
							new BeanHandler(Book.class));
					item.setBook(book);
					System.out.println("item有几本书" + item.getQuantity());

				}// 把找出的订单项放进order
				order.getOrderitems().addAll(list);
				order.setUser(user);

			}

			return listorder;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	public List<Order> getAllOrder(int state) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=?";
			System.out.println(state);
			List<Order> list = (List<Order>) runner.query(sql, state,
					new BeanListHandler(Order.class));
			for (Order order : list) {
				sql = "select tb_user.* from tb_user,orders where orders.oid=? and tb_user.uid=orders.uid";
				User user = (User) runner.query(sql, order.getOid(),
						new BeanHandler(User.class));
				order.setUser(user);

			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void updateOrderState(Order order) {

		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set state=? where oid=?";
			Object params[] = { order.getState(), order.getOid() };
			runner.update(sql, params);
		} catch (SQLException e) {

			throw new RuntimeException();

		}

	}

}
