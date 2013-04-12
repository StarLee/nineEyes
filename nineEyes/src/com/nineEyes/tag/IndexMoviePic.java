package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.MediaService;

public class IndexMoviePic extends TagSupport
{
	public String name;

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
		MediaService service = new MediaService();
		pageContext.setAttribute(name, service.getSlide());
		return EVAL_BODY_INCLUDE;
	}
}
