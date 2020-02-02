package com.dao;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 




import com.entity.User;
import com.util.DBconn;
 
public class UserDaoImpl implements UserDao{
	public void addColumn(String nam,String shuxing){
		DBconn.init();
		DBconn.addColumn("alter TABLE `"+nam+"` add column "+shuxing+" varchar(255)default NULL");
		DBconn.closeConn();
	}
	public List<String> xiala(List<String> list,String tableNam) {
		DBconn.init();
		  list=new ArrayList<String>();
		
		  List<String> qwe=new ArrayList<String>();
		  for(int i=0; i<DBconn.select("select * from "+tableNam,list).size();i++)
		    qwe.add(i,DBconn.select("select * from "+tableNam,list).get(i)) ;
		  DBconn.closeConn();
return qwe;
	}
	public void insert(String table,String column, String value){
		DBconn.init();
		DBconn.addColumn("insert into "+table+"("+column+")values('"+value+"')");
		DBconn.closeConn();
	} 
	public void createtable(String nam){
		//boolean flag=false;
		DBconn.init();
		
		
		//if(flag=false){
	DBconn.createTable("CREATE TABLE `"+nam+"` (  `key` varchar(255) default NULL)");
	//flag=true;
		
	//return flag;
	DBconn.closeConn();
	
	}
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into user(name,pwd,sex,home,info) " +
				"values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
    public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<User> getUserAll() {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id1"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setHome(rs.getString("home"));
				user.setInfo(rs.getString("info"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
	}
	public boolean update1(String table,String column, String value,String id) {
		boolean flag = false;
		DBconn.init();
		//UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson' 
		String sql ="update "+table+" set "+column+"='"+value+"' where key="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean update(int id,String name, String pwd,String sex, String home,String info) {
		boolean flag = false;
		DBconn.init();
		String sql ="update user set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , home ='"+home
				+"' , info ='"+info+"' where id = "+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from user where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
    

}