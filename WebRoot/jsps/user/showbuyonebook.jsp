<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>一本书</title>
    


  </head>
  
  <body>
     <div style="float:left; margin:20px;border: solid 1px black;">
    <img src="${pageContext.request.contextPath}/images/${book.image }" border="0"/>
  </div>
  <form style="margin:20px;width:600px;float: right;height:500px; border: 1px solid red" id="form" action="${pageContext.request.contextPath}/client/BuyServlet" method="post">
  	
  	<input type="hidden" name="bid" value="${book.bid }"/>
  	<input type="hidden" name="image" value="${book.image }"/>
  	图书名称：<input type="text" name="bname" readonly="readonly" value="${book.bname }"/><br/>
  	图书单价：<input type="text" name="price" readonly="readonly" value="${book.price }"/>元<br/>
  	图书作者：<input type="text" name="author" readonly="readonly" value="${book.author }"/><br/>
  	图书数量：<input type="text" name="quantity"  value="1"/>
  	<br/>
           图书简介：<br>
           <textarea rows="5" clos="120" readonly="readonly" style="width:500px;height:300px;" name="description">${book.description }</textarea>
  	<br>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
  	<input type="submit" value="加入购物车"/>

  </form>
  </body>
</html>
