<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    	pageContext.setAttribute("path", path);
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
	
			function success(){
					
						alert("注册成功！");
				}
			
			
		
	</script> 
<title>注册页面</title>
</head>
<body>
	<form action="${path}/register" method="post">
		账号：<input name="account" /><br/>
		密码：<input name="password" /><br/>
		用户名：<input name="name" /><br/>
		<input type="submit" value="注册" onclick="success()" />
		<a href="/Servleta/user/userlogin.jsp">已注册，请登录!</a>
	</form>
		
</body>
</html>