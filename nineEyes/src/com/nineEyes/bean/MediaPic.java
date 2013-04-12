package com.nineEyes.bean;

import java.util.HashMap;
import java.util.Map;

public class MediaPic
{
	private int id;
	private String url;
	private int media;
	private Media mediaObject;
	private String type="0";
	private String belong="0";
	public String getBelong()
	{
		return belong;
	}
	public void setBelong(String belong)
	{
		this.belong = belong;
	}
	public static final Map TYPE=new HashMap();
	static
	{
		TYPE.put("0", "首页");
		TYPE.put("1", "播放页面");
		TYPE.put("2", "详细页面");
	}
	public String getTypeCN()
	{
		return (String)TYPE.get(type);
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public int getMedia()
	{
		return media;
	}
	public void setMedia(int media)
	{
		this.media = media;
	}
	public Media getMediaObject()
	{
		return mediaObject;
	}
	public void setMediaObject(Media mediaObject)
	{
		this.mediaObject = mediaObject;
	}
}
