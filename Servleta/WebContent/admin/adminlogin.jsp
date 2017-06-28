<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   String path= request.getContextPath();
    pageContext.setAttribute("path",path);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="${path}/userlogin" method="post">
		账号：<input type="text" name="account"/><br/>
		密码：<input type="password" name="password"/><br/>
		<input type="submit"  value="登陆">
		<!--  <a href="/Servleta/user/register.jsp">注册</a> -->
		
	</form>
</body>
</html>