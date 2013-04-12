package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.util.NewsTypeUtil;

public class NewsTypes extends TagSupport
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
		pageContext.setAttribute(name, NewsTypeUtil.getParentsSon(NewsTypeUtil.START));
		return EVAL_BODY_INCLUDE;
	}
}
