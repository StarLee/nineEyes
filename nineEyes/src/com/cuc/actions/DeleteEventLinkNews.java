package com.cuc.actions;

import com.cuc.services.EventService;
import com.develop.actions.test.Basic;

public class DeleteEventLinkNews implements Basic
{
	private String linkID;
	public String getEventID()
	{
		return eventID;
	}

	public void setEventID(String eventID)
	{
		this.eventID = eventID;
	}

	public void setLinkID(String linkID)
	{
		this.linkID = linkID;
	}

	private String eventID;

	@Override
	public String execute()
	{
		EventService service=new EventService();
		service.deleteLinkNews(Integer.parseInt(linkID));
		return "ok";
	}

}

