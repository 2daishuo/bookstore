<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.2.js"> </script>
  </head>
  

    <frameset rows="27%,*" frameborder="0" >
	<frame name="top" style="scrollbars :no;"src="${pageContext.request.contextPath}/jsps/user/top.jsp">
	<frame name="right"src="${pageContext.request.contextPath}/client/IndexServlet?method=getAll">
   
                                                                                                                
 
</frameset>

    

</html>
