<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    


  </head>
  
  <body>
  <h1>登录</h1>
  <p style="color:red; font-weight:900">${msg}</p>
  <form method="post" action="${pageContext.request.contextPath}/client/LoginServlet">
 <input type="hidden" name="methed" value="login"/>
您的姓名:&nbsp;<input type="text" value="${form.username }" name="username"/><br/>
密码:&nbsp;<input type="password" value="${form.password }" name="password"/><br/>

<input type="submit" value="登录">  

  </form>

  </body>
</html>
