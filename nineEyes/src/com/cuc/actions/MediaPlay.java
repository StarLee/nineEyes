package com.cuc.actions;

import com.cuc.services.MediaService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Media;

public class MediaPlay implements Basic
{
	public String id;
	public Media media;

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String execute()
	{
		MediaService service = new MediaService();
		if (id != null)
			media = service.mediaPlay(Integer.parseInt(id));

		return "ok";
	}

	public Media getMedia()
	{
		return media;
	}

}
