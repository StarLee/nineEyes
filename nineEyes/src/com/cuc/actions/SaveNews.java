package com.cuc.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.cuc.services.NewsService;
import com.cuc.services.util.TimeTransform;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.News;
import com.nineEyes.bean.SessionBean;

public class SaveNews implements Basic
{

	private String content;//要对html过滤(最好的办法是在bean中进行，遇到非法的字符进行转换)
	private String category="0";
	private String title;
	private String url;
	private String outline;//要对html过滤
	private String sort="0";
	public void setSort(String sort)
	{
		if(sort==null)
		{
			this.sort="0";
			return;
		}
		this.sort = sort;
	}

	public void setOutline(String outline)
	{
		this.outline = outline;
	}

	public void setCategory(String category)
	{
		if(category==null)
		{
			this.category="0";
			return;
		}
		this.category = category;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Override
	public String execute()
	{
		HttpServletRequest context=(HttpServletRequest) ActionStatistics.getInstance().get(WebObject.SERVLETREQUEST);
		SessionBean admin=(SessionBean)context.getSession().getAttribute("user");
		NewsService service=new NewsService();
		News news=new News();
		news.setContent(content);
		news.setTitle(title);
		news.setCategory(category);
		news.setOutline(outline);
		news.setSort(Integer.parseInt(sort));
		news.setCreateTime(TimeTransform.transform(new Date(), TimeTransform.DEFAULT));
		news.setAuthor(admin.getUser().getName());
		service.saveNews(news);
		url="NewsIndex";
		return "ok";
	}
	public String getUrl()
	{
		return url;
	}

}
