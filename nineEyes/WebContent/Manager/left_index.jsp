<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


	<table>
		<tr>
			<td width="5px;"></td>
			<td>
				<table>
					<tr>
						<td>
							<div>欢迎${sessionScope.user.user.name }</div>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MainPage.do?page=bigIndex">大首页内容设置</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MainPage.do?page=newsEdit">发布新的消息</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/NewsIndex.do">消息历史</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MainPage.do?page=linkNews">链接新闻</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/LinkNewsIndex.do">链接新闻历史</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MainPage.do?page=mediaEdit">链接视频</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MediaIndex.do">链接视频历史</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/MainPage.do?page=eventEdit">活动/交流</a>
						</td>
					</tr>
					<tr>
						<td><a href="${root }/EventIndex.do">活动/交流历史</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

