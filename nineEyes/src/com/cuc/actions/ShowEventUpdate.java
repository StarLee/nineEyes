package com.cuc.actions;

import com.cuc.services.EventService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Event;

public class ShowEventUpdate implements Basic
{
	private String id;
	private String url;
	private Event event;

	@Override
	public String execute()
	{
		EventService service = new EventService();
		event = service.selectByID(Integer.parseInt(id));
		url = "./EventEditUpdate.jsp";
		return "ok";
	}

	public Event getEvent()
	{
		return event;
	}

	public String getUrl()
	{
		return url;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
