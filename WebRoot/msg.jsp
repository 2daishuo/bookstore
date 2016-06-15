<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.12.2.js"></script>
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	
</head>

<body  style="background:#f1eddd"	>
	<h1>${msg}</h1>

		
		

</body>
</html>
