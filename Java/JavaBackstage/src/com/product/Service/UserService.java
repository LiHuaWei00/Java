package com.product.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.User;
import com.product.dao.Dao;

public class UserService {
	Dao dao=new Dao();
	public Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/jsptest1?useUnicode=true&characterEncoding=UTF-8";
            String USERNAME = "root";
            String PASSWORD = "huazi123";
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
	public List<User> find(int page){
        List<User> list = new ArrayList<User>();
        Connection conn = getConnection();
        String sql = "select* from tb_user  limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page-1)*User.PAGE_SIZE);
            ps.setInt(2, User.PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User p=new User();
                p.setUid(rs.getString("uid"));
                p.setUname(rs.getString("uname"));
                p.setUpass(rs.getString("upass"));
                p.setUphone(rs.getString("uphone"));
                p.setUe_mail(rs.getString("ue_mail"));
                list.add(p);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
	public int findCount(){
        int count=0;
        Connection conn = getConnection();
        String sql = "select count(*) from tb_user";
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);  //对总记录数赋值
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;        //返回总记录数
    }
	 
	public List<User> ButtonQuery(String s) throws Exception{
		List<User> list=new ArrayList();
		String sql;
		if(dao.isNumeric(s)){
			sql="select * from tb_user where uid='"+s+"'";
		}else{
			sql="select * from tb_user where uname like'%"+s+"%'";
		}
		ResultSet rs=dao.query(sql);
		while(rs.next()){
			User p=new User();
            p.setUid(rs.getString("uid"));
            p.setUname(rs.getString("uname"));
            p.setUpass(rs.getString("upass"));
            p.setUphone(rs.getString("uphone"));
            p.setUe_mail(rs.getString("ue_mail"));
            list.add(p);
			
		}
		return list;
	}
}
