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

<script type="text/javascript" src="../script/jquery.min.js"></script>
<script type="text/javascript" src="../script/title.js"></script>
<script src="${root}/script/jquery.form.js" type="text/javascript"></script>
<style type="text/css">
html,body
{
	height: 100%;
}
</style>

</head>
<body>
	${news.content }
</body>
</html>