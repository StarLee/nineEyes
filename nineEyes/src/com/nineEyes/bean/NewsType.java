package com.nineEyes.bean;

import java.util.HashMap;
import java.util.Map;
/**
 * ��Ϊ���ŵ����������ݿ����Ҳ�û�е�����Ʊ����ڳ����У�����֯��һ���ܹ���ѯ�����ݽṹ(��������)
 * @author starlee
 *
 */
public class NewsType
{
	private String id;//Ψһ��ʶ
	private String name;//����
	private NewsType parent;//��һ����id,����ǵ�һ����Ϊnull
	private Map<String,NewsType> next=new HashMap<String, NewsType>();//�¼����͵ļ��ϣ���������һ����Ϊempty
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
