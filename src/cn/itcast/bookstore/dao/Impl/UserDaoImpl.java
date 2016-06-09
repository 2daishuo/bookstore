package cn.itcast.bookstore.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bookstore.dao.UserDao;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	public void add(User user){
		try {
			System.out.println(user.getUid()+user.getUsername());
		QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into tb_user(uid,username,password,email,cellphone,gender,birth,preferences) values(?,?,?,?,?,?,?,?)";
		Object params[]={user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCellphone(),"ÄÐ","1977-01-01","hhh"};
		
			runner.update(sql,params);
		} catch (Exception e) {
			//throw new RuntimeException();
			e.printStackTrace();
		
		}
		
	}

	public User findByemail(String email) {
		
		
		try {
			String sql = "select * from tb_user where email=?";

			QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
			

			return (User) runner.query(sql, email,new BeanHandler(User.class));
			
			
		} catch (Exception e) {
			
			return null;
		}
	}


	public User findByUsername(String username) {
		
		try {
			QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from tb_user where username=?";
			
			User user= (User) runner.query(sql, username,new BeanHandler(User.class));

			//System.out.println(user.getUsername());
			//System.out.println(user.getGender());
			//System.out.println(user.getBirth());
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
public User findUserByUid(String uid) {
		
		try {
			QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from tb_user where uid=?";
			return (User) runner.query(sql, uid,new BeanHandler(User.class));

			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public void updateState(String uid, boolean state) {
	
		
		try{
			String sql = "update tb_use set state=? where uid=?";
			QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());

		
		Object params[]={state?1:0,uid};
		runner.update(sql,params);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	public void updateUser(User user){
		
		try{
			String sql = "update tb_user set username=?,gender=?, birth=?, cellphone=?, preferences=? where uid=?";
			QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());

		
		Object params[]={user.getUsername(),user.getGender(),new java.sql.Date(user.getBirth().getTime()),user.getCellphone(),user.getPreferences(),user.getUid()};
		runner.update(sql,params);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		
	}
}
