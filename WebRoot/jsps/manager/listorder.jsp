<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单显示</title>
  
  </head>
  
  <body>
   <body style="text-align: center;">
  		<br/>
  		<h2>订单列表</h2>
  		
    	<table width="80%" frame="border" class="table table-hover">
    		<tr>
    			<td>订单号</td>
    			<td>订单人</td>
    			<td>订单时间</td>
    			<td>订单总价</td>
    			<td>订单状态</td>
    			<td>操作</td>
    		</tr>
    		
    		<c:forEach var="order" items="${orders}">
    			<tr>
	    			<td>${order.oid }</td>
	    			<td>${order.user.username }</td>
	    			<td>${order.ordertime }</td>
	    			<td>${order.totalprice }</td>
	    			<td>
	    			<c:choose>
	    			<c:when test= "${order.state==0}">未付款</c:when>
	    			<c:when test= "${order.state==1}">未发货</c:when>
	    			<c:when test= "${order.state==2}">已发货</c:when>
	    			<c:otherwise>未知</c:otherwise>
	    			</c:choose>
	    			
	    			</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath}/manager/OrderDetailServlet?orderid=${order.oid}">查看明细</a>
	    				<!-- <a href="#">删除</a> -->
	    			</td>
    			</tr>
    		</c:forEach>
    		
    	
    	</table>
  </body>
</html>
