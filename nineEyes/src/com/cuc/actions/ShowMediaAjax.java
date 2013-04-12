package com.cuc.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cuc.services.MediaService;
import com.develop.actions.test.Basic;
import com.develop.data.result.PageResult;
import com.nineEyes.bean.JSONType;
import com.nineEyes.bean.Media;

public class ShowMediaAjax implements Basic
{
	private String page="1";
	private JSONType json;
	
	public void setPage(String page)
	{
		this.page = page;
	}
	@Override
	public String execute()
	{
		MediaService service=new MediaService();
		if(page==null)
		{
			page="1";
		}
		
		PageResult<Media> media=service.showMedia(Integer.parseInt(page));
		List list=new ArrayList();
		Iterator<Media> it=media.iterator();
		for(;it.hasNext();)
		{
			list.add(it.next());
		}
		json=new JSONType();
		json.setListElements(list);
		Map map=new HashMap();
		map.put("currentPage", media.getCurrent());
		map.put("pageSize", media.getPageSize());
		map.put("pageCount", media.getPages());
		map.put("recordsCount", media.getRows());
		json.setExtraElements(map);
		return "ok";
	}
	public JSONType getJson()
	{
		return json;
	}
}
