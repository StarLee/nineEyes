package com.nineEyes.tag;

import javax.servlet.jsp.tagext.TagSupport;

import com.cuc.services.BigIndexService;
/**
 * 获取大首页的内容
 * @author starlee
 *
 */
public class BigIndex extends TagSupport
{ 
	public String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int doStartTag()
	{
		BigIndexService service=new BigIndexService();
		pageContext.setAttribute(name,service.selectShow().getUrl() );
		return EVAL_BODY_INCLUDE;
	}
}
