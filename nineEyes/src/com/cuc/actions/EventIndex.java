package com.cuc.actions;

import com.cuc.services.EventService;
import com.develop.actions.test.Basic;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.Event;

public class EventIndex implements Basic
{
	private String page="1";
	private PageResult<Event> event;
	private String url;
	public String getUrl()
	{
		return url;
	}
	
	public void setPage(String page)
	{
		this.page = page;
	}
	@Override
	public String execute()
	{
		EventService service=new EventService();
		if(page==null)
		{
			page="1";
		}
		event=service.showEvent(Integer.parseInt(page));
		url="./eventIndex.jsp";
		return "ok";
	}

	public PageResult<Event> getEvent()
	{
		return event;
	}
}
