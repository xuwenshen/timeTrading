<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
 import="java.util.*, java.sql.*, java.io.*"
 import="javax.servlet.http.HttpServletRequest" 
 %>
<%request.setCharacterEncoding("utf-8"); %>
<% 
	String username=request.getAttribute("username").toString();
%>

<script type="text/javascript">
function Back()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/OrderController?func=Main&username="
		+ username;
}
</script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0022)http://www.time19.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<!-- 应用库 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/master.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/common.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/JS/clock.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/index.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/style.css">
<title>理时网</title>
<style type="text/css">
table{
          border-collapse: collapse;
          border: none;
          margin:10 10 10 10;
          width: 800px;        
   }
   th{
          border: solid grey 1px;            
          margin: 0 0 0 0;
          padding: 5px 5px 5px 5px;
          color: white;
  }
  td{
  		font-size:15px;
          border: solid grey 1px;            
          margin: 0 0 0 0;
          padding: 5px 5px 5px 20px;
          color: blue;         
  }
  tr{
  	height: 55px;
  }
  a{
  	font-size:12px;
  	color: #ffff22;
  }
</style>
</head>
<body>
	<p id="username" class="username" hidden><%=username %></p>
<!-- 应用内容区 开始 -->
<div class="appFramework" style="background: #fbfafa;">
	<div class="appBody" style="width: 1070px;">	
		
		<div style=" height: 500px; margin-top: 10px; width: 100%; margin:10px 20px 20px 20px">
			<div class="image" style="display: inline; float: left; height: auto; margin-top: 10px; width: 200px;">
				<img  alt="插图" class="classImages" src="<%=request.getContextPath() %>/Image/1F_image.jpg" title="">
			</div>
		  
			 <div style="display: inline; float: right; height: 500px; margin-top: 10px; width: 800px; background: transparent url(<%=request.getContextPath() %>/Image/table.jpg)">
		<div style="margin-top:8px; height: 230px; margin-top: 170px; width: 300px; position:relative; left:35%">		
			<p>
			<%
				String log = request.getAttribute("delete_log").toString();
				out.println("<font color=\"white\" size=\"40px\">" + log + "</font>");
			%>
			</p>
		</div>
				<div style="float:left; margin-top:8px; margin-bottom:6px; position:relative; left:40%">
					<button  style="width:60px; height:30px" onclick="Back()">返回</button>
	 			 </div>
			 </div>
		  
		</div>
	
    </div>

</div>
<!-- 应用内容区 结束 --> 
<!-- 应用页脚 开始 --> 
<!-- 应用页脚 结束 -->
</body>
</html>



