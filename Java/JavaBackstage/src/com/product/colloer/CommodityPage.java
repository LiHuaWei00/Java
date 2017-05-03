package com.product.colloer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.Service.CommodityService;
import com.product.bean.Commodity;
import com.product.dao.Dao;

public class CommodityPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommodityPage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currPage=1;
        if(request.getParameter("page")!=null){
            currPage=Integer.parseInt(request.getParameter("page"));
        }
        Dao dao = new Dao();
        CommodityService ser=new CommodityService();
        List<Commodity> list = ser.find1(currPage);;
		request.setAttribute("list", list);
        int pages;  //总页数
        int count=ser.findCount(); //查询总记录数
        if(count%Commodity.PAGE_SIZE==0){
            pages=count/Commodity.PAGE_SIZE;
        }else{
            pages=count/Commodity.PAGE_SIZE+1;
        }
        StringBuffer sb = new StringBuffer();
        //通过循环构建分页条
        for(int i=1;i<=pages;i++){
            if(i==currPage){   //判断是否为当前页
                sb.append("『"+i+"』");  //构建分页条
            	
            }else{
                sb.append("<a href='CommodityPage?page="+i+"'>"+i+"</a>"); //构建分页条
            }
            sb.append(" ");
        }
        request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("/Login/Commodity.jsp").forward(request, response);
		
	}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
