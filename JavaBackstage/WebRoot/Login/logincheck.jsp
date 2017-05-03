<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logincheck.jsp' starting page</title>
    
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
  private static final String USERNAME="root";
  private static final String PASSWORD="huazi123";
   %>
    <%
    String s1=request.getParameter("Username");
    String s2=request.getParameter("Password");
    Connection con=null;
    PreparedStatement pre=null;
    ResultSet rs=null;
    
    
    try{
   		Class.forName(DRIVER);
		//实例化对象
		con = DriverManager.getConnection(URL,USERNAME,PASSWORD);//建立连接
		String sql="select username from tb_admin where username=? and password=?";
		
		pre=con.prepareStatement(sql);//生成预处理的对象
		pre.setString(1,s1);
		pre.setString(2,s2);
		rs=pre.executeQuery();//查询 
		if(rs.next()){
		%>
		<jsp:forward page="Home.jsp"/>
		 
		
		<%
		}else{
			%>
			<script type="text/javascript">
			alert("输入有误，无法登陆");
			window.location.href="Login/login.jsp";
			</script>
			<%
			
		}
   }catch(Exception e){
   	e.printStackTrace();
   }finally{
   	try{
   		rs.close();
   		pre.close();
   		con.close();
   	}catch(Exception e){
   	}
   }
     %>
     
  </body>
</html>
