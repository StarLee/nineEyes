package com.nineEyes.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cuc.services.EventService;
import com.cuc.services.LinkNewsEventService;
import com.cuc.services.MediaPicService;

public class Event
{
	private int id;
	private String outline;
	private String intro;
	private String title;
	private String author;
	private String createtime;
	private String category;

	/**
	 * ����
	 * 
	 * @return
	 */
	public List<Media> getMedias()
	{
		EventService service = new EventService();
		return service.selectMedia(this.id);
	}
	/**
	 * ��������
	 * @return
	 */
	public List<LinkNewsEvent> getLinkNews()
	{
		LinkNewsEventService service=new LinkNewsEventService();
		return service.selectNews(this.id);
	}
	/**
	 * ͼƬ
	 * 
	 * @return
	 */
	public List<MediaPic> getIndexPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongEvent(this.id, "0");
	}

	public List<MediaPic> getPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectAllPicBelongEvent(this.id);
	}

	/**
	 * ͼƬ(����)
	 * 
	 * @return
	 */
	public List<MediaPic> getPlayPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongEvent(this.id, "1");
	}

	/**
	 * ͼƬ(��ϸҳ��)
	 * 
	 * @return
	 */
	public List<MediaPic> getDetailPictures()
	{
		MediaPicService service = new MediaPicService();
		return service.selectPicBelongEvent(this.id, "2");
	}

	public static final Map TYPE = new HashMap();
	static
	{
		TYPE.put("0", "�");
		TYPE.put("1", "����");
		TYPE.put("2", "����");
	}

	public String getCategoryCN()
	{
		return (String) TYPE.get(category);
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

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}
}
