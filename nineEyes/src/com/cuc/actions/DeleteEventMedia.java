package com.cuc.actions;

import com.cuc.services.EventService;
import com.develop.actions.test.Basic;

public class DeleteEventMedia implements Basic
{
	private String mediaID;
	public String getEventID()
	{
		return eventID;
	}

	public void setEventID(String eventID)
	{
		this.eventID = eventID;
	}

	public void setMediaID(String mediaID)
	{
		this.mediaID = mediaID;
	}

	private String eventID;

	@Override
	public String execute()
	{
		EventService service=new EventService();
		service.deleteMediaRelation(Integer.parseInt(eventID), Integer.parseInt(mediaID));
		return "ok";
	}

}
