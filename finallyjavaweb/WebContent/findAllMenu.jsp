<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>全部用户信息</title>
		<link rel="stylesheet" type="text/css" href="./css/findAllUserMenu.css"/>
		<script type="text/javascript">
					//1.如果触发selectall()事件 chkone都被选中\
					
					function selectAll(){
						var new_chkall=document.getElementById("chkall");
						var new_chkones=document.getElementsByName("chkone");
						for (var i = 0; i < new_chkones.length; i++) {
							//new_chkall被点击时返回值为true   每次循环遍历都把值赋给new_chkones
								new_chkones[i].checked=new_chkall.checked;
						}
					}
					//1.如果chkOne都被选中   全选按钮也被选中  如果只选中一个子按钮  那么全选按钮不亮
					function chkOne(){
						//拿到全选框的值
						var new_chkall=document.getElementById("chkall");
						var new_chkones=document.getElementsByName("chkone");
						var flag=true;
						for (var i = 0; i < new_chkones.length; i++) {
		
							if (!new_chkones[i].checked) {
									flag=false;
							}
		
						}
						new_chkall.checked=flag;
					}
				</script>
	</head>
	<body>
		<div id="tilte">
			<p>全部用户信息</p>
		</div>
		<hr>
		<div id="userinformation">
			<form action="" method="post">
				<input type="checkbox" name="chkall" id="chkall" onclick="selectAll()"/>全选
				<table border="0" >
					<tr height="50px">
						<td >选择</td>
						<td >用户名</td>
						<td >密码</td>
						<td >邮箱</td>
						<td>联系电话</td>
						<td>真实姓名</td>
						<td>身份证号</td>
						<td>用户权限</td>
						<td>用户操作</td>
					</tr>
					<c:forEach items="${userFindAll }" var="user" >
					<tr>
						<td><input type="checkbox" name="chkone" value="${user.user_id }" onclick="chkOne()"/></td>
						<td>${user.user_name }</td>
						<td>${user.user_password }</td>
						<td>${user.user_email }</td>
						<td>${user.user_phone }</td>
						<td>${user.user_realname }</td>
						<td>${user.user_idcard }</td>
						<td >
						<c:if test="${user.user_role==0 }">
						普通用户
						</c:if>
						<c:if test="${user.user_role==1 }">
						管理员
						</c:if>
						</td>
						<td>
							<a href="#">修改</a>
							<a href="#">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		
		
	</body>
</html>
