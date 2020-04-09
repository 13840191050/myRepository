<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>修改个人信息</title>
		<link rel="stylesheet" type="text/css" href="./css/mainInformation.css"/>
		<link rel="stylesheet" type="text/css" href="./font-awesome-4.7.0/css/font-awesome.min.css"/>
		<script src="./echarts/echarts.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div id="numTop">
			<div class="viewNum" style="background-color: #ffac41;">
				<p>员工数量</p>
				<p>${resultNumByDb }</p>
				<hr >
				<span>单位：人<i class="fa fa-user-circle"></i></span>
			</div>
			<div class="viewNum" style="background-color: #512b58;">
				<p>销售总额</p>
				<p>30</p>
				<hr >
				<span>单位：万元<i class="fa fa-signal"></i></span>
			</div>
			<div class="viewNum" style="background-color: #1eb2a6;">
				<p>待定选项</p>
				<p>NULL</p>
				<hr >
				<span>单位：NULL<i class="fa fa-user-circle"></i></span>
			</div>
		</div>
		<div id="echarst">
			<div id="main" ></div>
			<div id="main2"></div>
		</div>
		<div id="informationView">
			<div class="navi">
				<p><i class="fa fa-mail-forward"></i>传送门</p>
				<hr >
				<div class="naviChange">
					<a href="<%=request.getContextPath()%>/findAllServlet">
						<i class="fa fa-search"></i>
						<p >查看员工</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="<%=request.getContextPath()%>/regMainMenu.jsp">
						<i class="fa fa-user-plus"></i>
						<p >添加员工</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="">
						<i class="fa fa-heart"></i>
						<p >选项</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="">
						<i class="fa fa-heart"></i>
						<p >选项</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="">
						<i class="fa fa-heart"></i>
						<p >选项</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="">
						<i class="fa fa-heart"></i>
						<p >选项</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="">
						<i class="fa fa-heart"></i>
						<p >选项</p>
					</a>
				</div>
				<div class="naviChange">
					<a href="<%=request.getContextPath()%>/remUserMenu.jsp">
						<i class="fa fa-smile-o"></i>
						<p >个人信息</p>
					</a>
				</div>
			</div>
			
			<div class="navi" style="margin-left: 110px;width: 500px;">
				<p><i class="fa fa-bullhorn"></i>公司动态</p>
				<hr >
				<li><a href="">“众志成城，武汉加油”</a></li>
				<li><a href="">《提高生产力》主题会议圆满成功</a></li>
				<li><a href="">震惊！公司内部竟然会有这种事？！</a></li>
				<li><a href="">喜讯！公司"996"工作制改为"007"工作制，员工热泪盈眶</a></li>
				<li><a href="">《论员工应该不休息》主题讲座</a></li>
				<li><a href="">2020年放假安排</a></li>
				<li><a href="">关于管理系统1.0.1版本更新文档</a></li>
				<li><a href="">热烈庆祝系统BUG首次小于200！</a></li>
			</div>
		</div>
		<script type="text/javascript">
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));
			var myChart2 = echarts.init(document.getElementById('main2'));
			// 指定图表的配置项和数据
			var option = {
				xAxis: {
					type: 'category',
					data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				},
				yAxis: {
					type: 'value'
				},
				series: [{
					data: [0, 932, 901, 934, 1290, 1330, 1320],
					type: 'line'
				}]
			};
			
			var option2 = {
			    tooltip: {
			        trigger: 'item',
			        formatter: '{a} <br/>{b}: {c} ({d}%)'
			    },
			    legend: {
			        orient: 'vertical',
			        left: 10,
			        data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
			    },
			    series: [
			        {
			            name: '访问来源',
			            type: 'pie',
			            radius: ['50%', '70%'],
			            avoidLabelOverlap: false,
			            label: {
			                show: false,
			                position: 'center'
			            },
			            emphasis: {
			                label: {
			                    show: true,
			                    fontSize: '30',
			                    fontWeight: 'bold'
			                }
			            },
			            labelLine: {
			                show: false
			            },
			            data: [
			                {value: 335, name: '直接访问'},
			                {value: 310, name: '邮件营销'},
			                {value: 234, name: '联盟广告'},
			                {value: 135, name: '视频广告'},
			                {value: 1548, name: '搜索引擎'}
			            ]
			        }
			    ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			myChart2.setOption(option2);
		</script>
	</body>
</html>
