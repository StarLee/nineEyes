package com.cuc.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.cuc.services.LinkNewsService;
import com.cuc.services.util.TimeTransform;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.LinkNews;
import com.nineEyes.bean.SessionBean;

public class SaveLinkNews implements Basic
{
	private String title;
	private String url;
	private String urlTarget="linkNews";
	public String getUrlTarget()
	{
		return urlTarget;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setUrl(String url)
	{
		String http=url.trim().substring(0, 4).toLowerCase();
		//System.out.println("---------------------"+http);
		if("http".equals(http))
			this.url = url;
		else
			this.url="http://"+url;
	}
	@Override
	public String execute()
	{
		HttpServletRequest context=(HttpServletRequest) ActionStatistics.getInstance().get(WebObject.SERVLETREQUEST);
		SessionBean admin=(SessionBean)context.getSession().getAttribute("user");
		LinkNewsService service=new LinkNewsService();
		LinkNews news=new LinkNews();
		news.setTitle(title);
		news.setUrl(url);
		news.setCreateTime(TimeTransform.transform(new Date(), TimeTransform.DEFAULT));
		news.setAuthor(admin.getUser().getName());
		service.saveNews(news);
		return "ok";
	}

}
