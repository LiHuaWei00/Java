package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {
	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/jsptest1";
	private final String USERNAME="root";
	private final String PASSWORD="huazi123";
	//数据库操作类引用
	private Connection con = null;
	private Statement s= null;
	/**打开数据库*/
	private void open() throws Exception{
		Class.forName(DRIVER);//加载驱动
		//实例化对象
		con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//获取数据操作对象
		s=con.createStatement();
		
	}
	/**关闭数据库*/
	public void close() throws Exception{
		if(!con.isClosed()){
			con.close();
		}
	}
	/**修改数据(根据sql语句修改数据并返回影响行数)*/
	public int update(String sql) throws Exception{
		this.open();
		int count =s.executeUpdate(sql);
		return count;
	}
	/**查询数据(根据SQL语句返回结果对象)*/
	public ResultSet query(String sql) throws Exception{
		this.open();
		return s.executeQuery(sql);
	}
	//数字和字符串的判断
		public static boolean isNumeric(String str) {  
			  for (int i = str.length(); --i >= 0;) {     
			   if (!Character.isDigit(str.charAt(i))) {  
			    return false;  
			   }  
			  }  
			   return true;  
		}
}
