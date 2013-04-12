package com.cuc.actions;

import com.cuc.services.MediaService;
import com.develop.actions.test.Basic;

public class DeleteMediaPic implements Basic
{
	private String picID;
	private String mediaID;
	
	public String getMediaID()
	{
		return mediaID;
	}
	public void setMediaID(String mediaID)
	{
		this.mediaID = mediaID;
	}
	public void setPicID(String picID)
	{
		this.picID = picID;
	}
	@Override
	public String execute()
	{
		MediaService service=new MediaService();
		service.deletePicRelation(Integer.parseInt(picID));
		return "ok";
	}

}
