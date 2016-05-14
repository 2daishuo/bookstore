<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台左侧导航</title>	

  </head>
  
  <body>
   <a href="#" target="right">分类管理</a><br/><br/>
   <a href="${pageContext.request.contextPath}/jsps/manager/addcategory.jsp" target="right">添加分类</a>
   <br/><br/>
   <a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=listall" target="right">查看分类</a>
   <br/><br/>
   <a href="#" target="right">图书管理</a>
   <br/><br/>
    <a href="${pageContext.request.contextPath}/manager/BookServlet?method=addUI" target="right">添加图书</a><br>
    <a href="${pageContext.request.contextPath}/manager/BookServlet?method=list" target="right">查看图书</a>
   <a href="#" target="right">订单管理</a>
   
   
  </body>
</html>
