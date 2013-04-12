<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link type="text/css" href="../css/simple.css" rel="stylesheet" />
<link type="text/css" href="../css/title.css" rel="stylesheet" />
<script type="text/javascript" src="../script/jquery.min.js"></script>
<script type="text/javascript" src="../script/jquery.pikachoose.js"></script>
<script type="text/javascript" src="../script/title.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pikame").PikaChoose({
			transition : [ 0 ],
		});
	});
</script>
</head>
<body>
	<eyes:DefaultNavigation defaultOrder="0"></eyes:DefaultNavigation>
	<div class="main">
		<%@ include file="./head.jsp"%>

		<div>
			<ul id="pikame">
				<li><a href="javascript:void(0);"><img
						src="../images/index/thumb_1.jpg"
						ref="../images/index/flash_1.jpg" /> </a><span>以公关视角驱动的广告策划工作</span>
				</li>
				<li><a href="javascript:void(0);"><img
						src="../images/index/thumb_2.jpg"
						ref="../images/index/flash_2.jpg" /> </a><span>能使广告准确、独特、及时、有效
						地传播</span></li>
				<li><a href="javascript:void(0);"><img
						src="../images/index/thumb_3.jpg"
						ref="../images/index/flash_3.jpg" /> </a><span>促进与目标受众的情感交流，引发公众好感
						<a href="javascript:void(0);">关于</a> </span></li>
			</ul>
		</div>
		<div class="tail">
			<%@ include file="./copyright.jsp"%>
		</div>
	</div>
</body>
</html>