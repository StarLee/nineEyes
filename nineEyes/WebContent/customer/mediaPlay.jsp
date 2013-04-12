<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="eyes" uri="/eyes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="expires" content="0">
<title>视频播放:${media.title }</title>
<script src="${root }/script/jquery.min.js" type="text/javascript"></script>
<style type="text/css">
html body {
	margin: 0px;
	padding: 0px;
}

.title {
	height: 190px;
	background-image: url("${root}/images/Video_background.gif");
	background-repeat: repeat-x;
	width: 960px;
}

.video_logo {
	height: 136px;
	background-image: url("${root}/images/Video_logo_abc.gif");
	background-repeat: no-repeat;
	width: 329px;
	position: relative;
	float: left;
	top: 26px;
	left: 20px;
}

.title_middle {
	height: 190px;
	width: 328px;
	position: relative;
	float: left;
}

.logo {
	height: 49px;
	width: 212px;
	background-image: url("${root}/images/logo.gif");
	position: relative;
	top: 29px;
	left: 40px;
}

.contact {
	height: 113px;
	width: 250px;
	/*background-image: url("${root}/images/contact_us.gif");*/
	position: relative;
	top: 51px;
	left: 70px;
	float: left;
}

.navication {
	position: relative;
	top: 115px;
	width: 295px;
	left: -8px;
}

.navication li {
	display: inline;
	margin: 0px 7px;
}

.media {
	width: 960px;
	height: 444px;
	background-color: black;
}

.media_container {
	width: 750px;
	height: 425px;
	margin: auto;
	background-color: gray;
	position: relative;
	top: 10px;
	bottom: 10px;
}
img
{
	border: 0px;
}
</style>
</head>
<body style="background-color: #bfbfbf;">
	<div style="width: 960px; margin: auto; background-color: #dfdfdf;">
		<div class="title">
			<div class="video_logo"></div>
			<div class="title_middle">
				<div class="logo"></div>
				<div class="navication">
					<ul
						style="list-style: none; list-style-position: inside; margin: 0px 0px;"
						title="导航">
						<li><span class="left_margin"></span> <a
							href="${root }/customer/Index.do"><img alt=""
								src="${root}/images/Video_index.gif"></a>
						</li>
						<li><span class="left_margin"></span> <img alt=""
							src="${root}/images/Video_compsition.gif">
						</li>
						<li><span class="left_margin"></span> <img alt=""
							src="${root}/images/Video_activity.gif">
						</li>
						<li><span class="left_margin"></span> <img alt=""
							src="${root}/images/Video_coor.gif">
						</li>
						<li><span class="left_margin"></span> <img alt=""
							src="${root}/images/Video_community.gif">
						</li>
					</ul>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="contact">
				<div class="contact1">
					<img src="${root}/images/contact_us.gif" border="0"
						usemap="#planetmap" alt="Planets" />
					<map name="planetmap" id="planetmap">
						<area shape="rect" coords="0,0,205,43" href="sun.html" alt="Sun" />
					</map>
				</div>
			</div>
		</div>
		<div class="media">
			<div class="media_container">
				<a href="/nineEyes/Manager/logon.html"> <object
						classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
						width="750" height="425" title="banner">
						<param name="movie" value="${media.url }" />
						<param value="transparent" name="wmode">
						<param name="quality" value="high" />
						<embed src="${media.url }" quality="high"
							pluginspage="http://www.macromedia.com/go/getflashplayer"
							type="application/x-shockwave-flash" width="750" height="425"></embed>
					</object> </a>
			</div>
		</div>

		<div class="middle">
			<eyes:PlayIndexTag name="mediaIndex">

				<c:forEach var="mediaOther" items="${mediaIndex }" varStatus="out">
					<div
						style="margin: 10px 32px;height:1px;width:630px; background-image: url('${root}/images/Video_seper_1.gif');"></div>
					<div>
						<div style="float: left; position: relative; width: 330px;">
							<div
								style="margin-left: 50px; font-family: cursive; font-weight: bold;">${mediaOther.mediaCategory.name
								}</div>
							<div
								style="width:206px;height:4px;margin:5px 32px; background-image: url('${root}/images/Video_seper_3.gif');"></div>
							<div style="margin: 5px 32px; width: 231px; height: 200px;">${mediaOther.firstMedia.outline}</div>
						</div>
						<div style="float: left; margin-top: 25px;" id="abc${out.count}">
							<c:forEach var="mediaPictures"
								items="${mediaOther.firstMedia.indexPictures }"
								varStatus="inner">
								<c:if test="${inner.count eq 1 }">
									<img src="${root }${mediaPictures.url }" height="206"
										width="330"></img>
								</c:if>
							</c:forEach>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div>
						<div style="margin-left: 50px; background-color: #c9c9c9;width: 830px;vertical-align: middle;">
							<c:forEach var="topMediaPicture" items="${mediaOther.topMedia}">
								<c:forEach var="top" items="${topMediaPicture.indexPictures }"
									varStatus="inner">
									<c:if test="${inner.count eq 1 }">
										<a href="${root }/customer/MediaPlay.do?id=${top.media}"><img
											src="${root }${top.url }" height="123" width="200" style="margin: 5px 5px;"></img></a>
									</c:if>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</eyes:PlayIndexTag>
		</div>
	</div>
</body>
</html>