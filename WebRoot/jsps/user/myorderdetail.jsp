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
    	<tr>
    		<td>书名</td>
    		<td>售价</td>
    		<td>数量</td>
    		<td>应收货款</td>
    		<td>订单时间</td>
    	</tr>
    	
    	<c:forEach var="orderitem" items="${order.orderitems}">
    		<tr>
	    		<td>${orderitem.book.bname }</td>
	    		<td>${orderitem.book.price }</td>
	    		<td>${orderitem.quantity }</td>
	    		<td>${orderitem.subtotal }</td>
	    		<td>${order.ordertime}</td>
    		</tr>
    	</c:forEach>
    	
    	<tr>
    		<td>订单总价</td>
    		<td colspan="3">${order.totalprice }元</td>
    	</tr>
    </table>
    <br/><br/>
    
    </c:forEach>
    
    <br/><br/>
     <h3>收货人信息</h3>
     <c:forEach var="order" items="${orders}">
    <table frame="border"  width="70%">
    	<tr>
    		<td>用户</td>    	
    		<td>邮箱</td>
    	</tr>
    	
    	<tr>
    		<td>${order.user.username }</td>
    		
    		<td>${order.user.email }</td>
    	</tr>
    
    </table>
    </c:forEach>
  </body>
</html>
