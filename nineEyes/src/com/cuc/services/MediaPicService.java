package com.cuc.services;

import java.util.List;

import com.develop.data.base.iml.DefaultQuery;
import com.nineEyes.bean.MediaPic;
import com.nineEyes.dao.MediaPicDao;

public class MediaPicService
{
	DefaultQuery query = new DefaultQuery();
	public List<MediaPic> selectPicBelongMedia(int mediaID,String picType)
	{
		MediaPicDao dao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		MediaPic pic=new MediaPic();
		pic.setMedia(mediaID);
		pic.setType(picType);
		return dao.selectMediaPic(pic);
	}
	
	
	public List<MediaPic> selectAllPicBelongMedia(int mediaID)
	{
		MediaPicDao dao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		return dao.selectMediaAllPic(mediaID);
	}
	
	public List<MediaPic> selectAllPicBelongEvent(int mediaID)
	{
		MediaPicDao dao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		return dao.selectEventAllPic(mediaID);
	}
	
	public List<MediaPic> selectPicBelongEvent(int eventID,String picType)
	{
		MediaPicDao dao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		MediaPic pic=new MediaPic();
		pic.setMedia(eventID);
		pic.setType(picType);
		return dao.selectEventPic(pic);
	}
	public void deleteRecord(int id)
	{
		MediaPicDao mediaPicDao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		mediaPicDao.deleteRelation(id);
	}
	public void updateType(int id,String type)
	{
		MediaPicDao mediaPicDao=(MediaPicDao)query.getMapper(MediaPicDao.class);
		MediaPic mediaPic=mediaPicDao.selectMedia(id);
		mediaPic.setType(type);
		mediaPicDao.updateMedia(mediaPic);
	}
}
