package com.nineEyes.bean;

import java.util.List;
import java.util.Map;
/**
 * BEAN="bean";
 * EXTRA="extra";
 * RESULTLIST="resultList";
 * ����beanҪС��
 * cuc.ajax.main.JSONType.java 
 *	@author starlee
 *
 * 2011-4-17
 */
public class JSONType
{
	private List listElements=null;//����
	private Map extraElements=null;//json����json
	private Object Bean=null;//bean����
	public List getListElements()
	{
		return listElements;
	}
	public void setListElements(List listElements)
	{
		this.listElements = listElements;
	}
	public Map getExtraElements()
	{
		return extraElements;
	}
	public void setExtraElements(Map extraElements)
	{
		this.extraElements = extraElements;
	}
	public Object getBean()
	{
		return Bean;
	}
	public void setBean(Object bean)
	{
		Bean = bean;
	}
}
