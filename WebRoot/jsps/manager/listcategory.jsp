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

<title>列出所有分类</title>


</head>

<body style="text-align: center">
<h1>显示分类</h1>
	<table border="1px" align="center">
		<tr>
			<td>分类名称</td>
			<td>分类描述</td>
			<td>操作</td>
		</tr>
		<c:forEach var="c" items="${categorys}">
			<tr>
				<td>${c.cname}</td>
				<td>${c.description}</td>
				<td>
				<a href="">删除</a>
				<a href="">修改</a>
				</td>
			</tr>


		</c:forEach>


	</table>
</body>
</html>
