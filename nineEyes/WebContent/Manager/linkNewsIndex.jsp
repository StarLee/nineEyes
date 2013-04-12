<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${root}/script/jquery.min.js">
	
</script>
<script type="text/javascript" src="${root}/script/jquery-ui.min.js">
	
</script>
<script src="${root}/script/jquery.bgiframe-2.1.1.js"
	type="text/javascript">
	
</script>
<script src="${root}/script/jquery.form.js" type="text/javascript">
	
</script>
<script type="text/javascript"
	src="${root }/script/pageNavigationBar.js"></script>
<script type="text/javascript">

 function showFun(page, form) {

	  	var options = {
	  		url : "${root}/LinkNewsIndex.do",
	  		type : "POST",
	  		data : {pageNum:page}
	  	};
	  	$(form).formParam(options);
	  }
	  $(function(){
	  		$("#page").pageStyleNormal(
	   		{currentPage:${news.current},pageSize:${news.pageSize},pageCount:${news.pages},itemCount:${news.rows }},showFun);
	  	});
</script>
<title>新闻列表</title>
<style type="text/css">
#content 
{
	width: 98%;
	margin: auto;
}
#content tr
{
	height: 30px;
	border-bottom: 1px dashed;
}
</style>
</head>
<body>
	<table id="content">
		<c:forEach items="${news }" var="newss">
			<tr>
				<td><a href="${newss.url }" target="_blank">${newss.title }</a></td>
				<td>${fn:substring(newss.createTime,0,19) }</td>
				<td>${newss.author }</td>
			</tr>
		</c:forEach>
	</table>

	<div id="page"></div>
</body>
</html>