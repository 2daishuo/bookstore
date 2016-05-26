<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改分类</title>
    


  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=update" method="post">
     <input type="hidden" name="cid" value="${category.cid}">
     
    	分类名称：<input type="text" name="name" value="${category.cname }"><br/>
    	分类描述：<textarea rows="5" cols="40" name="description" >${category.description }</textarea><br/>
    	<input type="submit" value="修改">
    </form>
  </body>
</html>
