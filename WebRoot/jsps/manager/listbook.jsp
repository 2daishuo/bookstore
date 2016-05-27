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
<style type="text/css">
body {
	font-size: 12pt;
	width: 1100px;
	height: 700px;
	background-image:url(./images/bg.gif);
		background-repeat:repeat; 
		

}

.icon {
	margin: 12px;
	border: solid 1px #ff8cf0;
	width: 190px;
	height: 230px;
	text-align: center;
	float: left;
}
</style>

</head>

<body style="text-align: center">
<div style="width: 1100px;height: 640px;border: solid 1px black;">
	<c:forEach var="book" items="${page.list}">
		<div class="icon">

			<a href="${pageContext.request.contextPath}/manager/BookServlet?method=bookDetail&bid=${book.bid}"><img
				src="${pageContext.request.contextPath}/images/${book.image}"
				style="width: 170px;height: 190px;" /> </a> <br> <a href="${pageContext.request.contextPath}/manager/BookServlet?method=bookDetail&bid=${book.bid}">${book.bname }</a>
		</div>

	</c:forEach>
	</div>



  <div style="width: 1100px;height: 20px;">
	 当前第[${page.pagenum }]页&nbsp;&nbsp;
	<c:forEach var="pagenum" begin="${page.startpage}"
		end="${page.endpage}">

		<a
			href="${pageContext.request.contextPath}/manager/BookServlet?method=list&pagenum=${pagenum}">[${pagenum }]</a>

	</c:forEach>
	总共[${page.totalpage }]页，总[${page.totalrecord}]条记录
	</div>
	
</body>
</html>
