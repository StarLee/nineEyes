package com.cuc.actions.util;

import java.util.HashMap;
import java.util.Map;
/**
 * ·����λ�������Manager�ļ��е�
 * @author starlee
 *
 */
public class PageMap
{
	public static Map PAGES=new HashMap();
	static 
	{
		PAGES.put("index", "./workloadLabs_.jsp");
		PAGES.put("bigIndex", "./bigIndex.jsp");
		PAGES.put("newsEdit", "./newsEdit.jsp");
		PAGES.put("newsIndex", "./newsIndex.jsp");
		PAGES.put("linkNews", "./linkNews.jsp");
		PAGES.put("mediaEdit", "./MediaEdit.jsp");
		PAGES.put("mediaCategory", "./mediaCategory.jsp");
		PAGES.put("eventEdit", "./EventEdit.jsp");
	}
}
