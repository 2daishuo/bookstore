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
    
    <title>主体</title>
    


  </head>
  
  <body style="text-align:center;">
   <div id="content" style="width:840px">
   <div id="category" style="text-align:left;float:left;width:200px;height:300px;border:1px solid red;">
  分类列表：
  <ul>
   <c:forEach  var="category" items="${category}">
   <li>
  <a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBookWithCategory&category_id=${category.cid}"> ${category.cname }</a>
   </li>
   </c:forEach>
   </ul>
   </div>
   <div id="bookandpage" style="float:left;margin-left:50px;">
   <div id="books">
   <c:forEach  var ="book" items="${page.list }">
   <div id="book" >
   <div id="image" style="float:left;"><img src="${pageContext.request.contextPath}/images/${book.image}"> </div>
   <div id="bookinfo" style="float:left;text-align:left">
   <ul>
   <li>${book.bname }</li>
   <li>${book.author }</li>
   <li>${book.price }</li>
   <li> <a href="${pageContext.request.contextPath}/client/BuyServlet?bookid=${book.bid}">购买</a></li>   
   </ul>   
  </div>
  <div style="clear:both"></div>
  <br>
   
   
   
   
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
