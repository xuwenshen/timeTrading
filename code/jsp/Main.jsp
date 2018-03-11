<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*, java.sql.*, java.io.*"
	import="javax.servlet.http.HttpServletRequest"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String username = request.getAttribute("username").toString();
%>

<script type="text/javascript">
	
function Info()
{
	
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/UserController?func=ViewUserInfo&username="
		+ username;
	
}
</script>


<script type="text/javascript">
function Manage()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/UserController?func=ViewAllUsers&username="
		+ username;
}
</script>


<script type="text/javascript">
function Exit()
{
	var r=confirm("确定退出吗？");
	if (r==true)
	  {
		var username = document.getElementById("username").innerHTML;
		window.location.href="<%=request.getContextPath() %>/src/Login.jsp";
	  }
}
</script>

<script type="text/javascript">
function Published()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/OrderController?func=CheckPublished&username="
		+ username;
}
</script>

<script type="text/javascript">
function Accepted()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/OrderController?func=CheckAccepted&username="
		+ username;
}
</script>

<script type="text/javascript">
function Publish()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/src/Publish.jsp?username="
		+ username;
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0022)http://www.time19.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<!-- 应用库 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/master.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/common.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/clock.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/datetimepicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/index.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/style.css">

<script type="text/javascript">

</script>

<title>理时网</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: none;
	margin: auto;
	width: 800px;
}

th {
	border: solid grey 1px;
	margin: 0 0 0 0;
	padding: 5px 5px 5px 5px;
	color: white;
}

td {
	font-size: 15px;
	border: solid grey 1px;
	margin: 0 0 0 0;
	padding: 5px 5px 5px 20px;
	color: blue;
}

tr {
	height: 55px;
}

a {
	font-size: 12px;
	color: #ffff22;
}

body {
	margin: 0px auto;
	background: url(<%=request.getContextPath()%>/Image/1.jpg) no-repeat
		center top;
}

</style>
</head>
<body>
	<p id="username" class="username" hidden><%=username %></p>
	<!-- 应用顶部工具条 开始 -->
	<div class="appToolsBar">
		<div class="appToolsBarBody">
			<div class="floatLeft">
				<button  style="width:60px; height:30px" onclick="Info()"> 个人信息</button>
				<%if (username.equals("root")){
					out.println("<button  style=\"width:60px; height:30px\" onclick=\"Manage()\"> 管理用户</button>");
				}
				%>
				
				<button  style="width:60px; height:30px" onclick="Exit()"> 退出</button>
			</div>
			<div class="floatRight">
				<button  style="width:60px; height:30px" onclick="Published()"> 发布历史</button>
				<button  style="width:60px; height:30px" onclick="Accepted()"> 接单历史</button>
				<button  style="width:60px; height:30px" onclick="Publish()"> 发布需求</button>
				
			</div>
		</div>
	</div>
		<!-- 应用顶部工具条 结束 --> <!-- 应用页眉 开始 --> <!-- 应用页眉 结束 --> <!-- 应用内容区 开始 -->
			<table class="table1" border=3px width="800px" cellspacing="0">
			<caption>
				<font face="verdana" size="24" color="#ffff00">需求信息</font>
			</caption>
			<tr bgcolor="#FF9000" height="50px">
				<th>关键词</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>金额</th>
				<th>地点</th>
				<th>详情</th>
			</tr>
						<%

							Object infos = request.getAttribute("orders_counter");
							if (infos != null){
								int orders_counter = Integer.parseInt(infos.toString());
								
								
								List starttimes = (List)request.getAttribute("starttimes");
								List endtimes = (List)request.getAttribute("endtimes");
								List nids = (List)request.getAttribute("nids");
								List prices = (List)request.getAttribute("prices");
								List keywords = (List)request.getAttribute("keywords");
								List locations = (List)request.getAttribute("locations");
								int[] oids = (int [])request.getAttribute("oids");
								
								for (int i =0; i < orders_counter; i++){
									
									out.println("<tr>");
									out.println("<td width= \"130\">" + keywords.get(i) + "</td>");
									out.println("<td width= \"180\">" + starttimes.get(i) + "</td>");
									out.println("<td width= \"180\">" + endtimes.get(i) + "</td>");
									out.println("<td width= \"80\">" + prices.get(i) + "</td>");
									out.println("<td width= \"80\">" + locations.get(i) + "</td>");
									out.println("<td width= \"180\">");
									int id = oids[i];
									out.println("<form id=\"detail\" action=\"" + request.getContextPath() + 
											"/OrderController\" method=\"post\">");

									out.println("<input type = \"hidden\" value = \"OrderDetail\" name=\"func\"/>");
									out.println("<input type = \"hidden\" value = \"" + id+ "\" name=\"oid\"/>");
									out.println("<input type = \"hidden\" value = \"" + username+ "\" name=\"username\"/>");
									out.println("<input type = \"submit\" value = \"详情\" class=\"button\" /></form>");
								}
						}
						%>
		</table>
		</body>
</html>

