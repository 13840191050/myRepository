<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎登录</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/logMenu.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css"/>
	</head>
	<body>
		<div id="main">
			<div id="login">
				<h1>欢迎登录</h1>
				<p id="error">${logErrorCode}</p>
				<form action="logServlet" method="post">
					<div class="text">
						<div class="item_input">
							<i class="fa fa-user"></i>
							<input type="text" name="username" id="username" value="" placeholder="用户名"/>
						</div>
						<div class="item_input">
							<i class="fa fa-key"></i>
							<input type="password" name="password" id="password" value="" placeholder="密码"/>
						</div>
					</div>
					<div id="btn">
						<input type="submit" name="log" id="log" value="Login" />
					</div>	
				</form>
					<div class="change">
						<a href="updateuserMenu.html">找回密码</a>
					</div>
			</div>
		</div>
	</body>
</html>
