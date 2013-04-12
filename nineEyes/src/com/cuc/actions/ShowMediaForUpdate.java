package com.cuc.actions;

import com.cuc.services.MediaService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Media;

public class ShowMediaForUpdate implements Basic
{
	public String id;
	public Media media;
	public String url;
	public String getUrl()
	{
		return url;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	@Override
	public String execute()
	{
		MediaService service=new MediaService();
		media=service.mediaPlay(Integer.parseInt(id));
		url="./showMediaUpdate.jsp";
		return "ok";
	}
	public Media getMedia()
	{
		return media;
	}
}
