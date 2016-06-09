<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.12.2.js"></script>
 

  </head>
  
  <body>
  <div class="htmleaf-container">
  <div class="wrapper">
		<div class="container">
  <h1>Welcome  ${msg }</h1>
  <c:if test="${empty sessionScope.user}">
 <p style="color:red; font-weight:900"> ${error} </p>
			
  <form class="form" method="post"  target="_top"action="${pageContext.request.contextPath}/client/LoginServlet">
 <input type="hidden" name="methed" value="login"/>
<input type="text" placeholder="Username" value="${form.username }" name="username"/><br/>
<input type="password" placeholder="Password" value="${form.password }" name="password"/><br/>

<button type="submit"  id="login-button" > 登录</button>

  </form>
 </c:if>
</div>
	<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
</div>
</div>
  </body>
  
  
  
</html>
