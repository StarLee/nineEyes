package com.nineEyes.dao;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.LinkNews;

public interface LinkNewsDao
{
	@SQL(sql="insert into LinkNews(ID,AUTHOR,CREATETIME,URL,TITLE) values(0,'#{author}','#{createTime}','#{url}','#{title}')",sqlType=SQLTYPE.INSERT,paramType="com.nineEyes.bean.LinkNews")
	public void insert(LinkNews news);
	@SQL(sql ="select ID as id,AUTHOR as author,CREATETIME as createTime,URL as url,TITLE as title from LinkNews order by CREATETIME DESC",sqlType=SQLTYPE.SELECT,resultType="com.nineEyes.bean.LinkNews")
	public PageResult<LinkNews> selectAllNews();
}
