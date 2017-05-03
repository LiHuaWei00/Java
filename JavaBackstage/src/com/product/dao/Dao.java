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
	//���ݿ����������
	private Connection con = null;
	private Statement s= null;
	/**�����ݿ�*/
	private void open() throws Exception{
		Class.forName(DRIVER);//��������
		//ʵ��������
		con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//��ȡ���ݲ�������
		s=con.createStatement();
		
	}
	/**�ر����ݿ�*/
	public void close() throws Exception{
		if(!con.isClosed()){
			con.close();
		}
	}
	/**�޸�����(����sql����޸����ݲ�����Ӱ������)*/
	public int update(String sql) throws Exception{
		this.open();
		int count =s.executeUpdate(sql);
		return count;
	}
	/**��ѯ����(����SQL��䷵�ؽ������)*/
	public ResultSet query(String sql) throws Exception{
		this.open();
		return s.executeQuery(sql);
	}
	//���ֺ��ַ������ж�
		public static boolean isNumeric(String str) {  
			  for (int i = str.length(); --i >= 0;) {     
			   if (!Character.isDigit(str.charAt(i))) {  
			    return false;  
			   }  
			  }  
			   return true;  
		}
}
