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
	
function Back()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/OrderController?func=Main&username="
		+ username;
}
</script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0022)http://www.time19.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

.back{
	height: 30px;
	width: 100px;
	background-color: #99BBFF;
	text-align: center;
	margin: 0 auto;
}

fieldset {
	width: 300px;
	height: 250px;
	text-align: center;
	margin: auto;
	margin-top: 120px;
	padding-top: 30px;
}

.hint {
	text-align: center;
	margin: 0 auto;
}

.button {
	height: 30px;
	width: 100px;
	background-color: #99BBFF;
}
</style>
	</head>
	<body>
		<p id="username" class="username" hidden><%=username %></p>
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
		<div style="margin:0 auto; width:100px;"> 
			<button  onclick="Back()" class = "back"> 返回</button>
		</div>
	</body>
</html>

