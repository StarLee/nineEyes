package com.cuc.actions;

import com.cuc.services.LinkNewsService;
import com.develop.actions.test.Basic;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.News;

public class LinkNewsIndex implements Basic
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
		LinkNewsService service = new LinkNewsService();
		if (pageNum == null)
			pageNum = "1";

		news = service.selectNews(Integer.parseInt(pageNum));
		url = "./linkNewsIndex.jsp";
		return "ok";
	}

	public PageResult<News> getNews()
	{
		return news;
	}

}
