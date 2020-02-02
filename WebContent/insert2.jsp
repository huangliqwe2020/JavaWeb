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
  <% 
String table=request.getParameter("table");
UserDaoImpl us=new UserDaoImpl();
List<String>list=new ArrayList<String>();%>
  
			 插入数据：	<br>
      <form action="InsertServlet" method="post"> 
      
	 <tr>
	 <td><input type="text" value="<%=table %>"  name="table"></td><br>
	 <% for(int a=0;a< us.xiala(list,table).size();a++) {%> 
	
	    <td>向:<select name="<%=a%>">  
 

<% 
  
for(int i=0;i< us.xiala(list,table).size();i++){%>
 
 <option value="<%= us.xiala(list,table).get(i)%>"><%= us.xiala(list,table).get(i)%></option>
 
<%}%>
 
</select>

	    中</td>
	     <td>插入:<input type="text"  name="<%="value"+a%>"></td>
	          
	    </tr> 
	    <br>
	    <%} %>
	   
	   
	  


	    
	    <br>
	     
	    <td><input type="submit" value="提交"/></td>
 </form>
 <a href="success.jsp">返回成功界面</a>
   
  </body>
</html>
