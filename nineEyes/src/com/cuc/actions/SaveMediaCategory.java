package com.cuc.actions;

import com.cuc.services.MediaCategoryService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.MediaCategory;

public class SaveMediaCategory implements Basic
{
	private String name;
	private String content;
	private String url;
	@Override
	public String execute()
	{
		MediaCategoryService service=new MediaCategoryService();
		MediaCategory mediaCategory=new MediaCategory();
		mediaCategory.setIntro(content);
		mediaCategory.setName(name);
		service.saveMediaCategory(mediaCategory);
		url="mediaCategory";
		return "ok";
	}
	public String getUrl()
	{
		return url;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
}
