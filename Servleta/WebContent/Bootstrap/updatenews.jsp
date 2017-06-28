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
<title>修改文章页面</title>
</head>
<body>
		
		
		<form action="${path}/modifyNews">
		<input type="hidden" id="${param.id}" />
		标题：<input name="headline" value="${passage.headline}"/><br/>
		内容：<input name="content" value="${passage.content}"/><br/>
		作者：<input name="headname" value="${passage.headname}"/><br/>
		<input type="submit" value="修改文章" />
	
		</form>
</body>
</html>