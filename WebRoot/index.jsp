<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	
  </head>
  

    <frameset rows="20%,*">
	<frame name="top" src="${pageContext.request.contextPath}/jsps/user/top.jsp">
	
 	
	<frameset cols="20%,*">
		<frame name="left"src="${pageContext.request.contextPath}/jsps/user/left.jsp">
		<frame name="right"src="${pageContext.request.contextPath}/jsps/manager/manage.jsp">
	</frameset>
 
</frameset>

    

</html>
