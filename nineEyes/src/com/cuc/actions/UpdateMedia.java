package com.cuc.actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cuc.services.MediaService;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Media;
import com.nineEyes.bean.MediaPic;
import com.nineEyes.bean.SessionBean;

public class UpdateMedia implements Basic
{
	private String outline;
	private String intro;
	private String title;
	private String url;
	private String category;
	private String[] picURL;
	private String[] picType;
	private String id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setPicType(String[] picType)
	{
		this.picType = picType;
	}

	public void setOutline(String outline)
	{
		this.outline = outline;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public void setPicURL(String[] picURL)
	{
		this.picURL = picURL;
	}

	@Override
	public String execute()
	{
		MediaService service = new MediaService();
		Media media = service.mediaPlay(Integer.parseInt(id));
		media.setCategory(Integer.parseInt(category));
		media.setIntro(intro);
		media.setOutline(outline);
		media.setTitle(title);
		media.setUrl(url);
		List picList = new ArrayList();
		if (picURL != null)
			for (int n = 0; n < picURL.length; n++)
			{
				MediaPic pic = new MediaPic();
				pic.setUrl(picURL[n]);
				pic.setType(picType[n]);
				picList.add(pic);
			}

		service.updateMedia(media, picList);

		return "ok";
	}
}
