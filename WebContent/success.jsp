<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'success.jsp' starting page</title>
  </head>
  <body>
			${xiaoxi} <br>  
			<a href="add.jsp">创建表</a>
			<a href="insert.jsp">插入数据</a>
			<br>
			
			
			<form action="showall.jsp" method="post">
  <tr>
	     <td>填写数据：<input type="text"  name="hhh"></td>
	  
	   </tr>
	   <br>

<input type="submit" value="确定">
</form>
   
			
			
  </body>
</html>
