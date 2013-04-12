<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/root.jsp" %>	
<%@ page import="com.ckeditor.CKEditorConfig"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻编辑</title>
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
<script type="text/javascript" src="${root }/script/newsEdit.js"></script>
<link rel="stylesheet" href="${root }/css/news.css">

</head>
<body>
	<div class="content">
		<div id="uploadIMG">
			<input type="hidden" value="" name="result">
			<form name="myForm" action="" method="post"
				enctype="multipart/form-data" id="uploadForm">
				<div style="border-bottom: 1px dashed;">
					<input type="file" name="file"> <input type="submit"
						value="保存" name="submitt">
				</div>
				<div>
					<input type="button" value="确定" name="comfirm" id="confirm" /> <input
						type="button" value="取消" name="cancel" onclick="cancell()">
				</div>
			</form>
			<div id="message"></div>
		</div>
		<div class="whole">
			<div class="content">
				<div class="rightcontent">
					<div class="ApplyForm leftContentMiddle ">
						<form action="${root}/SaveNews.do" method="post">
							<div class="marginleft ">
								<div class="leftLayoutDesc">标题</div>
								<div>
									<input class="leftLayout" type="text" name="title">
								</div>
							</div>
							<div>
								<div class="leftLayoutDesc">概要信息</div>
								<div class="leftLayout">
									<%
										CKEditorConfig configs = new CKEditorConfig();
										configs.addConfigValue("width", "450");
										configs.addConfigValue("height", "200");
									%>
									<ckeditor:editor basePath="${root}/ckeditor/" editor="outline"
										config="<%=configs %>" value="插入概要" />
								</div>
							</div>
							<%
								CKEditorConfig config2 = new CKEditorConfig();
								config2.addConfigValue("width","800");
								config2.addConfigValue("height", "500");
							%>
							<div>
								<div class="leftLayoutDesc">详细内容</div>
								<div class="leftLayout">
									<eyes:myCK>
										<ckeditor:editor basePath="${root}/ckeditor/"
											config="<%=config2 %>" editor="content"
											value="${defaultValue}" events="${defaultEvent}" />
									</eyes:myCK>
								</div>
							</div>
							<div class="leftLayout">
								<eyes:NewsTypes name="types">
									<c:forEach var="type" items="${types }">
										<input type="radio" class="typeRadio" name="category"
											value="${type.key}">${type.value.name}
									</c:forEach>
								</eyes:NewsTypes>
							</div>
							<div id="sort" style="margin: 10px 30px;"></div>
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