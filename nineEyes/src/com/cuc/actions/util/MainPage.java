package com.cuc.actions.util;

import com.develop.actions.test.Basic;



/**
 * 对于后台模板都用这个进行页面选择
 * @author starlee
 */
public class MainPage implements Basic
{

	private String page;
	private String url;
	

	public String getUrl()
	{
		return url;
	}



	public String execute()
	{
		url=(String)PageMap.PAGES.get(page);
		//System.out.println("+++++++++++++======================="+url);
		return "page";
	}



	public void setPage(String page)
	{
		this.page = page;
	}

	

}
