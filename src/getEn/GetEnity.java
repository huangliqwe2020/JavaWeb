package getEn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import com.util.DBconn;
public class GetEnity {
private String tablename="user";
private String[] colnames;
private String[] colTypes;
private int [] colSizes;
private boolean f_util=false;
private boolean f_sql=false;
private static final String URL="jdbc:mysql://localhost:3306/bishe1?&useSSL=false&serverTimezone=UTC";
private static final String name="root";
private static final String password="123456";
private static final String driver="com.mysql.cj.jdbc.Driver";
private static Connection conn;
public GetEnity(){
	
	
	
	
	try {
		
		Class.forName(driver);
	conn=DriverManager.getConnection(URL,name,password);
	System.out.print("success");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	PreparedStatement ps;
	 String sql = "select * from " + tablename;
		try{
		ps = conn.prepareStatement(sql);
		ResultSetMetaData rsmd=ps.getMetaData();
		int size =rsmd.getColumnCount();
		colnames=new String[size];
		colTypes=new String[size];
		colSizes=new int[size];
		for(int i=0;i<size;i++){
			colnames[i]=rsmd.getColumnName(i+1);
			colTypes[i]=rsmd.getColumnTypeName(i+1);
			if(colTypes[i].equalsIgnoreCase("datetime")){
				f_util=true;
			}
			if(colTypes[i].equalsIgnoreCase("image")||colTypes[i].equalsIgnoreCase("text")){
				f_sql=true;
			}
			colSizes[i]=rsmd.getColumnDisplaySize(i+1);
		}
		
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try{
			String content=parse(colnames,colTypes,colSizes);
		File directory=new File("");
		String path=this.getClass().getResource("").getPath();
		System.out.print(path);
		FileWriter fw=new FileWriter(directory.getAbsolutePath()+"/src/"+path.substring(path.lastIndexOf("/getEn/",path.length()),path.length())+initcap(tablename)+".java");
		PrintWriter pw=new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
}
private String parse(String[] colnames,String[]colTypes,int[]colSizes){
	StringBuffer sb=new StringBuffer();
	if(f_util){
		sb.append("import java.util.Date;\r\n");
	}
	if(f_sql){
		sb.append("import java.sql.*;\r\n");	
	}
	sb.append("package getEn;");
	sb.append("\r\n");
	sb.append("\r\n\r\npublic class "+initcap(tablename)+"{\r\n");
	processAllAttrs(sb);
	processAllMethod(sb);
	sb.append("}\r\n");
	return sb.toString();
	
}
private void processAllAttrs(StringBuffer sb){
	for(int i=0;i<colnames.length;i++){
		sb.append("\tprivate "+sqlType2JavaType(colTypes[i])+" "+colnames[i]+";\r\n");
		
	}
}
private void processAllMethod(StringBuffer sb){
	for(int i=0;i<colnames.length;i++){
		sb.append("\tpublic void set"+initcap(colnames[i])+"("+sqlType2JavaType(colTypes[i])+" "+colnames[i]+"){\r\n");
		sb.append("\tthis."+colnames[i]+"="+colnames[i]+";\r\n");
		sb.append("\t}\r\n");
		sb.append("\tpublic "+sqlType2JavaType(colTypes[i])+" get"+initcap(colnames[i])+"(){\r\n");
		sb.append("\t\treturn "+colnames[i]+";\r\n");
		sb.append("\t}\r\n");
		
	}
}
private String initcap(String str){
	char []ch=str.toCharArray();
	if(ch[0]>='a'&&ch[0]<='z'){
		ch[0]=(char)(ch[0]-32);
	}
	
	return new String(ch);
}
private String sqlType2JavaType(String sqlType){
	if(sqlType.equalsIgnoreCase("bit")){
		return "boolean";
	}
	else if(sqlType.equalsIgnoreCase("tinyint")){
		return "byte";
	}
	else if(sqlType.equalsIgnoreCase("smallint")){
		return "short";
	}
	else if(sqlType.equalsIgnoreCase("int")){
		return "int";
		
	}
	else if(sqlType.equalsIgnoreCase("bigint")){
		return "long";
	}
	else if(sqlType.equalsIgnoreCase("float")){
		return "float";
	}else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
		    || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
		    || sqlType.equalsIgnoreCase("smallmoney")){
		   return "double";
		  }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
		    || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
		    || sqlType.equalsIgnoreCase("text")){
		   return "String";
		  }else if(sqlType.equalsIgnoreCase("datetime")){
		   return "Date";
		  }else if(sqlType.equalsIgnoreCase("image")){
		   return "Blod";
		  }
		  
		  return null;
		 
	
}
public static void main(String[] args){
	new GetEnity();
}
}
