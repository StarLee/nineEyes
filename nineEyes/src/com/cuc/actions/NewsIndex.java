package com.cuc.actions;

import com.cuc.services.NewsService;
import com.develop.actions.test.Basic;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.News;

public class NewsIndex implements Basic
{

	private PageResult<News> news;
	private String url;
	private String pageNum;
	
	public void setPageNum(String pageNum)
	{
		this.pageNum = pageNum;
	}
	public String getUrl()
	{
		return url;
	}
	@Override
	public String execute()
	{
		NewsService service=new NewsService();
		if(pageNum==null)
			pageNum="1";
		news=service.selectNews(Integer.parseInt(pageNum));
		url="./newsIndex.jsp";
		return "ok";
	}
	public PageResult<News> getNews()
	{
		return news;
	}

}
