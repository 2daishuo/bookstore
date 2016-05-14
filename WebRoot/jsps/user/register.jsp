<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>注册</title> 
  </head>  
  <body>
  <p style="color:red; font-weight:900"> ${msg} </p>
 <form method="post" action="${pageContext.request.contextPath}/client/RegisterServlet">
  <input type="hidden" name="method" value="register">
您的姓名:&nbsp;<input type="text" value="${form.username}" name="username"/>
<span style="color:red; font-weight:900"> ${error.username} </span><br/>

邮箱地址:&nbsp;<input type="email" value="${form.email }" name="email"/>
  <span style="color:red; font-weight:900"> ${error.email} </span><br/>


密码:&nbsp;<input type="password" value="${form.password }" name="password"/>
<span style="color:red; font-weight:900"> ${error.password} </span><br/>

确认密码:&nbsp;<input type="password" name="confirm"/>
<span style="color:red; font-weight:900"> ${error.confirm} </span><br/><br/>
<input type="submit" value="注册">  
<input type="reset" value="重置">
  </form>
  
   <hr/>
  
  
  
  
  
  </body>
</html>