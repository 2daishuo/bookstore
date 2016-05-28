<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加分类</title>
     <style type="text/css">
     body{
    background: #f2eede;
    }
    
    
    
    </style>
    
  </head>
  
  <body>											
   <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post">
    	分类名称：<input type="text" name="name"><br/>
    	分类描述：<textarea rows="5" cols="40" name="description"></textarea><br/>
    	<input type="submit" value="添加">
    </form>
    
  </body>
</html>
