package com.nineEyes.dao;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.Event;

public interface EventDao
{
	@SQL(sql = "insert into Event(ID,OUTLINE,INTRO,TITLE,AUTHOR,CREATETIME,CATEGORY) values(0,'#{outline}','#{intro}','#{title}','#{author}','#{createtime}','#{category}')", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.Event")
	public void insert(Event event);

	@SQL(sql = "select ID as id,OUTLINE as outline ,INTRO as intro,TITLE as title,AUTHOR as author,CREATETIME as createtime,CATEGORY as category from Event order by ID DESC", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.Event")
	public PageResult<Event> selectEvent();

	@SQL(sql = "select ID as id,OUTLINE as outline ,INTRO as intro,TITLE as title,AUTHOR as author,CREATETIME as createtime,CATEGORY as category from Event where ID='#{id}'", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.Event")
	public Event selectEventByID(int id);

	@SQL(sql = "update Event set OUTLINE='#{outline}',INTRO='#{intro}',TITLE='#{title}',CATEGORY='#{category}' where ID=#{id}", sqlType = SQLTYPE.UPDATE, paramType = "com.nineEyes.bean.Event")
	public void updateEvent(Event event);
}
