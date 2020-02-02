package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 




import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DUserDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
 
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	   String id=request.getParameter("id");
	   int id1 = Integer.parseInt(id);
		/*String jisuan = request.getParameter("jisuan"); 
		int jisuan1=Integer.parseInt(jisuan);
	List<Integer> list=new ArrayList<Integer>();
	 list.add(jisuan1);
	int sum=0;
		for(int i=0;i<list.size();i++){
		
			sum=sum+list.get(i);
		}
	String s=String.valueOf(sum);*/
		
	DUserDaoImpl ud=new DUserDaoImpl();
		String as=ud.select(id1);
		
			request.setAttribute("sum",as);  //向request域中放置参数
			//request.setAttribute("xiaoxi", "注册成功");
			request.getRequestDispatcher("/showall.jsp").forward(request, response);  //转发到登录页面
		
	}
}
