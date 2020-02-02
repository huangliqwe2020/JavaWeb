package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 




import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
 
public class CreateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String nam = request.getParameter("nam"); 
		
		UserDaoImpl ui = new UserDaoImpl();
		ui.createtable(nam);
		
		List<String> list=new ArrayList<String>();
		String qq=request.getParameter("hh");
		int q=Integer.parseInt(qq);
		  for(int i=0;i<q;i++){
			  String b=String.valueOf(i);
			  String a=request.getParameter(b);
			  list.add(a);
			  ui.addColumn(nam, a);
		  }
		  
			request.setAttribute("xiaoxi",nam+"的表创建成功");  //向request域中放置参数
			
			request.getRequestDispatcher("/success.jsp").forward(request, response);  //转发到登录页面
	}
}
