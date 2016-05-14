package cn.itcast.bookstore.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bookstore.dao.UserDao;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	public void add(User user){
		try {
		QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into tb_user values(?,?,?,?,?,?)";
		Object params[]={user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),user.isState()? 1 : 0};
		
			runner.update(sql,params);
		} catch (Exception e) {
			throw new RuntimeException();
		
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
			return (User) runner.query(sql, username,new BeanHandler(User.class));

			

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
}
