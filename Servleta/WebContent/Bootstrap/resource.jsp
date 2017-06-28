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
		<meta charset="utf-8" />

		<meta name="x-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css" />
		
	</head>

	<body>

		<hr>
		<p class="active-tab"><strong>当前页面</strong>：<span></span></p>
		<!--<p class="previous-tab"><strong>前一个激活的标签页</strong>：<span></span></p>-->
		<hr>
		<ul id="myTab" class="nav nav-tabs">

			<li class="dropdown">
				<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"> 首页 <b class="caret"></b></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
					<li><a href="#userList" tabindex="-1" data-toggle="tab">用户管理</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"> 新闻<b class="caret"></b></a>

				<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
					<li><a href="#colList" tabindex="-1" data-toggle="tab">新闻栏目管理</a></li>
					<li><a href="#ejb" tabindex="-1" data-toggle="tab">发布新闻</a></li>
					<li><a href="#newsList" tabindex="-1" data-toggle="tab">新闻管理</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"> 广告<b class="caret"></b></a>

				<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
					<li><a href="#adList" tabindex="-1" data-toggle="tab">广告发布</a></li>
					<li><a href="#adList" tabindex="-1" data-toggle="tab">广告管理</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"> 其他<b class="caret"></b></a>

				<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
					<li><a href="#jmeter" tabindex="-1" data-toggle="tab">轮播图管理</a></li>
				</ul>
			</li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade" id="newsList">
				<form action="${path}/Bootstrap/searchNews">
					<input type="text" name="headline">
					<button type="submit">查询</button>
					<a href="addnews.jsp">新增</a>
				</form>

				<br>
				<table border="1" cellpadding="0" cellspacing="0" bordercolor="blue">
					<tr>
						<th>ID</th>
						<th>类别ID</th> 
						<th>标题ID</th>
						<th>访问量</th>
						<td>标题</td>
						<td>内容</td>
						<td>发表时间</td>
						<td>作者</td>
						<td>图片路径</td>
						<td>操作</td>
					</tr>
					<tbody>
						<c:forEach var="passage" items="${newList}">
							<tr>
								<td>${passage.id}</td>
								<td>${passage.categoryid}</td>
								<td>${passage.headlineid }</td>
								<td>${passage.viewcount}</td>
								<td>${passage.headline}</td>
								<td>${passage.content}</td>
								<td>${passage.creationtime}</td>
								<td>${passage.headname}</td>
								<td>${passage.headimg}</td>
								<td><a href="updateNews?id=${passage.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteNews?id=${passage.id}">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="adList">
				<div style="width:100%;background:#eee;">
					<div align="center" style="margin:0px auto ; width: 1200px;background: #efe;">

						<style>
							.FontDiv {
								font: "微软雅黑";
								font-size: 28px;
								margin: 0px;
								padding: 0px;
							}
							
							.InputText {
								width: 400px;
								height: 30px;
								border-radius: 10px;
								border: 3px solid #8e8;
								outline: medium;
								padding: 0px 10px 0px 10px;
								font: '微软雅黑';
								font-size: 20px;
								color: #f8b;
							}
							
							.Btn {
								width: 400px;
								height: 35px;
								border-radius: 10px;
								border: 0px solid #8f8;
								outline: medium;
								padding: 0px 10px 0px 10px;
								font: '微软雅黑';
								font-size: 24px;
								background: #bbf;
								color: #fff;
							}
						</style>
						<div style="width:800px;margin:0px 0px 100px 0px;padding-top:100px;height:250px;background:#dff;">
							<form action="${path }/AdAddServlet" method="Post" enctype="multipart/form-data">
								<!--<div class="FontDiv" style="padding-top:5%;">广&nbsp;告&nbsp;标&nbsp;题</div>-->
								<input type="text" id="" name="addadvertisings" class="InputText" placeholder="请 添 加 广 告 标 题" /><br>
								<!--<div class="FontDiv">图&nbsp;片&nbsp;连&nbsp;接</div><br>-->
								<input type="file" id="" name="addadLinks" class="InputText" style="width:376px;opacity:   0   ;background:#fff;filter:alpha(opacity=0);position:absolute;margin-left:-200px;margin-top:21px;" /><br>
								<input type="button" value="选择图片" id="" name="" class="Btn" style="float:initial;" /><br /><br />
								<%-- ${adList.addadLinks } --%>
								<input type="submit" value="增加" id="" name="" class="Btn" />
							</form><br>
						</div>
						<form action="${path }/AdaboutServlet" method="Post">
							<input type="text" id="" name="advertisings" class="InputText" />
							<input type="submit" value="查询" id="" name="" class="Btn" />
						</form>

						<table cellspacing="0px" border="1x" bordercolor="#fff">
							<tr>
								<th>Id</th>
								<th>标题</th>
								<th>图片</th>
								<th>时间</th>
								<th>删除</th>
							</tr>
							<tbody>
								<c:forEach var="adTest" items="${adList}">
									<form action="${path}/RmBtn" method="Post">
										<tr>
											<td>${adTest.id}</td>
											<td>${adTest.advertisings}</td>
											<td><img alt="" src="${adTest.adLinks}" height="100px"></td>
											<td>${adTest.creationtime}</td>
											<td><input type="hidden" id="" name="RmOne" value="${adTest.advertisings}" /><input type="submit" value="删除" id="" name="" /></td>
										</tr>
									</form>
								</c:forEach>
							</tbody>
						</table>


					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="userList">
				<form action="${path}/Bootstrap/list">
					<input type="text" name="username">
					<input type="submit" value="查询" />
					<a href="adduser.jsp">新增</a>

				</form>
				<br>
				<table border="1" cellpadding="0" cellspacing="0" bordercolor="blue">
					<tr>
						<th>ID</th>
						<th>账号</th>
						<th>密码</th>
						<th>姓名</th>
						<td>操作</td>
					</tr>
					<tbody>
						<c:forEach var="user" items="${userList}">
							<tr>
								<td>${user.id}</td>
								<td>${user.account}</td>
								<td>${user.password}</td>
								<td>${user.name}</td>
								<td><a href="update?id=${user.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=${user.id }">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="colList">
				<form action="${path}/searchColumn">
					<input type="text" name="columnname">
					<button type="submit">查询</button>
					<a href="addcolumn.jsp">新增</a>
				</form>

				<table border="1" cellpadding="0" cellspacing="0" bordercolor="blue">
					<tr>
						<th>ID</th>
						<th>类别</th>
						<th>操作</th>
					</tr>
					<tbody>
						<c:forEach var="column" items="${colList}">
							<tr>
								<td>${column.id}</td>
								<td><input size=4 name="columnname" value="${column.columnname} " /></td>
								<td><a href="updatecolumn.jsp?id=${column.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteColumn?id=${column.id}">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript" src="dist/js/jquery-3.2.1.js" charset="UTF-8"></script>
		<script type="text/javascript" src="dist/js/bootstrap.js" charset="UTF-8"></script>
		<script>
			$(function() {
				$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
					// 获取已激活的标签页的名称
					var activeTab = $(e.target).text();
					// 获取前一个激活的标签页的名称
					var previousTab = $(e.relatedTarget).text();
					$(".active-tab span").html(activeTab);
					$(".previous-tab span").html(previousTab);
				});
			});
		</script>
	</body>

</html>