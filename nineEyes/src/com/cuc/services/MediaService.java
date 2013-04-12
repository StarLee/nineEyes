package com.cuc.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.develop.data.base.JDBCCallback;
import com.develop.data.base.Session;
import com.develop.data.base.iml.DefaultQuery;
import com.develop.data.result.PageResult;
import com.develop.data.result.PageRow;
import com.nineEyes.bean.Media;
import com.nineEyes.bean.MediaCategory;
import com.nineEyes.bean.MediaPic;
import com.nineEyes.dao.MediaDao;
import com.nineEyes.dao.MediaPicDao;

public class MediaService
{
	DefaultQuery query = new DefaultQuery();

	public void saveMedia(final Media media, List<MediaPic> mediaPic)
			throws SQLException
	{
		query.execute(new JDBCCallback()
		{

			@Override
			public Object doExecute(Session arg0)
			{
				try
				{
					String sql = "insert into Media(ID,URL,OUTLINE,INTRO,TITLE,AUTHOR,CREATETIME,CATEGORY) values(0,?,?,?,?,?,?,?)";
					PreparedStatement statement = arg0
							.getConnectionProvider()
							.getConnection()
							.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);

					statement.setString(1, media.getUrl());

					statement.setString(2, media.getOutline());
					statement.setString(3, media.getIntro());
					statement.setString(4, media.getTitle());
					statement.setString(5, media.getAuthor());
					statement.setDate(6,
							new java.sql.Date(new Date().getTime()));
					statement.setInt(7, media.getCategory());
					statement.executeUpdate();
					ResultSet rs = statement.getGeneratedKeys();
					for (; rs.next();)
					{
						media.setId(rs.getInt(1));
					}
					return null;
				} catch (SQLException e)
				{
					e.printStackTrace();
					return null;
				}
			}
		});
		if (mediaPic != null && !mediaPic.isEmpty())
		{
			MediaPicDao picDao = (MediaPicDao) query
					.getMapper(MediaPicDao.class);

			Iterator<MediaPic> it = mediaPic.iterator();
			for (; it.hasNext();)
			{
				MediaPic pic = it.next();
				pic.setMedia(media.getId());
				pic.setBelong("0");
				picDao.insert(pic);
			}
		}
	}

	public void updateMedia(Media media, List<MediaPic> mediaPic)
	{
		MediaDao dao = (MediaDao) query.getMapper(MediaDao.class);
		dao.updateMedia(media);
		
		if (mediaPic != null && !mediaPic.isEmpty())
		{
			MediaPicDao picDao = (MediaPicDao) query
					.getMapper(MediaPicDao.class);

			Iterator<MediaPic> it = mediaPic.iterator();
			for (; it.hasNext();)
			{
				MediaPic pic = it.next();
				pic.setMedia(media.getId());
				pic.setBelong("0");
				picDao.insert(pic);
			}
		}
		
	}

	public void deletePicRelation(int id)
	{
		MediaPicService service = new MediaPicService();
		service.deleteRecord(id);
	}

	public PageResult<Media> showMedia(int page)
	{
		PageRow pageRow = new PageRow(page, 10);
		MediaDao dao = (MediaDao) query.getMapper(MediaDao.class, pageRow);
		return dao.selectMedia();
	}

	/**
	 * 取第一条,没有则返回null;
	 * 
	 * @return
	 */
	public Media showMediaFirst(MediaCategory category)
	{
		PageRow pageRow = new PageRow(1, 1);
		MediaDao dao = (MediaDao) query.getMapper(MediaDao.class, pageRow);
		PageResult result = dao.selectMediaByCategory(category);
		if (result != null && !result.isEmpty())
		{
			Iterator<Media> it = result.iterator();
			for (int n = 0; n < 1 && it.hasNext(); n++)
			{
				return it.next();
			}
		}
		return null;
	}

	/**
	 * 取前四条
	 * 
	 * @return
	 */
	public List<Media> showMediaTopFour(MediaCategory category)
	{
		PageRow pageRow = new PageRow(1, 4);
		MediaDao dao = (MediaDao) query.getMapper(MediaDao.class, pageRow);
		PageResult<Media> result = dao.selectMediaByCategory(category);
		if (result != null && !result.isEmpty())
		{
			List<Media> list = new ArrayList();
			Iterator<Media> it = result.iterator();
			for (int n = 0; n < 4 && it.hasNext(); n++)
			{
				list.add(it.next());
			}
			return list;
		}
		return null;
	}

	public Media mediaPlay(int id)
	{
		MediaDao dao = (MediaDao) query.getMapper(MediaDao.class);
		// System.out.println("+++++++++++++++++++++++++"+id+"++++");
		return dao.selectMediaPlay(id);
	}

	public PageResult<MediaPic> getSlide()
	{
		PageRow pageRow = new PageRow(1, 10);
		MediaPicDao dao = (MediaPicDao) query.getMapper(MediaPicDao.class,
				pageRow);
		return dao.selectTop();
	}

	public static void main(String[] args) throws SQLException
	{
		MediaService service = new MediaService();
		/*
		 * Media media = new Media(); media.setAuthor("lixing");
		 * media.setCategory(1); String datetime =
		 * TimeTransform.defaultFormat(new Date()); System.out.println("------"
		 * + datetime); // media.setDatetime(datetime); media.setIntro("测试");
		 * media.setTitle("title"); media.setUrl("abc");
		 * media.setOutline("abc"); service.saveMedia(media, null);
		 * System.out.println("+++++"+service.mediaPlay(4).getTitle());
		 */
		PageResult<MediaPic> me = service.getSlide();
		Iterator<MediaPic> it = me.iterator();
		for (; it.hasNext();)
		{
			System.out.println(it.next().getUrl());
		}

	}
}
