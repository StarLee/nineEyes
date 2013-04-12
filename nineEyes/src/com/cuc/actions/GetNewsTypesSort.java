package com.cuc.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cuc.services.util.NewsTypeUtil;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.JSONType;
import com.nineEyes.bean.NewsType;

public class GetNewsTypesSort implements Basic
{

	private String id;
	private JSONType jsonType;
	
	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String execute()
	{
		jsonType=new JSONType();
		Map<String,NewsType> types=NewsTypeUtil.getParentsSon(NewsTypeUtil.START).get(id).getNext();
		Iterator<NewsType> it= types.values().iterator();
		List list=new ArrayList();
		
		for(;it.hasNext();)
		{
			Map<String,String> map=new HashMap<String,String>();
			NewsType type=it.next();
			map.put("id",type.getId());
			map.put("name",type.getName());
			list.add(map);
		}
		jsonType.setListElements(list);
		return "ok";
	}

	public JSONType getJsonType()
	{
		return jsonType;
	}

}
