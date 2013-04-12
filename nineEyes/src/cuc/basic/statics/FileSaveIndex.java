package cuc.basic.statics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileSaveIndex
{
	private static String exhibit="/fileupload/bigIndex/";//大首页的文件所在地
	private static String bigIndexHTML="/fileupload/bigIndexHTML/";
	private static String newsPic="/fileupload/newsPic/";
	private static String mediaPic="/fileupload/mediaPic/";
	public static String getCurrent()
	{
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
		
	}
	public static String getBigIndexHTML()
	{
		return bigIndexHTML+getCurrent();
	}
	public static String getBigIndex()
	{
		return exhibit+getCurrent();
	}
	public static String getNewsPic()
	{
		return newsPic+getCurrent();
	}
	public static String getMediaPic()
	{
		return mediaPic+getCurrent();
	}
}
