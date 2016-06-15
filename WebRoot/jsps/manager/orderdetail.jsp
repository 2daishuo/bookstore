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
    
    <title>订单明细</title>
 

  </head>
  
  <body>
   <h3>订单明细</h3>
    <table frame="border" width="70%">
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
    	
    	<tr>
    		<td>订单总价</td>
    		<td colspan="3">${order.totalprice }元</td>
    	</tr>
    </table>
    
    <br/><br/>
     <h3>收货人信息</h3>
    <table frame="border"  width="70%">
    	<tr>
    		<td>用户</td>    	
    		<td>邮箱</td>
    		<td>地址</td>
    	</tr>
    	
    	<tr>
    		<td>${order.user.username }</td>
    		
    		<td>${order.user.email }</td>
    		<td>${order.address}</td>
    	</tr>
    
    </table>
    
    <c:if test="${order.state==1}">
      <a href="${pageContext.request.contextPath }/manager/ManagerConfirmOrderStateIs2?orderid=${order.oid}">确认发货</a>
    </c:if>
  </body>
</html>
