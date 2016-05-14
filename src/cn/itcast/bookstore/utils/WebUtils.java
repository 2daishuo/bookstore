package cn.itcast.bookstore.utils;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		
		try{
		T t =clazz.newInstance();
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements())
		{
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			BeanUtils.setProperty(t, name, value);
		}
		return t;
		}
		
		catch(Exception e){
			throw new RuntimeException();
			
		}
		
	}
	
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
	

}
