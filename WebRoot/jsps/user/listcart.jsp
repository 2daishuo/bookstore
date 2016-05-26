<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>购物车</title>
  </head>  
  <body style="text-align: center">
  <h2> 购物车列表</h2>
  <c:choose>
  
  <c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.map)eq 0 }">
  kongche
  </c:when>
  <c:otherwise>
  
  
 
  	<table width="80%" frame="border">
  	<tr> <td colspan="7" align="right" style="font-size:15px;font-weight:900">
  	<a href="${pageContext.request.contextPath }/client/deleteCartServlet?method=clearAllCart">删除</a>
  	
  	</td></tr>
  	
    		<tr>
    		   <td>图片</td>
    			<td>书名</td>
    			<td>作者</td>
    			<td>单价</td>
    			<td>数量</td>
    			<td>小计</td>
    			<td>
    				
    			</td>
    		</tr>
    		
    		<c:forEach var="me" items="${cart.map}">
    			<tr>
    			    <td><img src="${pageContext.request.contextPath }/images/${me.value.book.image}" height="75"/></td>
	    			<td>${me.value.book.bname }</td>
	    			<td>${me.value.book.author }</td>
	    			<td>${me.value.book.price }</td>
	    			<td>${me.value.quantity }</td>
	    			<td>${me.value.price }</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath }/client/deleteCartServlet?method=clearItemCart&bookid=${me.value.book.bid}">删除</a>
	    			</td>
    			</tr>
    		</c:forEach>
    		
    		
    	
    		<tr>
    		 <td colspan="7" align="right" style="font-size:15px;font-weight:900">
    		
    		总价${cart.price }
    		
    		</td>
    		</tr>
    	</table>
    	 <a href="${pageContext.request.contextPath }/client/OrderServlet">下订单单结算</a>
    	&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll">继续购物</a>
    	
 </c:otherwise>
  </c:choose>
  </body>
</html>
