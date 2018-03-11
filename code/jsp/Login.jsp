<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*, java.sql.*, java.io.*"
	import="javax.servlet.http.HttpServletRequest" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0022)http://www.time19.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>理时网</title>
<style type="text/css">
body {
	margin: 0px auto;
	background: url(<%=request.getContextPath()%>/Image/1.jpg) no-repeat
		center top;
}

fieldset {
	width: 300px;
	height: 250px;
	text-align: center;
	margin: auto;
	margin-top: 120px;
	padding-top: 30px;
}

form {
	width: 300px;
	height: 300px;
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
}
</style>
</head>
<body>
	<form id="formLogin"
		action="<%=request.getContextPath()%>/UserController"
		method="post">
		<fieldset>
			<legend>登录</legend>
			<input type="hidden" value="Login" name="func"/>
			用户名 ：<input id="username" name="username" width="200px" /><br /> <br /> <br />
			密码&nbsp ：<input id="passwd" name="passwd" width="200px" type="password" /><br />
			<br /> <br /> <input type="submit" class = "button"
				value="登录" /> <a href = "<%=request.getContextPath()%>/src/Reg.jsp">注册>>></a>
		</fieldset>
	</form>
	<% 
		Object log = request.getAttribute("login_info");
		if (log != null){
			out.println("<p class = hint>" + log.toString() + "</p>" );
		}else{
			
		}
    %>
</body>
</html>