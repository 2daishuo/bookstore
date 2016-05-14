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

<title>显示所有书籍</title>


</head>

<body style="text-align: center">
	<h2>显示图书</h2>
	<table border="1px">
		<tr>
			<td>图书名称</td>
			<td>作者</td>
			<td>价格</td>
			<td>图片</td>
			<td>描述</td>
			<td></td>
		</tr>
		<c:forEach var="book" items="${page.list}">
			<tr>
				<td>${book.bname}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td><a href="${pageContext.request.contextPath}/images/${book.image}">查看图片</a></td>
				<td>${book.description}</td>
				<td><a href="#">修改</a> <a href="#">删除</a></td>

			</tr>


		</c:forEach>


	</table>

	<br> 当前第[${page.pagenum }]页&nbsp;&nbsp;
	<c:forEach var="pagenum" begin="${page.startpage}" end="${page.endpage}">
									     
		<a
			href="${pageContext.request.contextPath}/manager/BookServlet?method=list&pagenum=${pagenum}">[${pagenum }]</a>

	</c:forEach>
	总共[${page.totalpage }]页，总[${page.totalrecord}]条记录
</body>
</html>
