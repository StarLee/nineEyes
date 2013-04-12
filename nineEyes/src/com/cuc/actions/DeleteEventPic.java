package com.cuc.actions;

import com.cuc.services.EventService;
import com.develop.actions.test.Basic;

public class DeleteEventPic implements Basic
{
	private String picID;
	private String eventID;
	public String getEventID()
	{
		return eventID;
	}
	public void setEventID(String eventID)
	{
		this.eventID = eventID;
	}
	public void setPicID(String picID)
	{
		this.picID = picID;
	}
	@Override
	public String execute()
	{
		EventService service=new EventService();
		service.deletePicRelation(Integer.parseInt(picID));
		return "ok";
	}

}
