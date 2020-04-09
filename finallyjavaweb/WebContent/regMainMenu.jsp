<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎注册</title>
		<link rel="stylesheet" type="text/css" href="./font-awesome-4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="./css/regMainMenu.css"/>
	</head>
	<body>
		<div id="regMainMenu">
			<div id="regBox">
				<h1>添加用户</h1>
				<form action="addUserServlet" method="post">
					<div class="Box">
						<span class=" regcode fa fa-user"></span>&nbsp;
						<input type="text" name="username" id="username" value="" placeholder="请输入长度为6-20位的用户名"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-key"></span>
						<input type="password" name="userpassword" id="userpassword" value="" placeholder="请输入长度为6-20位的密码"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-key"></span>
						<input type="password" name="userdbpassword" id="userdbpassword" value="" placeholder="再次输入密码"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-envelope-o"></span>
						<input type="text" name="usermail" id="usermail" value="" placeholder="请输入合法邮箱地址"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-phone"></span>&nbsp;
						<input type="text" name="userphone" id="userphone" value="" placeholder="请输入手机号"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-user-o"></span>&nbsp;
						<input type="text" name="userrealname" id="userrealname" value="" placeholder="请输入真实姓名"/>
					</div>
					<div class="Box">
						<span class=" regcode fa fa-id-card"></span>
						<input type="text" name="useridcard" id="useridcard" value="" placeholder="请输入身份证号码"/>
					</div>
					<p>${regError}</p>
					<!-- <div class="Box">
						<input type="checkbox" name="" id="terms" value="" />
						<span id="termsText">我已阅读并接受以下条款<a href="#">《XXXXXX条款》</a></span>
					</div> -->
					<div id="regBtn">
						<input type="submit" name="regsubmit" id="regsubmit" value="确定" />
					</div>
				</form>
			</div>
			
		</div>
	</body>
</html>

