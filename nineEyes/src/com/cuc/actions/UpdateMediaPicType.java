package com.cuc.actions;

import java.util.HashMap;
import java.util.Map;

import com.cuc.services.MediaPicService;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.JSONType;
import com.nineEyes.bean.MediaPic;

public class UpdateMediaPicType implements Basic
{
	@Override
	public String execute()
	{
		MediaPicService service=new MediaPicService();
		service.updateType(Integer.parseInt(id), type);
		Map map=new HashMap();
		map.put("type", MediaPic.TYPE.get(type));
		map.put("id", id);
		result.setExtraElements(map);
		return "ok";
	}


	
	public void setType(String type)
	{
		this.type = type;
	}
	private JSONType result=new JSONType();
	public JSONType getResult()
	{
		return result;
	}
	private String id;
	private String type;

	public void setId(String id)
	{
		this.id = id;
	}
	
}
