<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>视频编辑</title>
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
		//alert(editorCustom.editor.config.theme);
		$("#uploadIMG").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizable" : false,
			"open" : checkVar,
			"width" : 400,
			"height" : 200,
			"close" : function() {
				var form = $(this).find("form");
				form.each(function(i) {
					this.reset();
				});
			}
		});
		
		$("#picTypeDialog").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizable" : false,
			"width" : 200,
			"height" : 100,
			"title":"更改位置"
		});
		
		$("#uploadForm").ajaxForm({
			url : "${root}/MediaPic.do",
			type : "POST",
			dataType : "json",
			clearForm : true,
			resetForm : true,
			success : makeProcess
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
	
	function makeProcess(data, status) {
		if (data[0].bean.code == 1) {
			$("#message").html("上传成功");
			$("input[name='result']").attr("value", data[0].bean.path);
			var inputPicURL = document.createElement("input");
			$(inputPicURL).attr("type", "hidden");
			$(inputPicURL).attr("name", "picURL");
			$(inputPicURL).attr("value", data[0].bean.path);

			var inputPicType = document.createElement("input");
			$(inputPicType).attr("type", "hidden");
			$(inputPicType).attr("name", "picType");
			var x = document.getElementById("picType");
			//alert(data[0].extraElements.picType);
			$(inputPicType).attr("value", data[0].extraElements.picType);

			$("#contentForm").append(inputPicURL);
			$("#contentForm").append(inputPicType);
			var div = document.createElement("div");
			$(div).html(data[0].bean.fileNameOld);
			var inputButton = document.createElement("input");
			$(inputButton).attr("type", "button");
			$(inputButton).attr("value", "删除");
			$(inputButton).bind("click", {
				element1 : inputPicURL,
				element2 : div,
				element3 : inputPicType
			}, function(event) {
				$(event.data.element1).remove();
				$(event.data.element2).remove();
				$(event.data.element3).remove();
			});
			$(div).append(inputButton);
			$("#picContainer").append(div);
		}
	}

	function checkVar() {
		if (editorCustom == null || editorCustom == undefined)
			alert("网络有问题，上传图片将不会成功");
	}

	function insertImg() {
		$("#uploadIMG").dialog("open");
	}
	function getIMG() {
		var url = $("input[name='result']").attr("value");
		if (confirm("是否加入到文档？")) {
			if (url != null && url != undefined) {
				editorCustom.editor
						.insertHtml("<img width='700' height='525' src='${root}" + url + "'>");
			}
		}
		$("#uploadIMG").dialog("close");
	}
	function cancell() {
		$("#uploadIMG").dialog("close");
	}
	function g_deletePic(picID)
	{
		var input=document.createElement("input");
		$(input).attr("name","picID");
		$(input).attr("type","hidden");
		$(input).attr("value",picID);
		$("#deletePic").append(input);
		$("#deletePic").submit();
	}
</script>



<style type="text/css">
.tableBasic td {
	height: 30px;
}

input[type="text"] {
	height: 20px;
}

select {
	height: 20px;
}

textarea {
	font-size: 12px;
}

#uploadIMG {
	font-size: 12px !important;
}

.marginAround {
	margin: 5px 5px;
}
</style>
</head>

<body>
	<div class="content">
		<div id="uploadIMG">
			<input type="hidden" value="" name="result">
			<form name="myForm" action="" method="post"
				enctype="multipart/form-data" id="uploadForm">
				<div style="border-bottom: 1px dashed;">
					<div>
						选择图片<input type="file" name="file" style="font-size: 12px;">
					</div>
					<div>
						选择位置<select name="picType" id="picType" style="font-size: 12px;">
							<eyes:MediaPicType name="types">
								<c:forEach items="${types }" var="type">
									<option value="${type.key }">${type.value }</option>
								</c:forEach>
							</eyes:MediaPicType>
						</select>
					</div>
					<input type="submit" value="保存图片" name="submitt"
						style="font-size: 12px;">
				</div>
				<div>
					<input type="button" value="确定" name="comfirm" onclick="getIMG()"
						style="font-size: 12px;" /> <input type="button" value="取消"
						name="cancel" onclick="cancell()" style="font-size: 12px;">
				</div>
			</form>
			<div id="message"></div>
		</div>
		<div class="whole">
			<div class="content">
				<div class="rightcontent">
					<div class="ApplyForm leftContentMiddle ">
						<form action="${root}/UpdateMedia.do" method="post"
							id="contentForm">
							<input type="hidden" name="id" value="${media.id }">
							<table>
								<tr>
									<td style="width: 80px;">标题</td>
									<td align="left" valign="middle"><input type="text"
										name="title" value="${media.title }"><select
										name="category">
											<eyes:MediaCategory name="all">
												<c:forEach items="${all }" var="category">
													<option value="${category.id }">${category.name }</option>
												</c:forEach>
											</eyes:MediaCategory>
									</select><span style="color: red;">请注意选择类型</span> 原始类型为<span
										style="font-weight: bold;">${media.categoryObject.name
											}</span>
									</td>
								</tr>
								<tr>
									<td>视频地址</td>
									<td><input type="text" name="url" style="width: 500px;"
										value="${media.url }"></td>
								</tr>
								<tr>
									<td>视频概要</td>
									<td><textarea rows="2" cols="50" name="outline">${media.outline }</textarea>
									</td>
								</tr>
							</table>
							<div class="marginleft" style="margin-left: 30px;">
								<input type="button" class="button" onclick="insertImg()"
									value="插入图片" /> <span style="font-size: 12px; color: red;">attentions:(1)shift+Enter换行(2)本编辑器不适用当成office(3)如果是从word拷贝,图片请重新插入</span>
							</div>
							<div id="picContainer"></div>
							<div>
								<eyes:myCK>
									<ckeditor:editor basePath="${root}/ckeditor/"
										config="${defaultSettings}" editor="intro"
										value="${media.intro}" events="${defaultEvent}" />
								</eyes:myCK>
							</div>
							<div>
								<table>
									<c:forEach items="${media.pictures }" var="picture">
										<tr>
											<td><img alt="" src="${root }${picture.url}" width="80"
												height="60">
											</td>
											<td id="picTypeshow_${picture.id}">${picture.typeCN }</td>
											<td>
											<span>
												<input type="button" onclick="updatePicType(${picture.id})" value="更改位置">
											</span> </td>
											<td><input type="button" value="删除"
												onclick="g_deletePic(${picture.id})"></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							<div style="margin-left: 30px;"></div>
							<input type="submit" value="保存编辑">
						</form>
					</div>
					<div class="rightBgbottom"></div>
				</div>
			</div>
			<div style="clear: both;"></div>
			<div class="footer"></div>
		</div>
		<form action="${root }/DeleteMediaPic.do" method="post" id="deletePic">
			<input type="hidden" value="${media.id }" name="mediaID">
		</form>
	</div>
	<div id="picTypeDialog">
		<form method="post" name="updatePicTypeForm" id="updatePicTypeForm">
		<eyes:MediaPicType name="picType">
			<select style="font-size: 12px;" name="type">
				<c:forEach var="types" items="${picType }">
					<option value="${types.key }" style="font-size: 12px;">${types.value }</option>
				</c:forEach>
			</select>
			
		</eyes:MediaPicType>
		</form>
	</div>
</body>
</html>