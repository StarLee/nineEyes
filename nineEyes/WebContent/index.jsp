<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="eyes" uri="/eyes" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="Mon,12 May 2001 00:20:00 GMT">
<title>首页</title>
<style type="text/css">
html body {
	padding: 0px;
	margin: 0px;
}
</style>
</head>
<body style="background-color: black;">
	<eyes:bigIndex name="flashURL"></eyes:bigIndex>
	<div
		style="margin: auto; width: 1024px; height: 600px; position: relative; top: 150px;">
		<iframe width="1024px" scrolling="no" height="600px"
				frameborder="0" src="${root }${flashURL}"></iframe> 
	</div>
</body>
</html>