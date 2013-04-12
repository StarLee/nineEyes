package com.cuc.actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cuc.services.EventService;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Event;
import com.nineEyes.bean.EventToMedia;
import com.nineEyes.bean.LinkNewsEvent;
import com.nineEyes.bean.MediaPic;
import com.nineEyes.bean.SessionBean;

public class SaveEvent implements Basic
{
	private String outline;
	private String intro;
	private String title;
	private String category;
	private String[] picURL;
	private String[] picType;
	private String[] relativeMedia;
	private String[] linkNewsNames;
	private String[] linkNewsURL;
	public void setLinkNewsNames(String[] linkNewsNames)
	{
		this.linkNewsNames = linkNewsNames;
	}

	public void setLinkNewsURL(String[] linkNewsURL)
	{
		this.linkNewsURL = linkNewsURL;
	}

	public void setRelativeMedia(String[] relativeMedia)
	{
		this.relativeMedia = relativeMedia;
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
		HttpServletRequest context = (HttpServletRequest) ActionStatistics
				.getInstance().get(WebObject.SERVLETREQUEST);
		SessionBean admin = (SessionBean) context.getSession().getAttribute(
				"user");
		Event media = new Event();
		media.setAuthor(admin.getUser().getName());
		media.setCategory(category);
		media.setIntro(intro);
		media.setOutline(outline);
		media.setTitle(title);
		List picList = new ArrayList();
		if (picURL != null)
			for (int n = 0; n < picURL.length; n++)
			{
				MediaPic pic = new MediaPic();
				pic.setUrl(picURL[n]);
				pic.setType(picType[n]);
				picList.add(pic);
			}
		List mediaList = new ArrayList();
		if (relativeMedia != null)
			for (int n = 0; n < relativeMedia.length; n++)
			{
				EventToMedia eventToMedia = new EventToMedia();
				eventToMedia.setMedia(Integer.parseInt(relativeMedia[n]));
				mediaList.add(eventToMedia);
			}
		List newsList=new ArrayList();
		if (linkNewsURL != null)
			for (int n = 0; n < linkNewsURL.length; n++)
			{
				LinkNewsEvent linkNews = new LinkNewsEvent();
				linkNews.setTitle(linkNewsNames[n]);
				linkNews.setUrl(linkNewsURL[n]);
				newsList.add(linkNews);
			}

		
		EventService service = new EventService();
		try
		{
			service.saveEvent(media, picList, mediaList,newsList);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
}
