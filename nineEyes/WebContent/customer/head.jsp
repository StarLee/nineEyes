<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="title">
			<div class="logo"></div>
			<div class="eyes">
				<div class="navication">
					<ul
						style="list-style: none;height:25px; list-style-position: inside; margin: 0px 0px;"
						title="导航">
						<li style="height: 30px;"><a class="left_margin" href="${root}/customer/Index.do"><img src="${index}"></a></li>
						<li><a class="left_margin" href="${root}/customer/Service.do"><img alt=""
							src="${service}"></a></li>
						<li><a class="left_margin" href="${root}/customer/Service.do"> <img alt=""
							src="${resource}"></a></li>
						<li><a class="left_margin" href="${root}/customer/Service.do"><img alt=""
							src="${case}"></a></li>
						<li><a class="left_margin" href="${root}/customer/Service.do"><img alt=""
							src="${cooperative}"></a></li>
						<li><a class="left_margin" href="${root}/customer/Service.do"><img alt=""
							src="${scholar}"></a></li>
					</ul>
				</div>
			</div>
			<div class="contact">
				<div class="visitors">
					<div style="height: 29px;"></div>
					<table width="100%">
						<tr>
							<td width="145"></td>
							<td>${visitor }</td>
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