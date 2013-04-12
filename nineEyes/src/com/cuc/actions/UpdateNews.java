package com.cuc.actions;



import com.cuc.services.NewsService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.News;

public class UpdateNews implements Basic
{
	public String getId()
	{
		return id;
	}
	private String content;
	private String category;
	private String title;
	private String sort;
	private String outline;
	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public void setOutline(String outline)
	{
		this.outline = outline;
	}
	private String url;
	private String id;
	public void setId(String id)
	{
		this.id = id;
	}

	public void setCategory(String category)
	{
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
		NewsService service=new NewsService();
		News news=service.selectNewsByID(Integer.parseInt(id));
		news.setContent(content);
		news.setTitle(title);
		news.setCategory(category);
		news.setSort(Integer.parseInt(sort));
		news.setOutline(outline);
		service.updateNews(news);
		url="NewsIndex";
		return "ok";
	}
	public String getUrl()
	{
		return url;
	}
}