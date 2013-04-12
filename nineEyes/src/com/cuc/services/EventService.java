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
import com.nineEyes.bean.Event;
import com.nineEyes.bean.EventToMedia;
import com.nineEyes.bean.LinkNewsEvent;
import com.nineEyes.bean.Media;
import com.nineEyes.bean.MediaPic;
import com.nineEyes.dao.EventDao;
import com.nineEyes.dao.EventToMediaDao;
import com.nineEyes.dao.LinkNewsEventDao;
import com.nineEyes.dao.MediaDao;
import com.nineEyes.dao.MediaPicDao;

public class EventService
{
	DefaultQuery query = new DefaultQuery();

	public void saveEvent(final Event event, List<MediaPic> mediaPic,
			List<EventToMedia> eventToMedias,List<LinkNewsEvent> linkNewsEvents) throws SQLException
	{
		query.execute(new JDBCCallback()
		{
			@Override
			public Object doExecute(Session arg0)
			{
				try
				{
					String sql = "insert into Event(ID,OUTLINE,INTRO,TITLE,AUTHOR,CREATETIME,CATEGORY) values(0,?,?,?,?,?,?)";
					PreparedStatement statement = arg0
							.getConnectionProvider()
							.getConnection()
							.prepareStatement(sql,
									Statement.RETURN_GENERATED_KEYS);
					statement.setString(1, event.getOutline());
					statement.setString(2, event.getIntro());
					statement.setString(3, event.getTitle());
					statement.setString(4, event.getAuthor());
					statement.setDate(5,
							new java.sql.Date(new Date().getTime()));
					statement.setString(6, event.getCategory());
					statement.executeUpdate();
					ResultSet rs = statement.getGeneratedKeys();
					for (; rs.next();)
					{
						event.setId(rs.getInt(1));
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
				pic.setMedia(event.getId());
				pic.setBelong("1");
				picDao.insert(pic);
			}
		}

		if (eventToMedias != null && !eventToMedias.isEmpty())
		{
			EventToMediaDao eventToMediaDao = (EventToMediaDao) query
					.getMapper(EventToMediaDao.class);

			Iterator<EventToMedia> it = eventToMedias.iterator();
			for (; it.hasNext();)
			{
				EventToMedia eventToMedia = it.next();
				eventToMedia.setEvent(event.getId());
				eventToMediaDao.insert(eventToMedia);
			}
		}
		if (linkNewsEvents != null && !linkNewsEvents.isEmpty())
		{
			LinkNewsEventDao eventToMediaDao = (LinkNewsEventDao) query
					.getMapper(LinkNewsEventDao.class);

			Iterator<LinkNewsEvent> it = linkNewsEvents.iterator();
			for (; it.hasNext();)
			{
				LinkNewsEvent eventToMedia = it.next();
				eventToMedia.setEvent(event.getId());
				eventToMediaDao.insert(eventToMedia);
			}
		}
	}

	public void updateEvent(Event event, List<MediaPic> mediaPic,
			List<EventToMedia> eventToMedias,List<LinkNewsEvent> linkNewsEvents) throws SQLException
	{
		EventDao dao = (EventDao) query.getMapper(EventDao.class);
		dao.updateEvent(event);
		if (mediaPic != null && !mediaPic.isEmpty())
		{
			MediaPicDao picDao = (MediaPicDao) query
					.getMapper(MediaPicDao.class);

			Iterator<MediaPic> it = mediaPic.iterator();
			for (; it.hasNext();)
			{
				MediaPic pic = it.next();
				pic.setMedia(event.getId());
				pic.setBelong("1");
				picDao.insert(pic);
			}
		}

		if (eventToMedias != null && !eventToMedias.isEmpty())
		{
			EventToMediaDao eventToMediaDao = (EventToMediaDao) query
					.getMapper(EventToMediaDao.class);

			Iterator<EventToMedia> it = eventToMedias.iterator();
			for (; it.hasNext();)
			{
				EventToMedia eventToMedia = it.next();
				eventToMedia.setEvent(event.getId());
				eventToMediaDao.insert(eventToMedia);
			}
		}
		if (linkNewsEvents != null && !linkNewsEvents.isEmpty())
		{
			LinkNewsEventDao eventToMediaDao = (LinkNewsEventDao) query
					.getMapper(LinkNewsEventDao.class);

			Iterator<LinkNewsEvent> it = linkNewsEvents.iterator();
			for (; it.hasNext();)
			{
				LinkNewsEvent eventToMedia = it.next();
				eventToMedia.setEvent(event.getId());
				eventToMediaDao.insert(eventToMedia);
			}
		}
	}

	public PageResult<Event> showEvent(int page)
	{
		PageRow pageRow = new PageRow(page, 10);
		EventDao dao = (EventDao) query.getMapper(EventDao.class, pageRow);
		return dao.selectEvent();
	}

	public Event selectByID(int id)
	{
		EventDao dao = (EventDao) query.getMapper(EventDao.class);
		return dao.selectEventByID(id);
	}

	/**
	 * 获取视频花絮
	 * 
	 * @param eventID事件的ID
	 * @return
	 */
	public List<Media> selectMedia(int eventID)
	{
		EventToMediaDao dao = (EventToMediaDao) query
				.getMapper(EventToMediaDao.class);
		List<EventToMedia> list = dao.selectByEventID(eventID);
		MediaDao mediaDao = (MediaDao) query.getMapper(MediaDao.class);
		Iterator<EventToMedia> it = list.iterator();
		List<Media> media = new ArrayList();
		for (; it.hasNext();)
		{
			media.add(mediaDao.selectMediaPlay(it.next().getMedia()));
		}
		return media;
	}
	
	public void deleteMediaRelation(int event,int media)
	{
		EventToMediaDao dao = (EventToMediaDao) query
				.getMapper(EventToMediaDao.class);
		EventToMedia eventToMedia=new EventToMedia();
		eventToMedia.setEvent(event);
		eventToMedia.setMedia(media);
		dao.deleteRelation(eventToMedia);
	}
	
	public void deletePicRelation(int id)
	{
		MediaPicService service=new MediaPicService();
		service.deleteRecord(id);
	}
	
	public void deleteLinkNews(int id)
	{
		LinkNewsEventService service=new LinkNewsEventService();
		service.deleteByID(id);
	}
}
