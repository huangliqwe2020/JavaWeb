<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'cretable.jsp' starting page</title>
  </head>
  <body>
  <h1>${xiaoxi}</h1><br>
	 <br>
	 表名称：	
<form action="CreateServlet" method="post">
  <tr>
	     <td>tablename:<input type="text"  name="nam"></td>
	  
	   </tr>
	   <br>
<%
String a=request.getParameter("aa");
int i=Integer.parseInt(a);
for(int q=0;q<i;q++){ %>
属性：<input type="text" name="<%=q%>"><br>
<% }%>
再次填写列的数量<input type="text" name="hh">
<input type="submit" value="确定">
</form>
   
  </body>
</html>
