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
	height: 300px;
	text-align: center;
	margin: auto;
	margin-top: 120px;
	padding-top: 30px;
}

form {
	width: 300px;
	height: 400px;
	text-align: center;
	margin: 0 auto;
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

.back{
	height: 30px;
	width: 100px;
	background-color: #99BBFF;
	text-align: center;
	margin: 0 auto;
}

</style>
</style>
</head>
<body>
	<p id="username" class="username" hidden><%=username %></p>
	<form action="<%=request.getContextPath()%>/UserController" method="post">
		<fieldset>
			<legend>个人信息</legend>
			<input type="hidden" value="UpdateUserInfo" name="func"/>
			<input id="username" name="username" value="<%=username%>"  type="hidden"/>
			<%
				String nickname = "", skills = "", signature = "";
				Object infos = request.getAttribute("nickname");
				if (infos != null){
					nickname = infos.toString();
				}
				infos = request.getAttribute("skills");
				if (infos != null){
					skills = infos.toString();
				}
				infos = request.getAttribute("signature");
				if (infos != null){
					signature = infos.toString();
				}
				%>
				
				昵称：<input type="text" name="nickname" maxlength=50
				value=<%=nickname%>><br /> <br />
			技能： <input type="text" name="skills" maxlength=100 value=<%=skills%>><br />
			<br /> 签名：
			<textarea rows="6" cols="20" name="signature"><%=signature%></textarea>
			<br /> <br /> <input type="submit" name="set" class="button"
				　value="确认">
		</fieldset>
		
		<% Object log = request.getAttribute("update_info_log");
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