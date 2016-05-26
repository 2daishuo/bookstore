<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>当前订单</title>
    
	

  </head>
  
  <body>
  <h1>当前订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			订单编号：${order.oid }　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime }"/>　
			金额：<font color="red"><b>${order.totalprice }元</b></font>
		</td>
	</tr>

<c:forEach items="${order.orderitems }" var="orderItem">
	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="${pageContext.request.contextPath }/images/${orderItem.book.image }" height="75"/></div>
		</td>
		<td>书名：${orderItem.book.bname }</td>
		<td>单价：${orderItem.book.price }元</td>
		<td>作者：${orderItem.book.author }</td>
		<td>数量：${orderItem.quantity }</td>
		<td>小计：${orderItem.subtotal }元</td>
	</tr>
</c:forEach>

</table>
<br/>
<form method="post" action="javascript:alert('别点了，再点就去银行页面了！');" id="form" target="_parent">
	收货地址：<input type="text" name="address" size="50" value="北京市海淀区金燕龙大厦2楼216室无敌收"/><br/>

	选择银行：<br/>
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
	<img src="" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="" align="middle"/>
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="" align="middle"/><br/>
</form>
<a id="pay" href="javascript:document.getElementById('form').submit();">提交</a>
  </body>
</html>
