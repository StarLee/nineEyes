package com.cuc.actions;

import com.cuc.services.NewsService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.News;

public class ShowNews implements Basic
{
	private String id;
	private News news;
	private String url;
	public News getNews()
	{
		return news;
	}
	@Override
	public String execute()
	{
		NewsService service=new NewsService();
		news=service.selectNewsByID(Integer.parseInt(id));
		url="./showNews.jsp";
		return "ok";
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getUrl()
	{
		return url;
	}

}
