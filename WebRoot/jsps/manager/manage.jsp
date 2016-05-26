<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员界面</title>
    
	

  </head>
  <frameset rows="20%,*">
	<frame name="top" src="${pageContext.request.contextPath}/jsps/manager/top.jsp">
	
 	
	<frameset cols="10%,*">
		<frame name="left"src="${pageContext.request.contextPath}/jsps/manager/left.jsp">
		<frame name="right"src="${pageContext.request.contextPath}/jsps/manager/right.jsp">
	</frameset>
 
</frameset>
  
  
  
 
</html>
