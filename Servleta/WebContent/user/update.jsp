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
<title>后台管理</title>
</head>
<body>
	${userlist}
	<form action="${path}/Bootstrap/modify" id="${pram.id}">
			
		修改账号:<input type="text" name="account"><br/>
		修改密码:<input type="password" name="password"><br/>
		修改姓名:<input type="text"  name="name"><br/>
		<input type="submit"  value="确定修改"/>

	</form>
	
	
</body>
</html>