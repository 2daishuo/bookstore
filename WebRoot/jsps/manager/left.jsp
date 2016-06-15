<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台左侧导航</title>	
     
    <style>
 

body {
	font-family:arial, sans-serif;
	font-weight:normal;
	font-size:14px;
	background:#f1eddd;	
}

ul {
	list-style:none;
	margin:0; 
	padding:0;
	width:300px;
	margin:0 auto;
	
}

ul li label {
	background:#f1eddd;
	border-top:1px solid #d0f7fc;
	border-bottom:1px solid #d0f7fc;
	color: #fff;
	text-shadow: 0 1px 1px #000;
	letter-spacing: 0.09em;

}

ul li input[type='checkbox'] {
	display: none;
}

ul li label {
	display:block;
	padding:12px;
	width:300px;
}



ul li label:hover {
	background: #4bff12; 
	
}



ul li input[type='checkbox']:checked ~ label {
	background: #d0f7fc; 
	border-top:1px solid #878e98;
	border-bottom:1px solid #2799db;
	
}


ul li input[type='checkbox']:checked ~ .options {
	height: auto;
	display:block;
	min-height:40px;
	max-height:400px;
}

ul ul {
	background:#fff; margin:0; padding:0;
	
}

ul ul li a {
	display:block;
	padding:6px 12px;
	color:#999;
	text-decoration:none;
}

ul ul li a:hover {
	color:#44c6eb;
}



ul ul li {
	border-bottom:1px solid #ccc;
}

ul ul li:first-child {
	padding-top:6px;
}

ul ul li:last-child {
	padding-bottom:6px; border:0;
}

.options {
	height: 0;
	display: block;
	overflow: hidden;
}
	






    </style>

  </head>
  
  <body>
   <ul>
   <li class="block">
   <input type="checkbox" name="item" id="item1" />   
		<label for="item1"> 分类管理</label>
		<ul class="options">
			<li><a href="${pageContext.request.contextPath}/jsps/manager/addcategory.jsp" target="right"> 添加分类</a></li>
			<li><a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=listall" target="right"> 查看分类</a></li>

		</ul>
	</li>

  <li class="block">
		<input type="checkbox" name="item" id="item2" />
		<label for="item2"> 图书管理 </label>
		<ul class="options">
			<li><a href="${pageContext.request.contextPath}/manager/BookServlet?method=addUI" target="right"> 添加图书 </a></li>
			<li><a href="${pageContext.request.contextPath}/manager/BookServlet?method=list" target="right"> 查看图书 </a></li>
		
		</ul>
	</li>
	<li class="block">
		<input type="checkbox" name="item" id="item3" />   
		<label for="item3"> 订单管理 </label>
		<ul class="options">
			<li><a href="${pageContext.request.contextPath}/manager/ListOrderServlet?state=2" target="right" > 查看已发货的订单</a></li>
			<li><a href="${pageContext.request.contextPath}/manager/ListOrderServlet?state=1" target="right"> 查看没发货的订单</a></li>
			<li><a href="${pageContext.request.contextPath}/manager/ListOrderServlet?state=0" target="right" > 查看未付款的订单</a></li>
			<li><a href="${pageContext.request.contextPath}/manager/ListOrderServlet?state=3" target="right" > 查看确认收货的订单</a></li>
		</ul>
	</li>
 </ul>
  </body>
</html>
