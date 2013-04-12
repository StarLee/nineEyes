package com.nineEyes.bean;

import java.util.HashMap;
import java.util.Map;
/**
 * 因为新闻的类型在数据库中我并没有单独设计表但是在程序中，我组织了一个能够查询的数据结构(类似链表)
 * @author starlee
 *
 */
public class NewsType
{
	private String id;//唯一标识
	private String name;//名字
	private NewsType parent;//上一级的id,如果是第一级则为null
	private Map<String,NewsType> next=new HashMap<String, NewsType>();//下级类型的集合，如果是最后一级则为empty
	public NewsType(String id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	
	public NewsType getParent()
	{
		return parent;
	}


	public void setParent(NewsType parent)
	{
		this.parent = parent;
	}


	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Map<String, NewsType> getNext()
	{
		return next;
	}
	public void setNext(Map<String, NewsType> next)
	{
		this.next = next;
	}
	public void addSonNewsType(NewsType type)
	{
		next.put(type.getId(), type);
	}
	
}
