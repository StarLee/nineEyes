<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>视频分类</title>
<script type="text/javascript" src="${root}/script/jquery.min.js">
	
</script>
<script type="text/javascript" src="${root}/script/jquery-ui.min.js">
	
</script>
<script src="${root}/script/jquery.bgiframe-2.1.1.js"
	type="text/javascript">
	
</script>
<script src="${root}/script/jquery.form.js" type="text/javascript">
	
</script>
<link href="${root}/css/jquery.ui.core.css" rel="stylesheet">
<link href="${root}/css/jquery.ui.theme.css" rel="stylesheet">
<link href="${root}/css/jquery.ui.datepicker.css" rel="stylesheet">
<link rel="stylesheet" href="${root}/css/jquery.ui.dialog.css">
<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<div>
		<div style="float: left;width:470px; ">
			<table style="width: 97%;margin: auto;border-collapse: collapse;border: 1px solid;">


				<eyes:MediaCategory name="all">
					<c:forEach items="${all }" var="category">
						<tr>
							<td>${category.id }</td>
							<td>${category.name }</td>
							<td><a href="${root }/ShowMediaCategory.do?id=${category.id}"> 修改</a></td>
						</tr>
					</c:forEach>
				</eyes:MediaCategory>
			</table>
		</div>
		<div style="float: right; width: 300px; border-left: 1px solid;">
			<form action="${root }/SaveMediaCategory.do" method="post">
				<table style="width: 98%; margin: auto;">
					<tr>
						<td>

							<div style="margin: 5px;">
								新分类<input type="text" name="name">
							</div></td>
					</tr>
					<tr>
						<td colspan="2">
							<div>
								<eyes:myCK>
									<ckeditor:editor basePath="${root}/ckeditor/"
										config="${defaultSettings}" editor="content"
										value="${defaultValue}" events="${defaultEvent}" />
								</eyes:myCK>
							</div>
						</td>

					</tr>
					<tr>
						<td align="center"><input type="submit" value="保存"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="clear: both;"></div>
	</div>






</body>
</html>