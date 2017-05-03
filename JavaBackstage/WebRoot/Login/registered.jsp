<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registered.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
    <%!
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/jsptest";
    private static final String USERNAME="root";;
    private static final String PASSWORD="huazi123";
     %>
     <%
     String s1=request.getParameter("Username");
     String s2=request.getParameter("Password");
    
     Connection con=null;
     PreparedStatement pre=null;
     
     try{
     	Class.forName(DRIVER);
     	con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
     	String sql="insert  into tb_admin values(null,?,?,null)";
     	pre=con.prepareStatement(sql);
     	pre.setString(1,s1);
     	pre.setString(2,s2);
     	int x=pre.executeUpdate();
     	%>
     	<script type="text/javascript">
     		alert("登陆成功");
     		window.location.href="Login/Home.jsp";
     	</script>
     	<%
     }catch(Exception e){
     	e.printStackTrace();
     }
      %>
  </body>
</html>
