package com.cuc.services;

import com.develop.data.base.iml.DefaultQuery;
import com.develop.data.result.PageResult;
import com.develop.data.result.PageRow;
import com.nineEyes.bean.LinkNews;
import com.nineEyes.dao.LinkNewsDao;
import com.nineEyes.dao.NewsDao;

public class LinkNewsService
{
	DefaultQuery query = new DefaultQuery();
	public void saveNews(LinkNews news)
	{
		
		LinkNewsDao dao = (LinkNewsDao) query.getMapper(LinkNewsDao.class);
		dao.insert(news);
	}
	public PageResult selectNews(int page)
	{
		PageRow row=new PageRow(page, 3);
		LinkNewsDao dao =(LinkNewsDao)query.getMapper(LinkNewsDao.class, row);
		return dao.selectAllNews();
	}
}
