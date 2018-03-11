<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
 import="java.util.*, java.sql.*, java.io.*"
 import="javax.servlet.http.HttpServletRequest" 
 %>
<%request.setCharacterEncoding("utf-8"); %>
<% 
	String username=request.getAttribute("username").toString();
	//out.println(username);
	String oid = request.getAttribute("oid").toString();
	//out.println(oid);
%>
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
<script type="text/javascript">

function Accept()
{
	var r=confirm("确定接受该需求吗!");
	if (r==true)
	  {
		var oid = document.getElementById("oid").innerHTML;
		var username = document.getElementById("username").innerHTML;
		window.location.href="<%=request.getContextPath()%>/OrderController?func=AcceptOrder&oid="
				+ oid + "&username="+username;
	  }
}
</script>

<script type="text/javascript">
	
function DelOrder()
{
	var r=confirm("确定删除该需求吗!");
	if (r==true)
	  {
		var oid = document.getElementById("oid").innerHTML;
		var username = document.getElementById("username").innerHTML;
		window.location.href="<%=request.getContextPath()%>/OrderController?func=DeleteOrder&oid="
			+ oid + "&username="+username;
	  }
}
</script>


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
<!-- 应用内容区 开始 -->
<div class="appFramework" style="background: #fbfafa;">
	<div class="appBody" style="width: 1070px;">	
		
		<div style=" height: 500px; margin-top: 10px; width: 100%; margin:10px 20px 20px 20px">
			<div class="image" style="display: inline; float: left; height: auto; margin-top: 10px; width: 200px;">
				<img  alt="插图" class="classImages" src="<%=request.getContextPath() %>/Image/1F_image.jpg" title="">
			</div>
		  
			 <div style="display: inline; float: right; height: 500px; margin-top: 10px; width: 800px; background: transparent url(<%=request.getContextPath() %>/Image/table.jpg)">
				<table class="table1" border=3px width="800px"  cellspacing="0" >
					<caption><font  face="verdana" size="24" color="#ffff00" >需求详细信息</font></caption>
					<%
			  		
					String starttime = request.getAttribute("starttime").toString();
					//out.println(starttime);
					String endtime = request.getAttribute("endtime").toString();
					//out.println(endtime);
					String nid = request.getAttribute("nid").toString();
					//out.println(nid);
					String hid = request.getAttribute("hid").toString();
					//out.println(hid);
					String keyword = request.getAttribute("keyword").toString();
					//out.println(keyword);
					String price = request.getAttribute("price").toString();
					//out.println(price);
					String location = request.getAttribute("location").toString();
					//out.println(location);
					String description = request.getAttribute("description").toString();
					//out.println(description);
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "需求用户" + "</th>");
					out.println("<td width= \"300\">" +nid + "</td>");
					out.println("</tr>");
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "接单用户" + "</th>");
					out.println("<td width= \"300\">" + hid + "</td>");
					out.println("</tr>");
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "关键词" + "</th>");
					out.println("<td width= \"300\">" +keyword + "</td>");
					out.println("</tr>");
					
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "开始时间" + "</th>");
					out.println("<td width= \"300\">" + starttime + "</td>");
					out.println("</tr>");
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "结束时间" + "</th>");
					out.println("<td width= \"300\">" + endtime + "</td>");
					out.println("</tr height=\"50px\">");
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "金额" + "</th>");
					out.println("<td width= \"300\">" + price + "</td>");
					out.println("</tr>");
					
					out.println("<tr height=\"50px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "地点" + "</th>");
					out.println("<td width= \"300\">" + location + "</td>");
					out.println("</tr>");
					
					out.println("<tr height=\"100px\">");
					out.println("<th width= \"120\" bgcolor=\"#FF900\">" + "详细内容" + "</th>");
					out.println("<td width= \"300\">" + description + "</td>");
					out.println("</tr>");
					%>
			</table>
				<div style="float:left; margin-top:8px; margin-bottom:6px; position:relative; left:40%">
				      <button  style="width:60px; height:30px" onclick="Accept()"> <font color="white" size="4px"> 接单  </font></button>&nbsp &nbsp &nbsp;
				      <button style="width:60px; height:30px" onclick="javascript:window.history.back(-1);"> <font color="white" size="4px"> 返回 </font></button>	&nbsp &nbsp &nbsp;
				      <button  style="width:60px; height:30px" onclick="DelOrder()"> <font color="white" size="4px"> 删除  </font></button>
	 			 </div>
			 </div>
		  
		</div>
	
    </div>
	<p id="oid" class="oid" hidden><%=oid %></p>
	<p id="username" class="username" hidden><%=username %></p>
</div>
<!-- 应用内容区 结束 --> 
<!-- 应用页脚 开始 --> 
<!-- 应用页脚 结束 -->
</body>
</html>



