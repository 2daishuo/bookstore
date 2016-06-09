package cn.itcast.bookstore.utils;

import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try{
		T t =clazz.newInstance();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
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
