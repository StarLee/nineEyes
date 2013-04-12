package com.nineEyes.bean;

import com.cuc.services.util.NewsTypeUtil;

public class News
{
	private int id;
	private String content;
	private String createTime;
	private String author;
	private String category="0";
	private String title;
	private int sort=0;
	private String priority="0";
	
	public NewsType getCategoryZh()
	{
		return NewsTypeUtil.getNewsType(category, String.valueOf(sort));
	}
	public String getPriority()
	{
		return priority;
	}
	public void setPriority(String priority)
	{
		this.priority = priority;
	}
	private String outline;
	public int getSort()
	{
		return sort;
	}
	public void setSort(int sort)
	{
		this.sort = sort;
	}
	public String getOutline()
	{
		return outline;
	}
	public void setOutline(String outline)
	{
		this.outline = outline;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
}
