<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
    table {   
    border-spacing: 0;}
    
    body{
	padding:0;
	margin:0;
	position:center;	
	letter-spacing:1px;
	font-family:Georgia, "Times New Roman", Times, serif;
}
caption{
	font-size:20px;
	font-weight:normal;	
	padding-top: 20px;
	height:30px;
	 
	 background:#f1eddd;
	}
td {
    border-left: 1px solid #fff;
  
    padding: 10px;
    text-align: left;    
}
tr:nth-child(even) {
     background:#f1eddd;
	color:#2aff8c;
}
 tr:hover *{
    background: #eeeeee;
	color:#000;
}
tr {
	background: #b9d86c;
	color:#fff;
}
    </style>
    <title>用户详细信息修改</title>    
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userdetali.js"> </script>
</head>
  
  <body>
  <form action="${pageContext.request.contextPath }/client/UpdateuserServlet"method="post" onsubmit="return dosubmit()" id="user">
   <table width="40%">
     <caption>用户个人信息修改</caption>
    	<input type="hidden" name="uid" value="${user.uid }">
    	<tr>
    		<td>用户名</td>
    		<td>
    			<input type="text" name="username" value="${user.username}">
    		</td>
    	</tr>
    	
    	<tr>
    		<td>性别</td>
    		<td>
    			<input type="radio" name="gender" value="男" ${user.gender=='男'?'checked':''} >男
    			<input type="radio" name="gender" value="女" ${user.gender=='女'?'checked':''} >女
    		</td>
    	</tr>
    	
    	<tr >
    		<td>生日</td>
    		<td>
    		<select id ="year" onChange="yearChange(this.value)">
		<option value="${fn:split(user.birth,'-')[0] }">${fn:split(user.birth,'-')[0] }</option>
	</select>
	<select name="MM" id ="month" onChange="monthChange(this.value)">
		<option value="${fn:split(user.birth,'-')[1] }">${fn:split(user.birth,'-')[1] }</option>
	</select>
	<select name="DD" id ="day">
		<option value="${fn:split(user.birth,'-')[2] }"  >${fn:split(user.birth,'-')[2] }</option>
	</select>
    		</td>
    	</tr>

    	<tr>
    		<td>手机</td>
    		<td>
    			<input type="text" name="cellphone" value="${user.cellphone }">
    		</td>
    	</tr>
    	
    	<tr>
    		<td>邮箱</td>
    		<td>
    			<input type="text" name="email" value="${user.email }">
    		</td>
    	</tr>
    
    	<tr>
    		<td>爱好</td>
    		<td>
    		<c:forEach var="pre" items="${ preferences }">
    		<input type="checkbox" name="pre" value="${pre}" ${fn:contains(user.preferences,pre) }? 'checked' : ''>${pre}
    		
    		</c:forEach>
    				
    				    			
    		</td>
    	</tr>
      	
    	<tr>
    		<td>
    			<input type="reset" value="清空">
    		</td>
    		<td>
    			<input type="submit" value="提交">
    		</td>
    	</tr>
    
    </table>
    </form>
  </body>
</html>
