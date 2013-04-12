<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>视频分类编辑</title>
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


<style type="text/css">
.tableBasic td {
	height: 30px;
}

input[type="text"] {
	height: 20px;
}

textarea {
	font-size: 12px;
}
</style>
</head>

<body>
	<div class="content">
		<div class="whole">
			<div class="content">
				<div class="rightcontent">

					<div class="ApplyForm leftContentMiddle ">
						<form action="${root}/UpdateMediaCategory.do"
							method="post">
							<input type="hidden" value="${category.id}" name="id">
							<div class="marginleft ">
								<div style="margin-left: 30px;">
									标题<input type="text" name="name" value="${category.name}">
								</div>
							</div>
							
							<eyes:myCK >
								<ckeditor:editor basePath="${root}/ckeditor/"
									config="${defaultSettings}" editor="content"
									value="${category.intro}" events="${defaultEvent}" />
							</eyes:myCK>
							
							<input type="submit" value="保存编辑">
						</form>
					</div>
					<div class="rightBgbottom"></div>
				</div>
			</div>
			<div style="clear: both;"></div>
			<div class="footer"></div>
		</div>
	</div>
</body>
</html>