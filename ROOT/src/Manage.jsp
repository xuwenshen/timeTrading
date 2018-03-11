<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*, java.sql.*, java.io.*"
	import="javax.servlet.http.HttpServletRequest"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String username = request.getParameter("username");
	if (username.equals(null)){
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
	height: 250px;
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

.button{
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
	<form id="form"
		action="<%=request.getContextPath()%>/UserController"
		method="post">
			<legend style="margin:50 auto;">全部用户</legend>
			<input type="hidden" name="username" value="<%= username%>"/>
			<input type="hidden" value="DeleteUser" name="func"/>
			<%
				
				String is_admin = (String)request.getAttribute("is_admin");
				if (is_admin.equals("yes")){
				List<String> users = (List)request.getAttribute("users");
				String del[] = {};
				for(int i = 0; i < users.size(); i++){
					String id = users.get(i);
					boolean to_del = false;
					for (int j = 0; j < del.length; j++) {
						if (id.equals(del[j])) {
							to_del = true;
							break;
						}
					}
					if (to_del){
						continue;
					}
					out.println("<input name=" + "users" + " type=" + "checkbox" + " value = " + id + ">" + id);
					out.println("<br/>");
					out.println("<br/>");
				}
			}
				Object info = request.getAttribute("viewusers_log");
				if (info != null){
					out.println(info.toString());
				}
			%>
			<%
				is_admin = request.getAttribute("is_admin").toString();
				if ("yes".equals(is_admin)) {
					out.print("<input type=" + "submit class = button" + " value=" + "删除" + ">");
				}
			%>
	</form>
	<div style="margin:10 auto; width:100px;"> 
	<button  class = "button" onclick="Back()"> 返回</button>
	</div>
</body>
</html>