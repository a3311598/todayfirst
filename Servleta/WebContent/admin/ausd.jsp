<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>
	<form action="delete"  >
		<input type="submit"  value="删除"/><input type="text" placeholer="输入对应条件进行删除" name="delete"/><br />
	</form>
	<form action="update" >
		<input type="submit"  value="修改"/><input type="text" placeholer="输入对应条件进行修改" name="modify"/><br />
			ID:<input type="text" name="ID"><br>
		修改账号:<input type="text" name="account"><br>
		修改密码:<input type="password" name="password"><br>
		修改姓名:<input type="text" name="name"><br>
	</form>
	<form action="search"  >
		<input type="submit"  value="查询"/><input type="text" placeholer="输入对应条件进行查询" name="search"/><br />
	</form>
</body>
</html>