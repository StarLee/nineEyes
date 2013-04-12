package com.nineEyes.bean.show;

import java.util.List;

import com.cuc.services.MediaService;
import com.nineEyes.bean.Media;
import com.nineEyes.bean.MediaCategory;
/**
 * ����ǿͻ�����Ƶ��ҳ
 * @author starlee
 *
 */
public class PlayIndex
{
	private MediaCategory mediaCategory;
	
	private MediaService service;
	public PlayIndex(MediaCategory category)
	{
		service=new MediaService();
		this.mediaCategory=category;
	}
	public MediaCategory getMediaCategory()
	{
		return mediaCategory;
	}
	
	public Media getFirstMedia()
	{
		return service.showMediaFirst(this.mediaCategory);
	}
	
	public List<Media> getTopMedia()
	{
		return service.showMediaTopFour(this.mediaCategory);
	}
	
}
