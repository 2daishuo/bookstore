<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主体</title>
    <style type="text/css">


.icon {
	margin: 12px;
	
	width: 190px;
	height: 230px;
	text-align: center;
	float: left;
	background:#fff;
	border:1px solid pink;	
}
body {
	font-family:arial, sans-serif;
	font-weight:normal;
	font-size:14px;
	background:#f1eddd;	
}
ul {
	list-style:none;
	margin:0; 
	padding:0;
	
	margin:0 auto;
	
}
ul li a {
	display:block;
	padding:6px 12px;
	color:green;
	text-decoration:none;
}
ul li {
	border-bottom:1px solid #ccc;
}
.aa{
	display:block;
	padding:6px 12px;
	color:green;
	text-decoration:none;
	border-bottom:1px solid #ccc;
}
</style>


  </head>
  
  <body style="text-align:center;">
   <div id="content" style="width:1330px;height:600px;border:1px solid pink;">
   <div id="category" style="text-align:left;float:left;width:200px;height:600px;">
 
   <a  class="aa" href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll"> 查看所有图书</a>
  
  <ul>
   <c:forEach  var="category" items="${category}">
   <li>
  <a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBookWithCategory&category_id=${category.cid}"> ${category.cname }</a>
   </li>
   </c:forEach>
   </ul>
   </div>
 <div id="bookpage"  style="width:1120px;height:600px;float: right;border-left:1px solid pink;">
   <div id="books" style="width:1120px;height:560px;">
   <c:forEach  var ="book" items="${page.list }">
   <div id="book" class="icon" >
  <a href="${pageContext.request.contextPath }/client/BuyBookPreServlet?bid=${book.bid}"><img style="width: 150px;height: 170px;"src="${pageContext.request.contextPath}/images/${book.image}"></a> 
  <br>
   <a href="${pageContext.request.contextPath }/client/BuyBookPreServlet?bid=${book.bid}">${book.bname }</a>
    
  </div>
 
     
   </c:forEach>
   </div>
   
   <div id="page">
   <br> 当前第[${page.pagenum }]页&nbsp;&nbsp;
	<c:forEach var="pagenum" begin="${page.startpage}" end="${page.endpage}">
									     
	<a href="${pageContext.request.contextPath}/client/IndexServlet?pagenum=${pagenum}&category_id=${param.category_id}&method=${param.method}">[${pagenum }]</a>

	</c:forEach>
	总共[${page.totalpage }]页，总[${page.totalrecord}]条记录
   
   </div>
   </div>
   
  
   
   
   
   
   </div>
  </body>
</html>
