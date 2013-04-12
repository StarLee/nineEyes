package com.cuc.actions;

import com.cuc.services.MediaCategoryService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.MediaCategory;

public class UpdateMediaCategory implements Basic
{
	private String id;
	public void setId(String id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	private String name;
	private String content;
	private String url;
	@Override
	public String execute()
	{
		MediaCategoryService service=new MediaCategoryService();
		MediaCategory category=new MediaCategory();
		category.setId(Integer.parseInt(id));
		category.setIntro(content);
		category.setName(name);
		service.updateMediaCategory(category);
		url="mediaCategory";
		return "ok";
	}
	public String getUrl()
	{
		return url;
	}

}
