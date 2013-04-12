package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.BigIndexService;
import com.cuc.services.MediaCategoryService;

public class MediaCategoryAll extends TagSupport
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
		MediaCategoryService service=new MediaCategoryService();
		pageContext.setAttribute(name,service.selectAll() );
		return EVAL_BODY_INCLUDE;
	}
}
