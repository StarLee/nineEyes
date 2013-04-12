package com.nineEyes.dao;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.News;

public interface NewsDao
{
	@SQL(sql = "insert into News(ID,AUTHOR,CREATETIME,CONTENT,CATEGORY,TITLE,SORT,OUTLINE,PRIORITY) values(0,'#{author}','#{createTime}','#{content}','#{category}','#{title}',#{sort},'#{outline}','#{priority}')", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.News")
	public void insert(News news);

	@SQL(sql = "select ID as id,AUTHOR as author,CREATETIME as createTime,CONTENT as content,CATEGORY as category,TITLE as title,SORT as sort,OUTLINE as outline,PRIORITY as priority from News order by CREATETIME DESC", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.News")
	public PageResult<News> selectAllNews();

	@SQL(sql = "select ID as id,AUTHOR as author,CREATETIME as createTime,CONTENT as content,CATEGORY as category,TITLE as title,SORT as sort,OUTLINE as outline,PRIORITY as priority from News where SORT=#{sort} and CATEGORY='#{category}'", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.News",paramType = "com.nineEyes.bean.News")
	public News selectNewsByCategory(News news);;

	@SQL(sql = "select ID as id,AUTHOR as author,CREATETIME as createTime,CONTENT as content,CATEGORY as category,TITLE as title,SORT as sort,OUTLINE as outline,PRIORITY as priority from News where ID=#{id}", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.News")
	public News selectNewsByID(int newsID);

	@SQL(sql = "update News set CONTENT='#{content}',CATEGORY='#{category}',TITLE='#{title}',SORT=#{sort},OUTLINE='#{outline}',PRIORITY='#{priority}'  where ID=#{id}", sqlType = SQLTYPE.UPDATE, paramType = "com.nineEyes.bean.News")
	public void updateNews(News news);
}
