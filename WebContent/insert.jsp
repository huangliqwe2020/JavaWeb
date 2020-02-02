<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<%@ page import="com.dao.UserDaoImpl" %>
<%@ page import="com.servlet.Asd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'insert.jsp' starting page</title>
  </head>
  <body>
  <h1>${xiaoxi}</h1><br>
			 插入数据：	
      <form action="insert2.jsp" method="post"> 
      
	     <tr>
	   
	   <td>插入表:<input type="text"  name="table"></td>
	   <td><input type="submit" value="提交"/></td>
	   </tr>
	   </form><br>
	<br><a href="success.jsp">返回上一级</a>
   
  </body>
</html>
