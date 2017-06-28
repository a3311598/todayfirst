<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getContextPath();
 			pageContext.setAttribute("path", path);   
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="x-UA-Compatible" content="IE=edge"/>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		
		<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css"/>
<title>用户列表</title>
</head>
<body>
<form action="${path}/list" >
<input type="text" name="username" >
<input type="submit" value="查询" />
</form>
<br>
<table border="1" cellpadding="0" cellspacing="0" bordercolor="blue">
	<tr><th>ID</th><th>账号</th><th>密码</th><th>姓名</th><td>操作</td></tr>
	<tbody>
	<c:forEach var="user" items="${userList}">
		<tr><td>${user.id }</td><td>${user.account }</td><td>${user.password }</td><td>${user.name }</td>
		<td><a href="update?id=${user.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=${user.id }">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script type="text/javascript" src="dist/js/jquery-3.2.1.js" charset="UTF-8" ></script>
		<script type="text/javascript" src="dist/js/bootstrap.js" charset="UTF-8"></script>
</body>
</html>