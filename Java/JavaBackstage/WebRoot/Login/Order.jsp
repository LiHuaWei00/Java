<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.product.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单管理界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/Test02/Login/css/index.css">
	<link rel="stylesheet" type="text/css" media="screen" href="http://localhost:8080/Test02/Login/css/style1.css"/>
	<script type="text/javascript" src="http://localhost:8080/Test02/Login/js/jquery-1.9.1.min.js"></script>
	<style>
		#table-2 thead, #table-2 tr {
		border-top-width: 1px;
		border-top-style: solid;
		border-top-color: rgb(230, 189, 189);
		}
		#table-2 {
		border-bottom-width: 1px;
		border-bottom-style: solid;
		border-bottom-color: rgb(230, 189, 189);
		margin-top:50px;
		}
		
		#table-2 td, #table-2 th {
			padding: 5px 0px;
			font-size: 12px;
			font-family: Verdana;
			color: rgb(177, 106, 104);
		}
		.input{
			width:80px;
			text-align: center;
		}
		.input:visited {
			border-color: #629fed;
		}
		.input:hover{
			border-color: #629fed;
		}
		.input:actived{
			border-color: #629fed;
		}
	</style>
  </head>
  
  <body>
  <div id="tebless">
  		<div class="milky">Order management</div>
    	<table id="table-2" align="center"> 
    	<thead>
    	<th>ID</th>
		<th>图片</th>
		<th>名称</th>
		<th>颜色</th>
		<th>xxx</th>
		<th>定金</th>
		<th>xxx</th>
		</thead>
		<c:forEach items="${list}" var="u"> 
		<form action="../servlet/OrderSave" name="itemForm" id="itemForm">  
        <tbody>
        <tr>
            <td><input type="text" value="${u.gid}" class="input" name="gid"/></td> 
            <td><input type="text" value="${u.gpic}" class="input" name="gpic"/></td>
            <td><input type="text" value="${u.gname}" class="input" name="gname"/></td>
            <td><input type="text" value="${u.gcolor}" class="input" name="gcolor"/></td>
            <td><input type="text" value="${u.gcm}" class="input" name="gcm"/></td>
            <td><input type="text" value="${u.gmoney}" class="input" name="gmoney"/></td>
            <td><input type="text" value="${u.gcal}" class="input" name="gcal"/></td>
            <td><input type="button" name="delete"  value="删除" onclick="firm(${u.gid})"/></td>
            <td><input type="submit" name="save"  value="保存" onclick="firms(${u.gid})"/></td>
           </tr>
       	</form>
       	</c:forEach>
       	 <tr id="yema">
              <td align="center" colspan="15">
                 <%=request.getAttribute("bar") %>
              </td>
          </tr>  
        </tbody>
        </table>
   		<div id="wrapper2">
  		<form action="../servlet/OrderButton">
  			<input type="text"  name="query" id="button2" value="请输入ID或名称"><br>
    		<input type="submit" value="查询" id="button3">
  		</form>
  		</div>
    </div> 
	<div class="nav-main">
	<div class="nav-box">
	<div class="nav">
  	<ul class="nav-ul">
  	<li><a href="http://localhost:8080/Test02/Login/Home.jsp" class="home"><span>首页</span></a></li>
  	<li><a href="../servlet/Userquery" class="develop"><span>用户查询</span></a></li>
  	<li><a href="../servlet/CommodityPage" class="wechat"><span>商品管理</span></a></li>
  	<li><a href="../servlet/OrderPage" class="case"><span>订单管理</span></a></li>
  	<li><a href="../servlet/Cartquery" class="news"><span>购物车管理</span></a></li>
    <li><a href="http://localhost:8080/Test02/Login/login.jsp" class="news"><span>退出</span></a></li>
  </ul>
</div>
</div>
</div>
<script type="text/javascript">
	function firm(gid) {  
        if(window.confirm('是否确认删除？'))
        {
        window.location.href = '../servlet/OrderDelete?action=../servlet/OrderDelete&gid='+gid;
        }
  };
  function firms(gid) {  
        window.location.href = '../servlet/OrderSave?action=../servlet/OrderSave&gid='+gid;
        
  };
  
</script>

  </body>
</html>
