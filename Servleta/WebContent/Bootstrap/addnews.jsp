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
					
						alert("添加文章成功！");
				}
			
			
		
	</script> 
<title>添加文章页面</title>
</head>
<body>
	<form action="${path}/addNews">
		标题：<input name="headline" /><br/>
		内容：<input name="content" /><br/>
		作者：<input name="headname" /><br/>
		<input type="submit" value="添加文章" onclick="success()" />
	
	</form>
		
</body>
</html>