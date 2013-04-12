<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎</title>
<link style="text/css" rel="stylesheet" href="${root }/css/default.css">
<link style="text/css" rel="stylesheet" href="${root}/css/basic.css">
<link style="text/css" rel="stylesheet" href="${root}/css/jquery-ui.css">
<script type="text/javascript" src="${root}/script/jquery.min.js"></script>
<script type="text/javascript" src="${root}/script/jquery-ui.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
h2 {
	color: white;
}

.frame { /*height:700px;*/
	/*width:200px;*/
	/*border: 0px blue solid;*/
	z-index: 10;
}

.right:BEFORE,.right:AFTER {
	display: block;
	clear: both;
}
</style>

</head>
<body style="position: relative; min-height: 100%;">
	<div class="frame">
		<div>
			<%@include file="./top_index.jsp"%>
		</div>
			<div class="left" style="">
				<%@include file="./left_index.jsp"%>
			</div>
			<div style=""
				class="right">
				<!--  <div class="right">
				<div class="tab"></div>
			</div>-->
				<div>
					<jsp:include page="${url }"></jsp:include>
				</div>
			</div>
			<div style="clear: both;"></div>
		
	</div>
	<div>
		<div class="skin_left"
			style="position: absolute; z-index: -7; bottom: 0px; top: 0px; ">
		</div>
		<div class="skin_title"
			style="position: absolute; z-index: -6; top: 0px;"></div>
		<div class="skin_bottom"
			style="position: absolute; z-index: -6; background-color: red;  bottom: 0px;"></div>
	</div>
</body>
</html>