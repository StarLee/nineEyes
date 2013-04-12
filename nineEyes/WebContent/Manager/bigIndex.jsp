<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大首页</title>
<script type="text/javascript" src="${root }/script/jquery.min.js"></script>
<script type="text/javascript" src="${root }/script/jquery.form.js"></script>
<script type="text/javascript">
	$(function() {
		var options = {
			dataType : "json",
			clearForm : true,
			type : "post",
			success : showResponse
		// post-submit callback 

		};
		$("form[name='upload']").ajaxForm(options);
	});
	function showResponse(data) {
		$("#tip").html(data[0].bean.fileNameOld);
		var input =document.createElement("input");
		$(input).attr("type","hidden");
		$(input).attr("name","fileURI");
		$(input).attr("value",data[0].bean.path);
		$("form[name='content']").append(input);
		$("#tipContainer").show();
	}
	function confirmUp() {
		if (confirm("请确认上传")) {
			$("form[name='upload']").submit();
		}
	}
</script>

</head>
<body>
	<div>

		<div style="margin: 5px 5px; border-bottom: 1px dashed;"></div>
		<div
			style="margin: auto; height: 50px; width: 600px; margin: 10px 10px;">
			<form action="${root }/BigIndex.do" name="upload" method="post"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td>请选择上传的flash</td>
						<td><input type="file" name="file"
							onchange="javascript:confirmUp()"></td>
					</tr>

				</table>
			</form>
		</div>
		<div style="margin: 5px 5px; border-bottom: 1px dashed;"></div>

		<div style="margin: 10px 10px;">
			<div style="display: none;" id="tipContainer">
				文件 <span id="tip" style="color: red"> </span> 上传成功
			</div>
			<form action="${root }/SaveBigIndex.do" method="post" name="content">
				<table>
					<tr>
						<td>标题：</td>
						<td>
							<input type="text" name="name">
						</td>
					</tr>
					<tr height="30px;">
						<td>加入旁白：</td>
						<td><input type="text" name="intro"></input>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="保存"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin: 5px 5px; border-bottom: 1px dashed;"></div>
</body>
</html>