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
    
    <title>我的订单</title>
    
	
  </head>
  
  <body >
  	<c:forEach var="order" items="${orders}">
   <table frame="border" width="70%" style="text-align: center;">
    	<tr bgcolor="green" bordercolor="green">
    	<td colspan="4">
    	订单编号：${order.oid} 成交时间 ：  ${order.ordertime} 金额：<font color="red">${order.totalprice }元</font>
    	订单状态：
    	<c:choose>
    	<c:when test="${order.state eq 0 }">
    	<a href="#">付款</a>
    	</c:when>
    	<c:when test="${order.state eq 1 }">等待发货</c:when>
    	<c:when test="${order.state eq 2 }">
    	确认收货</c:when>
    	<c:when test="${order.state eq 3 }">
    	交易成功
    	</c:when>
    	
    	</c:choose>
    	</td>
    	</tr>
    	<tr>
    		<td>书名</td>
    		<td>售价</td>
    		<td>数量</td>
    		<td>应收货款</td>
    		
    	</tr>
    	
    	<c:forEach var="orderitem" items="${order.orderitems}">
    		<tr>
	    		<td>${orderitem.book.bname }</td>
	    		<td>${orderitem.book.price }</td>
	    		<td>${orderitem.quantity }</td>
	    		<td>${orderitem.subtotal }</td>
	    		
    		</tr>
    	</c:forEach>
    	<tr bgcolor="green" bordercolor="green">
    	<td colspan="4"><h3>收货人信息</h3></td>
    	</tr>
    	<tr>
    		<td>用户名</td>
    		<td colspan="3">${order.user.username }</td>
    	</tr>
    	<tr>
    		<td>地址</td>
    		<td colspan="3">${order.user.email }</td>
    	</tr>
    </table>
    <br/><br/>
    
    </c:forEach>
    
    <br/><br/>
     
 
  </body>
</html>
