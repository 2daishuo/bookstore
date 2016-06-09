<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索图书显示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  huahuahu
    <div >
   <c:forEach  var ="b" items="${book}">
   <div  >
  <a href="${pageContext.request.contextPath }/client/BuyBookPreServlet?bid=${b.bid}"><img style="width: 150px;height: 170px;"src="${pageContext.request.contextPath}/images/${b.image}"></a> 
  <br>
   <a href="${pageContext.request.contextPath }/client/BuyBookPreServlet?bid=${b.bid}">${b.bname }</a>
    
  </div>
  </c:forEach>
  </div>
  </body>
</html>
