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
<style type="text/css">
body {
	background: #4682B4;
}

a {
	text-transform: none;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>

<title>顶部</title>


</head>

<body>
<body style="text-align:center">
	<h1 style="text-align: center;">小小书屋</h1>
	<div style="font-size: 10pt;">
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<a
					href="${pageContext.request.contextPath}/client/IndexServlet?method=getAll"
					target="right">首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/jsps/user/login.jsp"
					target="_parent">登录</a> |&nbsp; 
		<a href="${pageContext.request.contextPath}/jsps/user/register.jsp"
					target="right">注册</a>
			</c:when>
			<c:otherwise>
		<a href="${pageContext.request.contextPath}/client/UpdateUserDetailServlet?username=${sessionScope.user.username}" target="right">hi：${sessionScope.user.username }</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<a
					href="${pageContext.request.contextPath}/client/IndexServlet?method=getAll"
					target="right">首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/client/MyOrderServlet" target="right">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/jsps/user/listcart.jsp"
					target="right">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/client/LogoutServlet"
					target="_parent">退出</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
