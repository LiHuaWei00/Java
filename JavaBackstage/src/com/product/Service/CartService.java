package com.product.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.Cart;
import com.product.dao.Dao;

public class CartService {
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
	public List<Cart> find(int page){
        List<Cart> list = new ArrayList<Cart>();
        Connection conn = getConnection();
        String sql = "select* from tb_goods_cart  limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page-1)*Cart.PAGE_SIZE);
            ps.setInt(2, Cart.PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Cart p=new Cart();
                p.setGid(rs.getString("gid"));
                p.setGpic(rs.getString("gpic"));
                p.setGname(rs.getString("gname"));
                p.setGcolor(rs.getString("gcolor"));
                p.setGcm(rs.getString("gcm"));
                p.setGmoney(rs.getString("gmoney"));
                p.setGcal(rs.getString("gcal"));
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
        String sql = "select count(*) from tb_goods_cart";
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
	 
	public List<Cart> ButtonQuery(String s) throws Exception{
		List<Cart> list=new ArrayList<Cart>();
		String sql;
		if(dao.isNumeric(s)){
			sql="select * from tb_goods_cart where gid='"+s+"'";
		}else{
			sql="select * from tb_goods_cart where gname like '%"+s+"%'";
		}
		ResultSet rs=dao.query(sql);
		while(rs.next()){
			Cart p=new Cart();
            p.setGid(rs.getString("gid"));
            p.setGpic(rs.getString("gpic"));
            p.setGname(rs.getString("gname"));
            p.setGcolor(rs.getString("gcolor"));
            p.setGcm(rs.getString("gcm"));
            p.setGmoney(rs.getString("gmoney"));
            p.setGcal(rs.getString("gcal"));
            list.add(p);
			
		}
		return list;
	}
}
