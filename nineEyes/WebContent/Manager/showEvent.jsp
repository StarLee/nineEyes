<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>活动/交流</title>
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

	$(function(){
		$("#picTypeDialog").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizable" : false,
			"width" : 200,
			"height" : 100,
			"title":"更改位置"
		});
		$("#updatePicTypeForm").ajaxForm({
			url : "${root}/UpdateMediaPicType.do",
			type : "POST",
			dataType : "json",
			resetForm : true,
			success : changeType
		});
	});

	function changeType(data)
	{
		var id="#picTypeshow_"+data[0].extraElements.id;
		$(id).html(data[0].extraElements.type);
		$("#picTypeDialog").dialog("close");
	}
	
	
	function updatePicType(id)
	{
		//alert("abc");
		var input=document.createElement("input");
		$(input).attr("name","id");
		$(input).attr("type","hidden");
		$(input).attr("value",id);
		$("#updatePicTypeForm").append(input);
		var inputSubmit=document.createElement("input");
		$(inputSubmit).attr("type","button");
		$(inputSubmit).attr("value","更改");
		$(inputSubmit).attr("style","font-size: 12px");
		$(inputSubmit).bind("click",{deElement:input},function(e){
			$("#updatePicTypeForm").submit();
			$(e.data.deElement).remove();
			$(this).remove();
		});		
		$("#updatePicTypeForm").append(inputSubmit);
		$("#picTypeDialog").dialog("open");
	}

	function g_update() {
		document.getElementById("update").submit();;
	}
	function g_delePic(picID)
	{
		var form=document.getElementById("delete");
		$(form).attr("action","${root}/DeleteEventPic.do");
		var input=document.createElement("input");
		$(input).attr("name","picID");
		$(input).attr("type","hidden");
		$(input).attr("value",picID);
		$(form).append(input);
		$(form).submit();
	}
	function g_deleMedia(mediaID)
	{
		var form=document.getElementById("delete");
		$(form).attr("action","${root}/DeleteEventMedia.do");
		var input=document.createElement("input");
		$(input).attr("name","mediaID");
		$(input).attr("type","hidden");
		$(input).attr("value",mediaID);
		$(form).append(input);
		$(form).submit();
	}
	function g_deleLink(linkID)
	{
		var form=document.getElementById("delete");
		$(form).attr("action","${root}/DeleteEventLinkNews.do");
		var input=document.createElement("input");
		$(input).attr("name","linkID");
		$(input).attr("type","hidden");
		$(input).attr("value",linkID);
		$(form).append(input);
		$(form).submit();
	}
</script>
</head>
<body>
	<table width="100%">
		<tr>
			<td><input type="button" value="编辑内容" onclick="g_update()">
			</td>
		</tr>
		<tr>
			<td>${event.title }</td>
		</tr>
		<tr>
			<td width="600px">${event.intro }</td>
		</tr>
		<tr>
			<td><table>
					<tr>
						<td><c:forEach items="${event.medias }" var="media">
								<tr>
									<td><a href="${root }/MediaPlay.do?id=${media.id}">${media.title}</a>
										<input type="button" value="删除关联"
										onclick="g_deleMedia(${media.id})"></td>
								</tr>
							</c:forEach></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>
				<table>
					<c:forEach items="${event.pictures }" var="picture">
						<tr>

							<td><img alt="" src="${root }${picture.url }" width="200"
								height="150"></td>
							<td id="picTypeshow_${picture.id}">${picture.typeCN }</td>
							<td><span> <input type="button"
									onclick="updatePicType(${picture.id})" value="更改位置"> </span></td>
							<td><input type="button" value="删除图片"
								onclick="g_delePic(${picture.id})">
							</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
			<td>
				<table>
					<c:forEach items="${event.linkNews }" var="linkNew">
						<tr>
							<td><a href="${linkNew.url }">${linkNew.title }</a> <input
								type="button" value="删除链接" onclick="g_deleLink(${linkNew.id})">
							</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
	</table>
	<form id="update" action="${root }/ShowEventUpdate.do" method="post">
		<input type="hidden" name="id" value="${event.id }">
	</form>
	<form id="delete" method="post">
		<input type="hidden" name="eventID" value="${event.id }">
	</form>
	<div id="picTypeDialog">
		<form method="post" name="updatePicTypeForm" id="updatePicTypeForm">
			<eyes:MediaPicType name="picType">
				<select style="font-size: 12px;" name="type">
					<c:forEach var="types" items="${picType }">
						<option value="${types.key }" style="font-size: 12px;">${types.value
							}</option>
					</c:forEach>
				</select>

			</eyes:MediaPicType>
		</form>
	</div>
</body>
</html>