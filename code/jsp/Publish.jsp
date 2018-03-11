<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*, java.sql.*, java.io.*"
	import="javax.servlet.http.HttpServletRequest"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String username = request.getParameter("username");
    if (username == null){

    	 username = request.getAttribute("username").toString();
    }
	
%>

<script type="text/javascript">
	
function Back()
{
	var username = document.getElementById("username").innerHTML;
	window.location.href="<%=request.getContextPath()%>/OrderController?func=Main&username="
		+ username;
}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>理时网</title>
<style type="text/css">
body {
	margin: 0px auto;
	background: url(<%=request.getContextPath()%>/Image/1.jpg) no-repeat
		center top;
}

fieldset {
	width: 300px;
	height: 380px;
	text-align: center;
	margin: auto;
	margin-top: 120px;
	padding-top: 30px;
}

form {
	width: 300px;
	height: 450px;
	text-align: center;
	margin: 0 auto;
}

.hint {
	text-align: center;
	margin: 0 auto;
}

.button{
	height: 30px;
	width: 100px;
	background-color: #99BBFF;
	text-align: center;
}

.back{
	height: 30px;
	width: 100px;
	background-color: #99BBFF;
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>
	<p id="username" class="username" hidden><%=username %></p>
	<form action="<%=request.getContextPath()%>/OrderController"
		method="post">
		<fieldset>
			<legend>发布详情</legend>
			<input type="hidden" value="Publish" name="func"/>
			<input value="<%=username%>", type="hidden" name="username">
			关键词&nbsp： <input name="keyword" type="text" maxlength=50> <br />
			<br />地点&nbsp&nbsp： <input name="location" type="text" maxlength=50> <br />
			<br />价格&nbsp&nbsp： <input name="price" type="text" maxlength=50><br />
			<br />开始时间： <input name="start" type="text" maxlength=20
				value="2000-01-01 00:00"><br />
			<br /> 中止时间： <input name="end" type="text" maxlength=20
				value="2000-01-01 00:00"><br />
			<br />
			<textarea rows="5" cols="30" name="memo">在这里输入其它内容</textarea>
			<br />
			<br /> <input name="submit" type="submit" class = "button"　value="发布">
		</fieldset>
		<% Object log = request.getAttribute("publish_info");
			if (log != null){
				out.println("<p class = hint>" + log.toString() + "</p>" );
			}
		%>
	</form>
	<div style="margin:0 auto; width:70px;"> 
	<button  onclick="Back()" class = "back"> 返回</button>
	</div>
</body>
</html>