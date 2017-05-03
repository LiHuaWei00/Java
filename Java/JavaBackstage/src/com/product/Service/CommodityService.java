package com.product.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.Commodity;
import com.product.dao.Dao;

public class CommodityService {
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
	public List<Commodity> find1(int page){
        List<Commodity> list = new ArrayList<Commodity>();
        Connection conn = getConnection();
        String sql = "select* from tb_goods  limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page-1)*Commodity.PAGE_SIZE);
            ps.setInt(2, Commodity.PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Commodity p=new Commodity();
                p.setGid(rs.getString("gid"));
                p.setGpicture(rs.getString("gpicture"));
                p.setGname(rs.getString("gname"));
                p.setGaddress(rs.getString("gaddress"));
                p.setGmoney(rs.getString("gmoney"));
                p.setGfukuan(rs.getString("gfukuan"));
                p.setGnum(rs.getString("gnum"));
                p.setGkd(rs.getString("gkd"));
                p.setGxl(rs.getString("gxl"));
                p.setGdp(rs.getString("gdp"));
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
        String sql = "select count(*) from tb_goods";
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
	 
	public List<Commodity> ButtonQuery(String s) throws Exception{
		List<Commodity> list=new ArrayList<Commodity>();
		String sql;
		if(dao.isNumeric(s)){
			sql="select * from tb_goods where gid='"+s+"'";
		}else{
			sql="select * from tb_goods where gname like '%"+s+"%'";
		}
		ResultSet rs=dao.query(sql);
		while(rs.next()){
			Commodity p=new Commodity();
            p.setGid(rs.getString("gid"));
            p.setGpicture(rs.getString("gpicture"));
            p.setGname(rs.getString("gname"));
            p.setGaddress(rs.getString("gaddress"));
            p.setGmoney(rs.getString("gmoney"));
            p.setGfukuan(rs.getString("gfukuan"));
            p.setGnum(rs.getString("gnum"));
            p.setGkd(rs.getString("gkd"));
            p.setGxl(rs.getString("gxl"));
            p.setGdp(rs.getString("gdp"));
            list.add(p);
			
		}
		return list;
	}
	public List<Commodity> ButtonQuery1(String s) throws Exception{
		List<Commodity> list=new ArrayList<Commodity>();
		String sql;
		if(dao.isNumeric(s)){
			sql="select * from tb_goods where gid='"+s+"'";
		}else{
			sql="select * from tb_goods where gname like '%"+s+"%'";
		}
		ResultSet rs=dao.query(sql);
		while(rs.next()){
			Commodity p=new Commodity();
			p.setGid(rs.getString("gid"));
            p.setGpicture(rs.getString("gpicture"));
            p.setGname(rs.getString("gname"));
            p.setGaddress(rs.getString("gaddress"));
            p.setGmoney(rs.getString("gmoney"));
            p.setGfukuan(rs.getString("gfukuan"));
            p.setGnum(rs.getString("gnum"));
            p.setGkd(rs.getString("gkd"));
            p.setGxl(rs.getString("gxl"));
            p.setGdp(rs.getString("gdp"));
            list.add(p);
			
		}
		return list;
	}
	public void delete(String s) throws Exception{
		
		String sql="delete from tb_goods where gid='"+s+"'";
		int x=dao.update(sql);
		
	}
	public void Update(String s,String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9) throws Exception{
		
		String sql="update tb_goods set gpicture='"+s1+"',gname='"+s2+"',gaddress='"+s3+"',gmoney='"+s4+"',gfukuan='"+s5+"',gnum='"+s6+"',gkd='"+s7+"',gxl='"+s8+"',gdp='"+s9+"' where gid='"+s+"'";
		int x=dao.update(sql);
	}
	public void Add() throws Exception{
		String sql="insert into tb_goods values (null,null,null,null,null,null,null,null,null,null)";
		int x=dao.update(sql);
	}
}
