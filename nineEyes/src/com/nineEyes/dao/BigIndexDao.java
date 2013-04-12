package com.nineEyes.dao;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.nineEyes.bean.BigIndex;

public interface BigIndexDao
{
	@SQL(sql="insert into BigIndex(ID,NAME,STATE,CREATETIME,INTRO,URL) values(0,'#{name}','0','#{createTime}','#{intro}','#{url}')",sqlType=SQLTYPE.INSERT,paramType="com.nineEyes.bean.BigIndex")
	public void insert(BigIndex bigIndex);
	@SQL(sql="select ID as id,NAME as name,STATE as state,CREATETIME as createTime,INTRO as intro,URL as url from BigIndex where STATE='0'",sqlType=SQLTYPE.SELECT,resultType="com.nineEyes.bean.BigIndex")
	public BigIndex selectShow();
	@SQL(sql="update BigIndex set STATE='1' where ID=#{id}",sqlType=SQLTYPE.UPDATE)
	public void updataStateDisabled(int id);
	@SQL(sql="update BigIndex set STATE='0' where ID=#{id}",sqlType=SQLTYPE.UPDATE)
	public void updataStateAbled(int id);
}
