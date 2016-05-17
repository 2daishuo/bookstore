package cn.itcast.bookstore.dao;

import cn.itcast.bookstore.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User findByemail(String email);

	public abstract User findByUsername(String username);
	public User findUserByUid(String uid);
	public void updateUser(User user);

	public abstract void updateState(String uid, boolean state);

}