package com.cuc.actions;

import java.util.HashMap;
import java.util.Map;

import com.cuc.services.NewsService;
import com.cuc.services.util.NewsTypeUtil;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.JSONType;
import com.nineEyes.bean.News;

/**
 * 主要是服务主页上的东西
 * 
 * @author starlee
 * 
 */
public class LoadOutline implements Basic
{
	private String type;
	private JSONType jsonType;

	public JSONType getJsonType()
	{
		return jsonType;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public String execute()
	{
		int typel = Integer.parseInt(type);
		jsonType = new JSONType();
		Map map = new HashMap();
		NewsService service = new NewsService();
		News news = null;
		switch (typel)
		{
		case 0:
			news = service
					.selectNewsByCategory(NewsTypeUtil.SERVICE_BrandMarket);

			break;
		case 1:
			news = service
					.selectNewsByCategory(NewsTypeUtil.SERVICE_EventMarket);
			break;
		case 2:
			news = service
					.selectNewsByCategory(NewsTypeUtil.SERVICE_MediaCreate);
			break;
		case 3:
			news = service.selectNewsByCategory(NewsTypeUtil.SERVICE_Govern);
			break;
		case 4:
			news = service.selectNewsByCategory(NewsTypeUtil.SERVICE_Artist);
			break;
		default:
			break;
		}
		String content = "未添加的类型";
		if (news != null)
			content = news.getOutline();
		map.put("content", content);
		jsonType.setExtraElements(map);
		return "ok";
	}

}
