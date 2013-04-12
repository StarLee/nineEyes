package com.nineEyes.dao;

import java.util.List;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.Event;
import com.nineEyes.bean.Media;
import com.nineEyes.bean.MediaCategory;
import com.nineEyes.bean.MediaPic;

public interface MediaDao
{
	@SQL(sql = "insert into Media(ID,URL,OUTLINE,INTRO,TITLE,AUTHOR,CREATETIME,CATEGORY) values(0,'#{url}','#{outline}','#{intro}','#{title}','#{author}','#{createtime}',#{category})", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.Media")
	public void insert(Media media);

	@SQL(sql = "select ID as id,URL as url,OUTLINE as outline ,INTRO as intro,TITLE as title,AUTHOR as author,CREATETIME as createtime,CATEGORY as category from Media order by ID DESC", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.Media")
	public PageResult<Media> selectMedia();

	@SQL(sql = "select ID as id,URL as url,OUTLINE as outline ,INTRO as intro,TITLE as title,AUTHOR as author,CREATETIME as createtime,CATEGORY as category from Media where CATEGORY=#{id} order by ID DESC", sqlType = SQLTYPE.SELECT, paramType = "com.nineEyes.bean.MediaCategory", resultType = "com.nineEyes.bean.Media")
	public PageResult<Media> selectMediaByCategory(MediaCategory category);

	@SQL(sql = "select ID as id,URL as url,OUTLINE as outline ,INTRO as intro,TITLE as title,AUTHOR as author,CREATETIME as createtime,CATEGORY as category from Media where ID=#{id}", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.Media")
	public Media selectMediaPlay(int id);

	@SQL(sql = "update Media set OUTLINE='#{outline}',URL='#{url}',INTRO='#{intro}',TITLE='#{title}',CATEGORY='#{category}' where ID=#{id}", sqlType = SQLTYPE.UPDATE, paramType = "com.nineEyes.bean.Media")
	public void updateMedia(Media media);
}
