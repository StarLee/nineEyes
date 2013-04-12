package com.cuc.services.util;

import java.util.HashMap;
import java.util.Map;

import com.nineEyes.bean.NewsType;

/**
 * ��NewsType��һЩ�������������ʼ�����������(�ֶ�����ID)��ɾ�����ͣ��޸����ͣ�����
 * 
 * @author starlee
 * 
 */
public class NewsTypeUtil
{
	private static NewsType start = new NewsType("-1", "null");
	public final static String START = "-1";// ͷ����header
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
		NewsType logType = new NewsType("0", "��־��");
		NewsType logTypeSon = new NewsType("0", "������־");
		logTypeSon.setParent(logType);
		logType.addSonNewsType(logTypeSon);
		start.addSonNewsType(logType);
	}

	private static void serviceType()
	{
		NewsType type = new NewsType("1", "������");
		NewsType typeSon1 = new NewsType("0", "Ʒ��Ӫ��");
		NewsType typeSon2 = new NewsType("1", "�¼�Ӫ��");
		NewsType typeSon3 = new NewsType("2", "Ӱ�Ӵ���");
		NewsType typeSon4 = new NewsType("3", "��������");
		NewsType typeSon5 = new NewsType("4", "���˺���");
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
		NewsType type = new NewsType("2", "���ݼ��");
		NewsType typeSon1 = new NewsType("0", "����");
		typeSon1.setParent(type);
		type.addSonNewsType(typeSon1);
		start.addSonNewsType(type);
	}
	/**
	 * ��������Щ��̬��Ա
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
				throw new RuntimeException("�����Ͳ�����");
		}
	}

	public static void main(String[] args)
	{
		NewsType type = NewsTypeUtil.getNewsType("1", "1");
		System.out.println(type.getName());
		System.out.println(type.getParent().getName());
	}
}
