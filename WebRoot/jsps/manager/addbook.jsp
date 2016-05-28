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
    background: #f2eede;
    }

form {
margin-left:180px;
margin-right:auto;
margin-top:-10px;
max-width: 500px;
background: #F8F8F8;
padding: 30px 30px 20px 30px;
font: 12px Arial, Helvetica, sans-serif;
color: #666;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
h2 {
font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 20px 0px 20px 40px;
display: block;
margin: -40px -30px 10px -30px;
color: #FFF;
background: #d0f7fc;
text-shadow: 1px 1px 1px #949494;
border-radius: 5px 5px 0px 0px;
-webkit-border-radius: 5px 5px 0px 0px;
-moz-border-radius: 5px 5px 0px 0px;
border-bottom:1px solid #89AF4C;

}


 label {
display: block;
margin: 0px 0px 5px;
}
span {
float: left;
margin-top: 10px;
color: #5E5E5E;
}
input[type="text"],input[type="email"], textarea, select {
color: #555;
height: 30px;
line-height:15px;
width: 100%;
padding: 0px 0px 0px 10px;
margin-top: 2px;
border: 1px solid #E5E5E5;
background: #FBFBFB;
outline: 0;
-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
font: normal 12px/12px Arial, Helvetica, sans-serif;
}
textarea{
height:100px;
padding-top: 10px;
}
 select {
appearance:none;
text-indent: 0.01px;
text-overflow: '';
width:100%;
height:30px;
}
input[type="submit"],input[type="reset"] {
background-color: #9DC45F;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-border-radius: 5px;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
text-shadow: 1px 1px 1px #949494;
}
input[type="reset"]:hover {
background-color:#80A24A;
}
input[type="submit"]:hover {
background-color:#80A24A;
}
</style>
    <title>添加图书</title>
      </head>  
<body >

<form class="smart-green"  method="post" action="${pageContext.request.contextPath}/manager/BookServlet?method=add" enctype="multipart/form-data">

<h2>添加图书</h2>
<label>
<span>书名：</span><input type="text" name="bname">
</label>
<label>
<span>
作者：</span><input type="text" name="author">
</label>
<lable>
<span>售价：</span>
<input type="text" name="price">
</lable>


<label><span>所属分类</span>	<select name="category_id">
   				
   					<c:forEach var="c" items="${category}">
   					
   						<option value="${c.cid }">${c.cname }</option>
   					</c:forEach>
   				</select>
   			</label>
   		
<label><span>描述</span>
<textarea rows="5" clos="40" name="description"></textarea>
</label>

<br>
<label>
<span>图片：</span>
<input type="file" name="file">
</label>
<br>
<lable>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span> 
<input type="submit"  value="添加">
</lable>



</form>

  </body>
</html>
