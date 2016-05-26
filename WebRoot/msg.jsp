<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	<style>
		body{
		background-image:url(images/a.jpg);
		background-repeat:repeat; 
		}
		h2{
			display:block;
			width:150px;
			color:darkred;
			border:1px solid gray; 
			text-align:center;
			margin:50px auto;
			font-family:"微软雅黑";
			
		}
	</style>
</head>

<body>
	<h1>${msg}</h1>
	
</body>
</html>
