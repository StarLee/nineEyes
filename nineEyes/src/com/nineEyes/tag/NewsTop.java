package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.NewsService;

public class NewsTop extends TagSupport
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
		NewsService service = new NewsService();
		pageContext.setAttribute(name, service.selectTop());
		return EVAL_BODY_INCLUDE;
	}
}
