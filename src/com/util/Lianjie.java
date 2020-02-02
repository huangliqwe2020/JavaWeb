
package com.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.*;

public class Lianjie {
    public static void main(String[] args){
    // 加载数据库驱动  com.mysql.jdbc.Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // 获取mysql连接地址
       String url = "jdbc:mysql://localhost:3306/bishe1?&useSSL=false&serverTimezone=UTC";
        // 数据名称
       String username = "root";
        // 数据库密码
        String password = "";
        // 获取一个数据的连接
        Connection conn = null;
        // 获取连接的一个状态
       
    	
        try{
            Class.forName(driver);
            //getConnection()方法，连接MySQL数据库！
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
            System.out.println("数据库连接成功！");
             //创建statement类对象，用来执行SQL语句！
            Statement Statement=conn.createStatement();
            //要执行的SQL语句
            String sql="select * from user" ;
            //ResultSet类，用来存放获取的结果集！
            ResultSet rs=Statement.executeQuery(sql);
             System.out.println("-------------------------------");
             System.out.println("执行结果如下所示:");  
             System.out.println("-------------------------------");  
             System.out.println("id" + "\t" + "name"+"\t"+"pwd"+"\t"+"sex");  
             System.out.println("-------------------------------");  
             String id=null;
             String name=null;
             String math=null;
             String chinese=null;
             while(rs.next()){
                //获取‘学号’这列数据
                 id=rs.getString("id");
                 //获取‘姓名’这列数据
                name=rs.getString("name");
                //获取‘数学成绩’这列数据
                math=rs.getString("pwd");
                //获取‘语文成绩’这列数据
                chinese=rs.getString("sex");
                //输出结果
                System.out.println(id+"\t"+name+"\t"+math+"\t"+chinese);
             }
           String qwe="工资表";
           String shuxing="年龄";
           String sql1 = "alter TABLE `"+qwe+"` add column "+shuxing+" varchar(10)";
       
      //  Statement.execute(sql1);
        //UserDaoImpl ps=new UserDaoImpl();
       // ps.createtable(qwe);
          List<String>list=new ArrayList<String>();
           System.out.println("dfsf");
           rs=Statement.executeQuery("select * from "+qwe);
           ResultSetMetaData rsmd=rs.getMetaData();//得到元组列数
           int size=rsmd.getColumnCount();
           for(int i=1;i<=size;i++)
        	   {
        	   list.add(rsmd.getColumnName(i));
           System.out.print(list.get(i-1)+"\n");
           }
             rs.close();
             conn.close();
        }
         catch(ClassNotFoundException e){
             //数据库驱动类异常处理
        System.out.println("数据库驱动加载失败！");
        e.printStackTrace();
         }
        catch(SQLException e1){
        //数据库连接失败异常处理
         e1.printStackTrace();
        }
        catch(Exception e2){
        e2.printStackTrace();
        }
        finally{
             System.out.println("-------------------------------");  
            System.out.println("数据库数据获取成功！");
        }
        }
        }


