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
					
						alert("用户添加成功！");
				}
			
			
		
	</script> 
<title>添加用户页面</title>
</head>
<body>
	<form action="${path}/Bootstrap/addUser">
		账号：<input name="account" /><br/>
		密码：<input name="password" /><br/>
		用户名：<input name="name" /><br/>
		<input type="submit" value="添加用户" onclick="success()" />
	
	</form>
		
</body>
</html>