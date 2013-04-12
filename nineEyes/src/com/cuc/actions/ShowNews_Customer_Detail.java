package com.cuc.actions;

import com.cuc.services.NewsService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.News;

/**
 * 
 * @author StarLee
 *
 */
public class ShowNews_Customer_Detail implements Basic
{
	private String id;
	private News news;
	public News getNews()
	{
		return news;
	}
	@Override
	public String execute()
	{
		NewsService service=new NewsService();
		news=service.selectNewsByID(Integer.parseInt(id));
		
		return "ok";
	}
	public void setId(String id)
	{
		this.id = id;
	}
}
