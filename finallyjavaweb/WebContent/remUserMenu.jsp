<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改个人信息</title>
		<link rel="stylesheet" type="text/css" href="./css/remUserMenu.css"/>
	</head>
	<body>
		<div id="tilte">
			<p>修改个人信息</p>
		</div>
		<hr>
		<div id="userinformation">
			<form action="remServlet" method="post" enctype="multipart/form-data">
				用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" name="username" id="username" class="item" value="${db_user.user_name}" readonly/><br>
				密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="userpassword" id="userpassword" class="item" value="${db_user.user_password}" /><br>
				邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="useremail" id="useremail" class="item" value="${db_user.user_email}" /><br>
				电话号码：<input type="text" name="userphone" id="userphone" class="item" value="${db_user.user_phone}" /><br>
				真实姓名：<input type="text" name="userrealname" id="userrealname" class="item" value="${db_user.user_realname}" readonly/><br>
				身份证号：<input type="text" name="usericard" id="usericard" class="item" value="${db_user.user_idcard}" readonly/><br>
				<input type="hidden" name="userid" id="userid" value="${db_user.user_id}" />
				<input type="file" name="userhead" id="userhead" />
				<input type="submit" value="修  改" id="changeAll"/>
			</form>
		</div>
		
		
	</body>
</html>
