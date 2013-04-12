<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内容</title>
<link type="text/css" href="../css/title.css" rel="stylesheet" />
<style type="text/css">
html body
{
font-size: 12px;
}
.spread_service_title td {
	margin: 0px 0px;
	padding: 0px 0px;
	text-align: center;
}

.service_introduce {
	height: 467px;
	background-color: #eaeae5;
	padding: 0px 5px;
	overflow: hidden;
}
</style>
<script type="text/javascript" src="../script/jquery.min.js"></script>
<script type="text/javascript" src="../script/title.js"></script>
<script src="${root}/script/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript">
$(function()
		{
		
		});

</script>
</head>
<body>
	<eyes:DefaultNavigation defaultOrder="1"></eyes:DefaultNavigation>
	<div class="main">
		<%@ include file="./head.jsp"%>
		<div style="height: 100%;width: 960px;">
			<!--  <iframe id="content_iframe" name="content_iframe" frameborder="0" marginheight="100%" scrolling="no" style="height: 100%;width: 960px;border: none;" src="${root }/customer/ShowNewsConfirm.do?id=${news.id}" onload="document.getElementById('content_iframe').style.height=document.getElementById('content_iframe').document.body.scrollHeight"></iframe>-->
			${news.content }
		</div>
		
		<div class="tail">
			<%@ include file="./copyright.jsp"%>
		</div>
	</div>
</body>
</html>