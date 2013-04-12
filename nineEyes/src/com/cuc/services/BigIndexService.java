package com.cuc.services;

import com.develop.data.base.iml.DefaultQuery;
import com.nineEyes.bean.BigIndex;
import com.nineEyes.dao.BigIndexDao;

public class BigIndexService
{
	DefaultQuery query = new DefaultQuery();
	BigIndexDao dao = (BigIndexDao) query.getMapper(BigIndexDao.class);

	/**
	 * 保存一个新的首页，并且把上一条首页设置状态为不显示
	 * 
	 * @param bigIndex
	 */
	public void saveNewBigIndex(BigIndex bigIndex)
	{

		BigIndex old = dao.selectShow();
		if (old != null)
		{
			dao.updataStateDisabled(old.getId());
		}

		dao.insert(bigIndex);
	}

	public BigIndex selectShow()
	{
		return dao.selectShow();
	}
}
