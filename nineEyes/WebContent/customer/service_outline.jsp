<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>服务</title>
<link type="text/css" href="../css/title.css" rel="stylesheet" />
<style type="text/css">
html body
{
font-size: 12px;
}
.spread_service_title td {
	margin: 0px 0px;
	padding: 0px 0px;
	text-align: center;
}

.service_introduce {
	height: 467px;
	background-color: #eaeae5;
	padding: 0px 5px;
	overflow: hidden;
}
</style>
<script type="text/javascript" src="../script/jquery.min.js"></script>
<script type="text/javascript" src="../script/title.js"></script>
<script src="${root}/script/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript">
$(function()
		{
			loadContent("0");		
		});
function loadContent(type)
{
	var form=document.createElement("form");
	var input=document.createElement("input");
	$(input).attr("name","type");
	$(input).attr("type","hidden");
	$(input).attr("value",type);
	$(form).append(input);
	var options={
	        url:"${root}/customer/LoadOutline.do",      
	        type:"post",    
	       	dataType:"json",       
	        clearForm:true,         
	        resetForm:true, 
	        success:function(data)
	        {
	        	$("#service_introduce").html(data[0].extraElements.content);
	        }
	};
	$(form).ajaxSubmit(options);
}
</script>
</head>
<body>
	<eyes:DefaultNavigation defaultOrder="1"></eyes:DefaultNavigation>
	<div class="main">
		<%@ include file="./head.jsp"%>
		<div>
			<div style="width: 378px; float: left; height: 500px;">
				<div style="height: 29px; background-color: #dedede;">
					<div
						style="background-repeat: no-repeat; margin: auto; height: 29px; width: 121px; background-image: url('../images/service/data_detect_service.gif');"></div>
				</div>
				<div style="width: 378px; height: 265px;">
					<img alt="请替换" src="../images/service/data_detective_content.gif">
				</div>
				<div style="width: 378px; height: 257px;">
					<img alt="请替换" src="../images/service/data_detective_content2.gif">
				</div>
			</div>
			<div style="width: 383px; float: left;">
				<div style="height: 29px; background-color: #eaeae5;">
					<div
						style="background-repeat: no-repeat; margin: auto; height: 29px; width: 123px; background-image: url('../images/service/brand_spread_service.gif');"></div>
				</div>
				<div style="height: 19px; background-color: black;"
					class="spread_service_title">

					<table class="spread_service_title" width="100%"
						style="margin: 0px; padding: 0px; border: 0px; border-collapse: collapse;">
						<tr>
							<td><img style="cursor: pointer;" onclick="loadContent('0')" src="../images/service/band_market.gif">
							</td>
							<td><img style="cursor: pointer;" onclick="loadContent('1')" src="../images/service/event_market.gif">
							</td>
							<td><img style="cursor: pointer;" onclick="loadContent('2')" src="../images/service/file_create.gif">
							</td>
							<td><img style="cursor: pointer;" onclick="loadContent('3')" src="../images/service/goverment_relations.gif">
							</td>
							<td><img style="cursor: pointer;" onclick="loadContent('4')" src="../images/service/artist_cooperate.gif">
							</td>
						</tr>
					</table>

				</div>
				<div style="height: 504px; background-color: #eaeae5;">
					<div class="service_introduce" id="service_introduce"></div>
					<div style="height: 37px; background-color: black;">
						<img alt="" src="../images/service/relate_case.gif"
							style="float: right;">
					</div>
				</div>
			</div>
			<div style="width: 199px; float: left; background-color: #cbd2a7;">
				<div style="height: 29px; background-color: #cbd2a7;">
					<div
						style="background-repeat: no-repeat; margin: auto; height: 29px; width: 93px; background-image: url('../images/service/idea_report_service.gif');"></div>
				</div>
				<div
					style="height: 19px; background-image: url('../images/service/integrated_idea.gif');"></div>
				<div style="height: 200px;overflow: hidden;">内容</div>
				<div
					style="height: 19px; background-image: url('../images/service/paper_presentation.gif');"></div>
				<div style="height: 285px;">内容</div>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div class="tail">
			<%@ include file="./copyright.jsp"%>
		</div>
	</div>
</body>
</html>