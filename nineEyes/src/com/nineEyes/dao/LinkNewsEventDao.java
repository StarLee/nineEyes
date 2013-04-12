package com.nineEyes.dao;

import java.util.List;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.nineEyes.bean.LinkNewsEvent;

public interface LinkNewsEventDao
{
	@SQL(sql = "insert into LinkNewsEvent(ID,URL,TITLE,EVENT) values(0,'#{url}','#{title}',#{event})", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.LinkNewsEvent")
	public void insert(LinkNewsEvent news);

	@SQL(sql = "select ID as id,URL as url,TITLE as title,EVENT as event from LinkNewsEvent where EVENT=#{id}",sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.LinkNewsEvent")
	public List<LinkNewsEvent> selectAllEventNews(int id);

	@SQL(sql = "delete from LinkNewsEvent where ID=#{id}", sqlType = SQLTYPE.DELETE)
	public void deleteLinkEventNews(int linkID);
}
