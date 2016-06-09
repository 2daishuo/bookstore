<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <base href="<%=basePath%>">  
    <style type="text/css">
body{font:font-family:"微软雅黑";color:darkred;padding:20px 0 0 0;	background:#f1eddd;	}
#my-form{width:500px;margin:0 auto;border:1px solid pink;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}


input
 {
    font-size: 100%; 
    margin: 0; 
    vertical-align: baseline; 
    *vertical-align: middle; 
}
div{
width:500px; margin-left:150px; margin-bottom:20px; 
}

h1{
			display:block;
			width:150px;
			color:darkred;
			 
			text-align:center;
			margin:50px auto;
			font-family:"微软雅黑";
			
		}
		span{
		color:red;
		 font-weight:900;
		
		
		}


</style>  
    <title>注册</title> 
  </head>  
  <body>
  <p style="color:red; font-weight:900"> ${msg} </p>
 <form id="my-form" method="post" action="${pageContext.request.contextPath}/client/RegisterServlet">
 <h1>页面注册</h1>
  <input type="hidden" name="method" value="register">
  
<div>
	<label>您的姓名:</label>
	<input type="text" value="${form.username}" name="username"/>
	<span > ${error.username} </span><br/>
</div>



<div>
<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
<input type="password" value="${form.password }" name="password"/>
<span > ${error.password} </span><br/>
</div>
<div><label>确认密码:</label><input type="password" name="confirm"/>
<span > ${error.confirm} </span><br/>
</div>
<div><label>邮箱地址:</label><input type="email" value="${form.email }" name="email"/>
  <span > ${error.email} </span><br/>
</div>

<div>
<label>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</label>
<input type="text" value="${form.cellphone }" name="cellphone"/>
<span > ${error.cellphone} </span><br/>
</div>
<div style="padding-left:70px;">
<input type="submit" value="注册">  
<input type="reset"  value="重置">
</div>
  </form>
  
   <hr/>
  
  
  
  
  
  </body>
</html>