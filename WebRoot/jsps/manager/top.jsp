<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>书屋管理top</title>
    <base href="<%=basePath%>">
	<style>
		body{
		background-image:url(./images/b.gif);
		background-repeat:no-repeat; 
		background-size:cover;
		
		background-position:50% 50%;
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
  
  <body style="text-align:center;background-image:url(./images/b.gif);
		background-repeat:no-repeat; ">
  <h2>书屋管理</h2>
     <br>
  </body>
</html>
