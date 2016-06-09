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


a {
	text-transform: none;
	text-decoration: none;
	font-family:arial, sans-serif;
	
	
}

a:hover {
	text-decoration: underline;
}
*:focus {outline: none; }

#hua{height: 33px;}
#hua .input{border: 1px solid #999999;height: 100%;}
#hua .input .clear{width: 30px;height: 35px;line-height: 30px;text-align: center;cursor: pointer;padding-right: 10px;visibility: hidden;opacity: 0.8;color: gray;}
#hua input[type=text]{height:86%;border:0px;width: 250px;}
#hua div{float: left;}
#button{width: 100px;height: 35px;background: green;color: #fff;border: none;}
h1{
			display:block;
			width:150px;
			color:darkred;
			 
			text-align:center;
			margin:50px auto;
			font-family:"微软雅黑";
			
		}
		body{
		background-image:url(./images/b.gif);
		background-repeat:no-repeat; 
		background-size:cover;
		margin:0px;
		
		background-position:50% 50%;
		}

</style>

<title>顶部</title>


</head>

<body>
<body style="text-align:center;background-image:url(./images/b.gif);
		background-repeat:no-repeat;">
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
	
    <div id="hua" style="float:right;margin-right:10%;">
    <div class="input">
        <input type="text" id="search" name="ch"/>
        <span  id="cls" class="clear">X</span>
    </div>
    <input type="button"   value="搜索" id="button" 
    onclick="test()">
  
</div>
   
<script type="text/javascript">
function test(){
var ss=document.getElementById("search").value;
url="client/SearchServlet?ch="+ss;
window.parent.location.href=url;



}
document.getElementById("search").addEventListener("keyup",function(){
	if(this.value.length>0)
	{
		document.getElementById("cls").style.visibility="visible";
		document.getElementById("cls").onclick=function()
		{
			document.getElementById("search").value="";
		}
	}else
	{
		document.getElementById("cls").style.visibility="hidden";
	}
});
</script>
	
</body>
</html>
