<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
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
<link rel="stylesheet" type="text/css" href="${root }/css/example1.css" />
<script type="text/javascript" src="${root}/script/jquery-1.2.1.pack.js"></script>
<script type="text/javascript" src="${root}/script/jMyCarousel.js"></script>
<!-- Optional -->
<script type="text/javascript" src="${root}/script/jquery.mousewheel.js"></script>
<script type="text/javascript">
	$(function() {
		$(".jMyCarousel").jMyCarousel({
			visible : '520px',
			eltByElt : true,
			speed : 2000,
			auto : true,
			mouseWheel : true,
			evtStart : 'mouseover'
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#movie_click").bind("click", function() {
			if ($("#movie_pic").css("display") == "none")
				$("#movie_pic").slideDown("fast");
			else
				$("#movie_pic").slideUp("fast");
			;
		});

	});
</script>
<style type="text/css">
html body {
	margin: 0px;
	padding: 0px;
}

.title {
	height: 113px;
	background-image: url("../images/head.gif");
	background-repeat: repeat-x;
	width: 960px;
}

.logo {
	height: 49px;
	width: 212px;
	background-image: url("../images/logo.gif");
	position: relative;
	top: 29px;
	left: 145px;
	float: left;
}

.eyes {
	height: 61px;
	width: 225px;
	background-image: url("../images/EYES.gif");
	position: relative;
	top: 41px;
	left: 177px;
	float: left;
}

.contact {
	height: 113px;
	width: 272px;
	/*background-image: url("../images/contact_us.gif");*/
	position: relative;
	/*top: 51px;*/
	left: 251px;
	float: left;
}

.visitors {
	height: 51px;
	width: 272px;
}

.middle_left {
	width: 371px;
}

.titleDelimiter {
	position: relative;
	left: -64px;
	float: left;
	top: 15px;
	height: 98px;
}

.delimiter {
	width: 3px;
	background-repeat: repeat-y;
	background-image: url("../images/delimiter.gif");
}

.middle_left_title {
	height: 32px;
}

.middle_left_title li {
	display: inline;
}

.left_margin {
	margin-left: 10px;
}

.motto {
	height: 30px;
}

.navication {
	height: 45px;
}
img embed
{
 border: 0px;
}
</style>
</head>
<body style="background-color: #bfbfbf;">
	<div style="width: 960px; margin: auto; background-color: #dfdfdf;">
		<div class="title">
			<div class="logo"></div>
			<div class="eyes"></div>
			<div class="titleDelimiter delimiter"></div>
			<div class="contact">
				<div class="visitors">
					<div style="height: 29px;"></div>
					<table width="100%">
						<tr>
							<td width="145"></td>
							<td>到访人数1989</td>
						</tr>
					</table>
				</div>
				<div class="contact1">
					<img src="../images/contact_us.gif" border="0" usemap="#planetmap"
						alt="Planets" />
					<map name="planetmap" id="planetmap">
						<area shape="rect" coords="0,0,205,43" href="sun.html" alt="Sun" />
					</map>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div class="middle">
			<table width="100%" style="border: 0px; border-collapse: collapse;">
				<tr>
					<td class="middle_left" title="左边" valign="top">
						<div class="middle_left_title">

							<ul style="list-style: none; list-style-position: inside;"
								title="导航">
								<li><span class="left_margin"></span> <img alt=""
									src="../images/index.gif">
								</li>
								<li><span class="left_margin"></span> <img alt=""
									src="../images/composition.gif">
								</li>
								<li><span class="left_margin"></span> <img alt=""
									src="../images/activity.gif">
								</li>
								<li><span class="left_margin"></span> <img alt=""
									src="../images/coor.gif">
								</li>
								<li><span class="left_margin"></span> <img alt=""
									src="../images/community.gif">
								</li>
							</ul>

						</div>

						<div>
							<div class="newsContent" style="margin-left: 52px;">
								<table width="100%">
									<eyes:NewsTop name="newss">
										<c:forEach var="news" varStatus="count" items="${newss }">
											<tr>
												<td><c:choose>

														<c:when test="${count.count eq 1 }">
															<h3 style="height: 13px;">${news.title }</h3>
														</c:when>
														<c:otherwise>${news.title }</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
									</eyes:NewsTop>
								</table>
							</div>
						</div>
						<div>
							<img alt="" src="../images/flash_inbodyleft.gif" border="0px"
								width="371"> <img alt=""
								src="../images/flash_inbodyleft-59.gif" border="0px;"
								width="371">
						</div></td>
					<td class="delimiter"></td>
					<td class="middle_right" title="右边" valign="top" height="100%">
						<table width="100%" height="100%" style="height: 100%;">
							<tr>
								<td height="30">
									<div class="motto">
										<div>
											<img alt="" src="../images/little.gif">
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td valign="top">
									<div>
										<div class="navication" style="margin-left: 50px;">
											<img alt="" src="../images/MOIVE.gif" id="movie_click">
										</div>
										<div id="movie_pic" style="margin-left: 30px;">
											<!--  <img alt="" src="../images/picture_moive.gif">-->
											<eyes:IndexMoviePic name="mediaPic">
												<div class="jMyCarousel" style="background-color: black;">
													<ul style="margin: 0px 0px; padding: 0px 0px;">
														<c:forEach items="${mediaPic}" var="mediaImage">
															<li
																style="margin: 0px 0px; padding: 0px 0px;">
																<a href="${root }/customer/MediaPlay.do?id=${mediaImage.media}"><img
																	src="${root }${mediaImage.url}" width="79" height="79"
																	style="margin: 3px 3px;"></a>
															
															</li>
														</c:forEach>
													</ul>
												</div>
											</eyes:IndexMoviePic>
										</div>
										<div class="navication" style="margin-left: 86px;">
											<img alt="" src="../images/EVENT.gif">
										</div>
										<div class="navication" style="margin-left: 60px;">
											<img alt="" src="../images/COORP.gif">
										</div>
										<div class="navication" style="margin-left: 66px;">
											<img alt="" src="../images/COMMONICATION.gif">
										</div>
										<div class="navication" style="margin-left: 72px;">
											<img alt="" src="../images/about_US.gif">
										</div>
									</div></td>
							</tr>
							<tr>
								<td height="131px">
									<div>
										<img alt="" src="../images/flash_inbodyright.gif" width="580">
									</div></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div class="bottom">
			<img alt="" src="../images/flash_bottom.gif">
		</div>
		<!--  <div style="float: right;z-index:100; position:absolute; right: 0px;">到访人数</div>
		<div>
			<img src="../images/title.gif" border="0" usemap="#planetmap"
				alt="Planets" />
			<map name="planetmap" id="planetmap">
				<area shape="rect" coords="688,51,893,94" href="sun.html" alt="Sun" />
			</map>
		</div>-->
	</div>
</body>
</html>