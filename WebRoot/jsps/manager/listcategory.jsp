<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>列出所有分类</title>
 
  <style type="text/css">
     body{
    background: #f2eede;
    font-family:arial, sans-serif;
	font-weight:normal;
	font-size:12px;
	
	letter-spacing: 0.09em;
    }
    table {
        border-collapse: collapse;
        width: 50em;
        border: 1px solid #fff;
    }
     caption {
        font-size: 1.2em;
        font-weight: bold;
        margin: 1em 0;
    }
     col {
        border-right: 1px solid #ccc;
    }
    th {
        font-weight: normal;
        text-align: left;
    }
      tr:hover {
        background-color:#edf5ff;
        color:green;
    }
     th, td {
        padding: 0.1em 0.5em;
    }
    thead tr:hover {
        background-color: transparent;
        color: inherit;
    } 
     .odd {
        background-color:#f2eede;
          border: 1px solid #fff;
    }
      col#albumCol {
        border: none;
    }
    
    </style>
    

</head>

<body style="text-align: center">

	<table >
	<caption>显示分类</caption>
	 <colgroup>
        <col  />
        <col />
        <col  />
        <col id="albumCol" />
    </colgroup>
	 <thead>
		<tr  scope="col">
		
			<th>分类名称</th>
			<th>分类描述</th>
			<th colspan="2">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${categorys}">
			<tr class="odd">
			  
				<td>${c.cname}</td>
				<td>${c.description}</td>
				<td>
				<a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=delete&cid=${c.cid}" onclick="return confirm('您真要删除？')"><span style="display:inline-block;width:40px;height:25px;background-color:green;font-size:14px;font-family:'Simsun';text-align:center;color:white;line-height:25px">删除</span></a>
				</td>
				<td>
				<a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=updatepre&cid=${c.cid}""><span style="display:inline-block;width:40px;height:25px;background-color:red;font-size:14px;font-family:'Simsun';text-align:center;color:white;line-height:25px">修改</span></a>
				</td>
			</tr>


		</c:forEach>
</tbody>

	</table>
</body>
</html>
