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
<script src="${root}/script/pageNavigationBar.js" type="text/javascript">
	
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

		$("#mediaDialog").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizale" : false,
			"width" : 500,
			"height" : 400,
			"title" : "关联视频",
			"buttons" : {
				"选择" : selectMedia
			}
		});
		$("#insertLinkNewDialog").dialog({
			"autoOpen" : false,
			"modal" : true,
			"resizale" : false,
			"width" : 300,
			"height" : 250,
			"title" : "链接新闻",
			"buttons" : {
				"添加" : insertLinkNews
			}
		});

		$("#uploadForm").ajaxForm({
			url : "${root}/MediaPic.do",
			type : "POST",
			dataType : "json",
			clearForm : true,
			resetForm : true,
			success : makeProcess
		});
	});

	function selectMedia() {
		$("#mediaDialog input:checked").each(
				function(i) {

					var inputRelativeMedia = document.createElement("input");
					$(inputRelativeMedia).attr("type", "hidden");
					$(inputRelativeMedia).attr("name", "relativeMedia");

					$(inputRelativeMedia)
							.attr("value", $(this).data("para").id);

					$("#contentForm").append(inputRelativeMedia);
					var div = document.createElement("div");
					$(div).html(
							$(this).data("para").name + "("
									+ $(this).data("para").time + ")");
					var inputButton = document.createElement("input");
					$(inputButton).attr("type", "button");
					$(inputButton).attr("value", "删除");
					$(inputButton).bind("click", {
						element1 : inputRelativeMedia,
						element2 : div,
					}, function(event) {
						$(event.data.element1).remove();
						$(event.data.element2).remove();
					});
					$(div).append(inputButton);
					$("#mediaContainer").append(div);

					//alert($(this).data("para").id);
					//alert($(this).data("para").name);
					//alert($(this).data("para").time);
				});
		$(this).dialog("close");
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
	
	function insertLinkNews()
	{
		var inputPicURL = document.createElement("input");
		$(inputPicURL).attr("type", "hidden");
		$(inputPicURL).attr("name", "linkNewsNames");
		$(inputPicURL).attr("value", $("input[name='dialog_linkNewsName']").attr("value"));
		var inputPicType = document.createElement("input");
		$(inputPicType).attr("type", "hidden");
		$(inputPicType).attr("name", "linkNewsURL");
		$(inputPicType).attr("value", $("input[name='dialog_linkNewsURL']").attr("value"));

		$("#contentForm").append(inputPicURL);
		$("#contentForm").append(inputPicType);
		var div = document.createElement("div");
		$(div).html( $("input[name='dialog_linkNewsName']").attr("value"));
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
		$("#newsContainer").append(div);
		$("#insertLinkNewDialog").dialog("close");
	}
	
	function insertNews()
	{
		$("#insertLinkNewDialog").dialog("open");
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

	function getData() {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "${root}/MediaIndexAjax.do",
			success : show
		});

	}
	function showFun(page, form) {
		var options = {
			url : "${root}/MediaIndexAjax.do",
			type : "POST",
			reset : true,
			clearForm : true,
			dataType : "json",
			data : {
				pageNum : page
			},
			success : show
		};
		$(form).ajaxSubmit(options);
	}
	function show(datas) {
		var data = datas[0];
		$("#page").pageStyleNormal({
			currentPage : data.extraElements.currentPage,
			pageSize : data.extraElements.pageSize,
			pageCount : data.extraElements.pageCount,
			itemCount : data.extraElements.recordsCount,
		}, showFun);
		var datas = data.listElements;
		var table = document.createElement("table");
		$(table).css({
			width : "100%",
			height : "100%",
		})
		for ( var n = 0; n < datas.length; n++) {
			var dataa = datas[n];
			var tr = table.insertRow(table.rows.length);
			$(tr).css({
				"border-bottom" : "1px solid"
			});
			var content = [ dataa.title, dataa.createtime.substring(0, 10) ];
			for ( var i = 0; i < content.length; i++) {
				var td = tr.insertCell(tr.cells.length);
				$(td).html(content[i]);
			}
			var tdselect = tr.insertCell(tr.cells.length);
			var checkBox = document.createElement("input");
			$(checkBox).attr("type", "checkbox");
			$(checkBox).attr("name", "relativeMedia");
			$(checkBox).attr("value", dataa.id);
			$(checkBox).data("para", {
				id : dataa.id,
				name : dataa.title,
				time : dataa.createtime.substring(0, 10)
			});
			$(tdselect).html(checkBox);
		}
		$("#content").html(table);
		$("#mediaDialog").dialog("open");
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
						<form action="${root}/SaveEvent.do" method="post" id="contentForm">
							<table>
								<tr>
									<td style="width: 80px;">标题</td>
									<td align="left" valign="middle"><input type="text"
										name="title"><select name="category">
											<eyes:EventType name="all">
												<c:forEach items="${all }" var="category">
													<option value="${category.key }">${category.value
														}</option>
												</c:forEach>
											</eyes:EventType>
									</select>
									</td>
								</tr>
								<tr>
									<td>概要</td>
									<td><textarea rows="2" cols="50" name="outline"></textarea>
									</td>
								</tr>
							</table>
							<div class="marginleft" style="margin-left: 30px;">
								<input type="button" class="button" onclick="insertImg()"
									value="插入图片" /> <input type="button" class="button"
									onclick="getData()" value="关联视频" /> <input type="button"
									class="button" onclick="insertNews()" value="链接新闻" />
							</div>
							<div style="border-bottom: 1px dashed; margin: 2px 2px;"></div>
							<div id="picContainer" class="marginleft"
								style="margin-left: 30px;"></div>
							<div style="border-bottom: 1px dashed; margin: 2px 2px;"></div>
							<div id="mediaContainer" class="marginleft"
								style="margin-left: 30px;"></div>
							<div style="border-bottom: 1px dashed; margin: 2px 2px;"></div>
							<div id="newsContainer" class="marginleft"
								style="margin-left: 30px;"></div>
							<div>
								<span style="font-size: 12px; color: red;">attentions:(1)shift+Enter换行(2)本编辑器不适用当成office(3)如果是从word拷贝,图片请重新插入</span>
							</div>
							<div>
								<eyes:myCK>
									<ckeditor:editor basePath="${root}/ckeditor/"
										config="${defaultSettings}" editor="intro"
										value="${defaultValue}" events="${defaultEvent}" />
								</eyes:myCK>
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
	</div>
	<div id="mediaDialog">
		<div id="content"></div>
		<div id="page"></div>
	</div>
	<div id="insertLinkNewDialog">
		<div>
			加入名字：<input type="text" name="dialog_linkNewsName">
		</div>
		<div>
			加入链接：<input type="text" name="dialog_linkNewsURL" value="http://">
		</div>
	</div>
</body>
</html>