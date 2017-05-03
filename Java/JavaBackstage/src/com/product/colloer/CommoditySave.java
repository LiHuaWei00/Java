package com.product.colloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.Service.CommodityService;

public class CommoditySave extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommoditySave() {
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
		String s=request.getParameter("gid");
		String s1=request.getParameter("gpicture");
		String s2=request.getParameter("gname");
		String s3=request.getParameter("gaddress");
		String s4=request.getParameter("gmoney");
		String s5=request.getParameter("gfukuan");
		String s6=request.getParameter("gnum");
		String s7=request.getParameter("gkd");
		String s8=request.getParameter("gxl");
		String s9=request.getParameter("gdp");
		s=new String(s.getBytes("ISO-8859-1"),"UTF-8");
		s1=new String(s1.getBytes("ISO-8859-1"),"UTF-8");
		s2=new String(s2.getBytes("ISO-8859-1"),"UTF-8");
		s3=new String(s3.getBytes("ISO-8859-1"),"UTF-8");
		s4=new String(s4.getBytes("ISO-8859-1"),"UTF-8");
		s5=new String(s5.getBytes("ISO-8859-1"),"UTF-8");
		s6=new String(s6.getBytes("ISO-8859-1"),"UTF-8");
		s7=new String(s7.getBytes("ISO-8859-1"),"UTF-8");
		s8=new String(s8.getBytes("ISO-8859-1"),"UTF-8");
		s9=new String(s9.getBytes("ISO-8859-1"),"UTF-8");
		CommodityService ser=new CommodityService();
		try {
			ser.Update(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("../servlet/CommodityPage").forward(request, response);
		
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
