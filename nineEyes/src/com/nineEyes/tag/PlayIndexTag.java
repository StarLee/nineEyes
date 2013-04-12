package com.nineEyes.tag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.MediaCategoryService;
import com.nineEyes.bean.MediaCategory;
import com.nineEyes.bean.show.PlayIndex;

public class PlayIndexTag extends TagSupport
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
		MediaCategoryService service=new  MediaCategoryService();
		List<MediaCategory> list=service.selectAll();
		Iterator<MediaCategory> it=list.iterator();
		List<PlayIndex> listPlay=new ArrayList();
		for(;it.hasNext();)
		{
			PlayIndex index=new PlayIndex(it.next());
			listPlay.add(index);
		}
		pageContext.setAttribute(name, listPlay);
		return EVAL_BODY_INCLUDE;
	}
}
