package cn.itcast.bookstore.utils;



import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {

	private static DataSource ds = null;
	static{
		ds = new ComboPooledDataSource("flx");
	}
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		
		return ds.getConnection();
	}
	
}
