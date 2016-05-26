<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
	function setMethod(method) {
		var ele = document.getElementById("method");
		ele.value = method;
	}
</script>
    <base href="<%=basePath%>">
    
    <title>图书详细</title>
 
	
  </head>
  
  <body>
    <div style="float:left; margin:20px;border: solid 1px black;">
    <img src="${pageContext.request.contextPath}/images/${book.image }" border="0"/>
  </div>
  <form style="margin:20px;width:600px;float: right;height:500px; border: 1px solid red" id="form" action="${pageContext.request.contextPath}/manager/BookServlet" method="post">
  	<input type="hidden" name="method" value="" id="method"/>
  	<input type="hidden" name="bid" value="${book.bid }"/>
  	<input type="hidden" name="image" value="${book.image }"/>
  	图书名称：<input type="text" name="bname" value="${book.bname }"/><br/>
  	图书单价：<input type="text" name="price" value="${book.price }"/>元<br/>
  	图书作者：<input type="text" name="author" value="${book.author }"/><br/>
  	图书分类：<select style="width: 150px; height: 20px;" name="category_id">
<c:forEach items="${categoryList }" var="c">
     		<option value="${c.cid }" <c:if test="${c.cid eq book.category_id }">selected="selected"</c:if>  >${c.cname }</option>
</c:forEach>
    	</select><br/>
    	<textarea rows="5" clos="120"style="width:500px;height:300px;" name="description">${book.description }</textarea>
  	<br>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="submit" value="删除" onclick="setMethod('bookDelete')"/>
  	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="submit" value="编辑" onclick="setMethod('bookUpdate')"/>
  </form>
  </body>
</html>
