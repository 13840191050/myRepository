<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" type="text/css" href="./css/userMainMenu.css"/>
		<link rel="stylesheet" type="text/css" href="./font-awesome-4.7.0/css/font-awesome.min.css"/>
		<title>XX管理系统</title>
	</head>
	<body>
		<div id="main">
			<div id="left_navi">
				<div class="userwelcome">
					<div class="userwelcometext">
						<a href="mainInformation.jsp" target="iframeBox"><img src="<%=request.getContextPath()%>/images/${db_user.user_head}" ></a>
						<p>${logUserTime }</p>
						<p>${db_user.user_realname }</p>
					</div>
				</div>
				<div class="menu">
					<details class="item">
						<summary class="btn"><i class="fa fa-file-text-o"></i></i>信息管理</summary>
						<a href="<%=request.getContextPath()%>/findAllServlet" target="iframeBox">员工账户信息</a>
						<a href="" target="iframeBox">员工考勤管理</a>
						<a href="" target="iframeBox">员工业绩管理</a>	
					</details>
					<details class="item">
						<summary class="btn"><i class="fa fa-handshake-o"></i></i>客户管理</summary>
						<a href="" target="iframeBox">企业客户查询</a>
						<a href="" target="iframeBox">个人客户查询</a>
						<a href="" target="iframeBox">待签约客户管理</a>	
					</details>
					<details class="item">
						<summary class="btn"><i class="fa fa-comment-o"></i></i></i>员工建议</summary>
						<a href="" target="iframeBox">查看员工留言</a>
						<a href="" target="iframeBox">更多功能，敬请期待</a>
						<a href="" target="iframeBox">更多功能，敬请期待</a>	
					</details>
					<details class="item">
						<summary class="btn"><i class="fa fa-gears"></i><span>用户设置</span></summary>
						<a href="remUserMenu.jsp" target="iframeBox">个人信息修改</a>
						<a href="<%=request.getContextPath()%>/regMainMenu.jsp" target="iframeBox">新员工账号申请</a>
					</details>
					<div id="exit">
						<a href="<%=request.getContextPath()%>/logOutServlet"><i class="fa fa-user-times"></i>退出登录</a>
					</div>
				</div>
			</div>
			<iframe src="mainInformation.jsp" frameborder="no" scrolling="no" name="iframeBox"></iframe>
		</div>
	</body>
</html>

