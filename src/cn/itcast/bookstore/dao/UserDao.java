package cn.itcast.bookstore.dao;

import cn.itcast.bookstore.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User findByemail(String email);

	public abstract User findByUsername(String username);

	public abstract void updateState(String uid, boolean state);

}