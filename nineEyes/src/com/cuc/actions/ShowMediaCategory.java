package com.cuc.actions;

import com.cuc.services.MediaCategoryService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.MediaCategory;

public class ShowMediaCategory implements Basic
{
	private String id;
	private MediaCategory category;
	private String url;
	public MediaCategory getCategory()
	{
		return category;
	}
	@Override
	public String execute()
	{
		MediaCategoryService service=new MediaCategoryService();
		category=service.selectByID(Integer.parseInt(id));
		url="./showMediaCategory.jsp";
		return "ok";
	}
	public String getUrl()
	{
		return url;
	}
	public void setId(String id)
	{
		this.id = id;
	}

}
