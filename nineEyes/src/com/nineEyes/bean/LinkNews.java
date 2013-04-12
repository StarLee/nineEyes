package com.nineEyes.bean;

public class LinkNews
{
	private int id;
	private String title;
	private String author;
	private String createTime;
	private String url;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	public String getUrl()
	{
		return url;
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
}
