package com.nineEyes.bean;

import java.util.List;

import com.cuc.services.MediaCategoryService;
import com.cuc.services.MediaPicService;

public class Media
{
	private int id;
	private String outline;
	private String intro;
	private String title;
	private String url;
	private String author;
	private String createtime;
	private int category;

	/**
	 * Õº∆¨
	 * 
	 * @return
	 */
	public List<MediaPic> getIndexPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongMedia(this.id, "0");
	}

	public List<MediaPic> getPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectAllPicBelongMedia(this.id);
	}
	
	/**
	 * Õº∆¨(≤•∑≈)
	 * 
	 * @return
	 */
	public List<MediaPic> getPlayPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongMedia(this.id, "1");
	}

	/**
	 * Õº∆¨(œÍœ∏“≥√Ê)
	 * 
	 * @return
	 */
	public List<MediaPic> getDetailPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongMedia(this.id, "2");
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getOutline()
	{
		return outline;
	}

	public void setOutline(String outline)
	{
		this.outline = outline;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public int getCategory()
	{
		return category;
	}

	public void setCategory(int category)
	{
		this.category = category;
	}

	/**
	 *  ”∆µ∑÷¿‡
	 * 
	 * @return
	 */
	public MediaCategory getCategoryObject()
	{
		MediaCategoryService service = new MediaCategoryService();
		return service.selectByID(this.category);
	}

}
