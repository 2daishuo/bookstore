<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style>
body{
	margin:0px auto;
  padding:0px;
  text-align:center;
	
}
</style>
    <title>添加图书</title>
      </head>  
<body >
<form method="post" action="${pageContext.request.contextPath}/manager/BookServlet?method=add" enctype="multipart/form-data">
<table style="border:1px solid black;">
<tr>
<td>图书名称</td>
<td><input type="text" name="bname"></td>
</tr><br> <br>
<tr>
<td>作者</td>
<td><input type="text" name="author"></td>
</tr>
<br/> <br/>
<tr>
<td>售价</td>
<td><input type="text" name="price"></td>
</tr>
<br> <br>
<tr>
<td>图面</td>
<td><input type="file" name="file"></td>
</tr>
<br> <br>
<tr>
<td>描述</td>
<td><textarea rows="5" clos="40" name="description"></textarea></td>
</tr>
<br> <br>
<tr>
   			<td>所属分类</td>
   			<td>
   				<select name="category_id">
   				
   					<c:forEach var="c" items="${category}">
   					
   						<option value="${c.cid }">${c.cname }</option>
   					</c:forEach>
   				</select>
   			</td>
   		</tr>
<tr>
<td><input type="reset" value="重置"></td>
<td><input type="submit"  value="添加"></td>
</tr>

</table>
</form>
  </body>
</html>
