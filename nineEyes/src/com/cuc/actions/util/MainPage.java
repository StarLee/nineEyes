package com.cuc.actions.util;

import com.develop.actions.test.Basic;



/**
 * ���ں�̨ģ�嶼���������ҳ��ѡ��
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
