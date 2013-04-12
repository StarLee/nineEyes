package com.nineEyes.dao;

import java.util.List;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.nineEyes.bean.MediaCategory;

public interface MediaCategoryDao
{
	@SQL(sql="insert into MediaCategory(ID,NAME,INTRO) values(0,'#{name}','#{intro}')",sqlType=SQLTYPE.INSERT,paramType="com.nineEyes.bean.MediaCategory")
	public void insert(MediaCategory news);
	@SQL(sql ="select ID as id,NAME as name,INTRO as intro from MediaCategory order by ID DESC",sqlType=SQLTYPE.SELECT,resultType="com.nineEyes.bean.MediaCategory")
	public List<MediaCategory> selectAllMediaCategory();
	@SQL(sql ="select ID as id,NAME as name,INTRO as intro from MediaCategory where ID=#{id}",sqlType=SQLTYPE.SELECT,resultType="com.nineEyes.bean.MediaCategory")
	public MediaCategory selectMediaCategory(int id);
	@SQL(sql="update MediaCategory set NAME='#{name}',INTRO='#{intro}' where ID=#{id}",sqlType=SQLTYPE.UPDATE,paramType="com.nineEyes.bean.MediaCategory")
	public void updateMediaCategory(MediaCategory category);
}
