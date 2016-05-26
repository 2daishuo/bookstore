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
    
    <title>用户详细信息修改</title>    
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/userdetali.js"> </script>
	
	 

  </head>
  <!-- onload="start()" -->
  <body  >
  <form action="${pageContext.request.contextPath }/client/UpdateuserServlet"method="post" onsubmit="return dosubmit()" id="user">
   <table width="55%" border="1" >
    
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
