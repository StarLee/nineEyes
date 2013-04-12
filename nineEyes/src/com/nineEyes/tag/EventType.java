package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.nineEyes.bean.Event;

public class EventType extends TagSupport
{
	private String name;

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int doStartTag()
	{
		pageContext.setAttribute(name, Event.TYPE);
		return EVAL_BODY_INCLUDE;
	}
}
