package com.nineEyes.dao;

import java.util.List;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.nineEyes.bean.EventToMedia;

public interface EventToMediaDao
{
	@SQL(sql = "insert into EventToMedia(MEDIA,EVENT) values(#{media},#{event})", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.EventToMedia")
	public void insert(EventToMedia eventToMedia);

	@SQL(sql = "select MEDIA as media,EVENT as event from EventToMedia where EVENT=#{event}", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.EventToMedia")
	public List selectByEventID(int event);

	@SQL(sql = "delete from EventToMedia where MEDIA=#{media} and EVENT=#{event}", sqlType = SQLTYPE.DELETE, paramType = "com.nineEyes.bean.EventToMedia")
	public void deleteRelation(EventToMedia eventToMedia);
}
