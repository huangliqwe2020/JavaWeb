package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 



import com.dao.DUserDao;
//import com.dao.DUserDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.Caa;
import com.entity.User;
 
public class Searchall extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//DUserDao ud = new DUserDaoImpl();
		//List<Caa> userAll = ud.getUserAll();
		//request.setAttribute("userAll", userAll);
		request.getRequestDispatcher("/showall.jsp").forward(request, response);
	}
}
