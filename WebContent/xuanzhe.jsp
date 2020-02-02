<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'xuanzhe.jsp' starting page</title>
  </head>
  <body>
  <from action=""method="post"style="padding-top:-700px;" >
  <h2>属性选择:</h2>
  姓名 ：<input name="name"type="text"id="na" size="50">
  年龄 ：<input name="year"type="text"id="ye" size="50">
  经验 ：<input name="exp"type="text"id="ex" size="50">
 姓名 ：<input name="job"type="text"id="jo" size="50"> 
  </from>
  
			<form action="ZhuceServlet"method="post" style="padding-top:-700px;">
	   输入用户名:<input name="name" type="text"><br><br>
	   输入密码:<input name="pwd" type="password"><br><br>
	   选择性别:<input type="radio"name="sex"value="男"checked>男
	        <input type="radio"name="sex"value="女">女<br><br>
	   选择家乡:
	   <select name="home">
		   <option value="上海">上海</option>
		   <option value="北京" selected>北京</option>
		   <option value="纽约">纽约</option>
   		</select><br>
               填写个人信息:<br>
	   <textarea name="info" row="5"cols="30"></textarea><br>
	   <input type="reset"value="重置"><input type="submit"value="注册">
   </form>
			
  </body>
</html>
