package com.cuc.services;

import java.util.Iterator;
import java.util.List;

import com.develop.data.base.iml.DefaultQuery;
import com.nineEyes.bean.LinkNewsEvent;
import com.nineEyes.dao.LinkNewsEventDao;

public class LinkNewsEventService
{
	DefaultQuery query = new DefaultQuery();
	public void saveNews(LinkNewsEvent news)
	{
		
		LinkNewsEventDao dao = (LinkNewsEventDao) query.getMapper(LinkNewsEventDao.class);
		dao.insert(news);
	}
	
	public List<LinkNewsEvent> selectNews(int eventID)
	{
		LinkNewsEventDao dao = (LinkNewsEventDao) query.getMapper(LinkNewsEventDao.class);
		return dao.selectAllEventNews(eventID);
	}
	
	public void deleteByID(int linkNewsEventID)
	{
		LinkNewsEventDao dao = (LinkNewsEventDao) query.getMapper(LinkNewsEventDao.class);
		dao.deleteLinkEventNews(linkNewsEventID);
	}
	
	public static void main(String[] args)
	{
		LinkNewsEventService service=new LinkNewsEventService();
		Iterator<LinkNewsEvent> it=service.selectNews(8).iterator();
		for(;it.hasNext();)
			System.out.println(it.next().getTitle());
	}
}
