package com.cuc.services.util;

import java.util.HashMap;
import java.util.Map;

import com.nineEyes.bean.NewsType;

/**
 * 对NewsType的一些基本操作，如初始化，添加类型(手动分配ID)，删除类型，修改类型，查找
 * 
 * @author starlee
 * 
 */
public class NewsTypeUtil
{
	private static NewsType start = new NewsType("-1", "null");
	public final static String START = "-1";// 头部，header
	public final static String LOG="0";
	public final static String[] BASICLOG={LOG,"0"};
	public final static String SERVICE="1";
	public final static String[] SERVICE_BrandMarket={SERVICE,"0"};
	public final static String[] SERVICE_EventMarket={SERVICE,"1"};
	public final static String[] SERVICE_MediaCreate={SERVICE,"2"};
	public final static String[] SERVICE_Govern={SERVICE,"3"};
	public final static String[] SERVICE_Artist={SERVICE,"4"};
	
	static
	{
		logType();
		serviceType();
		dataType();
	}

	private static void logType()
	{
		NewsType logType = new NewsType("0", "日志类");
		NewsType logTypeSon = new NewsType("0", "基本日志");
		logTypeSon.setParent(logType);
		logType.addSonNewsType(logTypeSon);
		start.addSonNewsType(logType);
	}

	private static void serviceType()
	{
		NewsType type = new NewsType("1", "服务类");
		NewsType typeSon1 = new NewsType("0", "品牌营销");
		NewsType typeSon2 = new NewsType("1", "事件营销");
		NewsType typeSon3 = new NewsType("2", "影视创作");
		NewsType typeSon4 = new NewsType("3", "政府公关");
		NewsType typeSon5 = new NewsType("4", "艺人合作");
		typeSon1.setParent(type);
		typeSon2.setParent(type);
		typeSon3.setParent(type);
		typeSon4.setParent(type);
		typeSon5.setParent(type);
		type.addSonNewsType(typeSon1);
		type.addSonNewsType(typeSon2);
		type.addSonNewsType(typeSon3);
		type.addSonNewsType(typeSon4);
		type.addSonNewsType(typeSon5);
		start.addSonNewsType(type);
	}

	private static void dataType()
	{
		NewsType type = new NewsType("2", "数据监测");
		NewsType typeSon1 = new NewsType("0", "数据");
		typeSon1.setParent(type);
		type.addSonNewsType(typeSon1);
		start.addSonNewsType(type);
	}
	/**
	 * 参数是那些静态成员
	 * @param type
	 * @return
	 */
	public static NewsType getNewsType(String[] type)
	{
		return getNewsType(type[0], type[1]);
	}
	
	public static NewsType getNewsType(String parentID, String myID)
	{
		return getParentsSon(parentID).get(myID);
	}

	public static Map<String, NewsType> getParentsSon(String id)
	{
		if (START.equals(id))
			return start.getNext();
		else
		{
			NewsType type = (NewsType) start.getNext().get(id);
			if (type != null)
				return type.getNext();
			else
				throw new RuntimeException("父类型不存在");
		}
	}

	public static void main(String[] args)
	{
		NewsType type = NewsTypeUtil.getNewsType("1", "1");
		System.out.println(type.getName());
		System.out.println(type.getParent().getName());
	}
}
