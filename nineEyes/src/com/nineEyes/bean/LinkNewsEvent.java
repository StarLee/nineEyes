package com.nineEyes.bean;

import com.cuc.services.EventService;

public class LinkNewsEvent
{
	private int id;
	private String title;
	private String url;
	private int event;
	private Event eventObject;
	public Event getEventObject()
	{
		return eventObject;
	}
	public void setEventObject(Event eventObject)
	{
		this.eventObject = eventObject;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		String http=url.trim().substring(0, 4).toLowerCase();
		if("http".equals(http))
			this.url = url;
		else
			this.url="http://"+url;
	}
	public int getEvent()
	{
		return this.event;
	}
	public void setEvent(int event)
	{
		/*if(eventObject==null)
		{
			EventService service=new  EventService();
			eventObject=service.selectByID(this.event);
		}*/
		this.event = event;
	}
}
