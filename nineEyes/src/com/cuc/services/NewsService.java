package com.cuc.services;

import com.develop.data.base.iml.DefaultQuery;
import com.develop.data.result.PageResult;
import com.develop.data.result.PageRow;
import com.nineEyes.bean.News;
import com.nineEyes.dao.NewsDao;

public class NewsService
{
	DefaultQuery query = new DefaultQuery();
	public void saveNews(News news)
	{
		
		NewsDao dao = (NewsDao) query.getMapper(NewsDao.class);
		dao.insert(news);
	}
	public PageResult selectNews(int page)
	{
		PageRow row=new PageRow(page, 10);
		NewsDao dao =(NewsDao)query.getMapper(NewsDao.class, row);
		return dao.selectAllNews();
	}
	
	public PageResult<News> selectTop()
	{
		PageRow row=new PageRow(1, 6);
		NewsDao dao =(NewsDao)query.getMapper(NewsDao.class, row);
		return dao.selectAllNews();
	}
	
	public void updateNews(News news)
	{
		NewsDao dao = (NewsDao) query.getMapper(NewsDao.class);
		if(news==null||news.getId()==0)
			throw new RuntimeException("非数据库对象不允许更新");
		//System.out.println("111111111111++++"+news.getContent());
		dao.updateNews(news);
	}
	
	public News selectNewsByID(int newsID)
	{
		NewsDao dao = (NewsDao) query.getMapper(NewsDao.class);
		return dao.selectNewsByID(newsID);
	}
	/**
	 * 这个是来自于
	 * @param type
	 * @return
	 */
	public News selectNewsByCategory(String[] type)
	{
		NewsDao dao = (NewsDao) query.getMapper(NewsDao.class);
		News news=new News();
		news.setSort(Integer.parseInt(type[1]));
		news.setCategory(type[0]);
		return dao.selectNewsByCategory(news);
	}
	
	public static void main(String[] args)
	{
		NewsService service=new NewsService();
		News news=service.selectNewsByID(4);
		news.setTitle("改一下");
		service.updateNews(news);
	}
}
