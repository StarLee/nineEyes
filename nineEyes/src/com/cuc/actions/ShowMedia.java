package com.cuc.actions;

import com.cuc.services.MediaService;
import com.develop.actions.test.Basic;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.Media;

public class ShowMedia implements Basic
{
	private String page="1";
	private PageResult<Media> media;
	private String url;
	public String getUrl()
	{
		return url;
	}
	public PageResult<Media> getMedia()
	{
		return media;
	}
	public void setPage(String page)
	{
		this.page = page;
	}
	@Override
	public String execute()
	{
		MediaService service=new MediaService();
		if(page==null)
		{
			page="1";
		}
		media=service.showMedia(Integer.parseInt(page));
		url="./mediaIndex.jsp";
		return "ok";
	}
}
