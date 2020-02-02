<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dao.UserDaoImpl" %>
<%@ page import="com.servlet.Asd" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import=" com.util.DBconn"%>
<%@ page import="com.entity.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>所有用户页面</title>
  </head>
  <% 
  String table=request.getParameter("hhh");  
  UserDaoImpl us=new UserDaoImpl();
  List<String>list=new ArrayList<String>();%> 
  <body>
  <h1><%=table %></h1>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  		<% 
  
for(int i=0;i< us.xiala(list,table).size();i++){%>
 
 <th> <%= us.xiala(list,table).get(i)%> </th>

<%}%>
 
	  		
	  		
  		</tr>

      <form action="" method="post"> 
	      <%
	      
	      try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from "+table+"");
				while(rs.next()){%>
				
		    <tr>
		    		<% 
  
for(int i=0;i< us.xiala(list,table).size();i++){
	String a[]=new String[10];
    a[i]=us.xiala(list,table).get(i);
  
    if(rs.getString(a[i])==null){
    	String q="未填写数据"; %>
    	<td><input	type="text" value="<%=q %>" name="1"></td> 
    	<% 
    }
    else{
%>
 
			   <td><input	type="text" value=<%=rs.getString(a[i])%> name="1"></td>
				
				<% }
    }%>
				 </tr>
				 <br>		
			 
 	
				<% }
				DBconn.closeConn();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	         %>
	      
	         </form> 
	  
	
	    

   
    </tr> 
    <table width="600" border="1" cellpadding="0">
    <tr>
    <th>删除操作</th>
    <th>插入操作</th>
   </tr>
   
    <tr>
    <td>
     <h3>请选出你想在表</h3>
     <form action="DeleteServlet"method="post">
     <input type="text" value="<%=table%>" name="tablenam"><h3>中删除的一行数据，以及其对应的主键</h3><br>
     主键是名称:<input type="text" name="key"><br>
     主键值是:<input type="text" name="keyvalue"><br>
     <input type="submit" value="删除">
     </form>
     </td>
    
     <td>
      <h3>请输入你想在表</h3>
     <form action="UpdateServlet"method="post">
     <input type="text" value="<%=table%>" name="tablenam"><h3>中改变的数据，填写相关数据以便插入</h3><br>
     主键是名称:<input type="text" name="key"><br>
     主键值是:<input type="text" name="keyvalue"><br>
     列名:<input type="text" name="shuxin"><br>
  列的值:   <input type="text" name="value"><br>
     <input type="submit" value="改变">
     </form>
     </td>
     </tr>
     </table>
  </body>
</html>
