package com.nineEyes.dao;

import java.util.List;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.MediaPic;

public interface MediaPicDao
{
	@SQL(sql = "insert into MediaPic(ID,URL,MEDIA,TYPE,BELONG) values(0,'#{url}',#{media},'#{type}','#{belong}')", sqlType = SQLTYPE.INSERT, paramType = "com.nineEyes.bean.MediaPic")
	public void insert(MediaPic mediaPic);

	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where MEDIA=#{media} and BELONG='0' and TYPE='#{type}' order by ID DESC ", paramType = "com.nineEyes.bean.MediaPic", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public List<MediaPic> selectMediaPic(MediaPic mediaPic);

	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where MEDIA=#{media} and BELONG='0' order by ID DESC ", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public List<MediaPic> selectMediaAllPic(int id);

	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where MEDIA=#{media} and BELONG='1' order by ID DESC ", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public List<MediaPic> selectEventAllPic(int id);

	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where MEDIA=#{media} and BELONG='1' and TYPE='#{type}' order by ID DESC ", paramType = "com.nineEyes.bean.MediaPic", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public List<MediaPic> selectEventPic(MediaPic mediaPic);

	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where TYPE='0' and BELONG='0' order by ID DESC ", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public PageResult<MediaPic> selectTop();

	
	@SQL(sql = "select ID as id,URL as url,MEDIA as media,TYPE as type,BELONG as belong from MediaPic where  ID =#{id} ", sqlType = SQLTYPE.SELECT, resultType = "com.nineEyes.bean.MediaPic")
	public MediaPic selectMedia(int id);
	
	@SQL(sql = "delete from MediaPic where ID=#{id}", sqlType = SQLTYPE.DELETE)
	public void deleteRelation(int id);

	@SQL(sql = "update MediaPic set TYPE='#{type}' where ID=#{id}", sqlType = SQLTYPE.UPDATE, paramType = "com.nineEyes.bean.MediaPic")
	public void updateMedia(MediaPic mediaPic);
}
