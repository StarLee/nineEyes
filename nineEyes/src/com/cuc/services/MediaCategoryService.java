package com.cuc.services;

import java.util.List;

import com.develop.data.base.iml.DefaultQuery;
import com.nineEyes.bean.MediaCategory;
import com.nineEyes.dao.MediaCategoryDao;

public class MediaCategoryService
{
	DefaultQuery query = new DefaultQuery();
	MediaCategoryDao dao = (MediaCategoryDao) query.getMapper(MediaCategoryDao.class);
	public void saveMediaCategory(MediaCategory mediaCategory)
	{
		dao.insert(mediaCategory);
	}
	public List selectAll()
	{
		return dao.selectAllMediaCategory();
	}
	
	public MediaCategory selectByID(int id)
	{
		return dao.selectMediaCategory(id);
	}
	public void updateMediaCategory(MediaCategory category)
	{
		dao.updateMediaCategory(category);
	}
}
