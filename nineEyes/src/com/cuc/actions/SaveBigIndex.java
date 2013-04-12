package com.cuc.actions;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.servlet.ServletContext;

import com.cuc.actions.util.FileProjectIml;
import com.cuc.actions.util.FileSaveService;
import com.cuc.services.BigIndexService;
import com.cuc.services.util.TimeTransform;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.BigIndex;
import com.nineEyes.bean.FileInfo;
import com.nineEyes.bean.JSONType;

import cuc.basic.statics.FileSaveIndex;

public class SaveBigIndex implements Basic
{

	private String name;
	private String intro;
	private String fileURI;
	private String url;
	public String getUrl()
	{
		return url;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setIntro(String intro)
	{
		this.intro = intro;
	}
	public void setFileURI(String fileURI)
	{
		this.fileURI = fileURI;
	}
	@Override
	public String execute()
	{
		ServletContext context=(ServletContext) ActionStatistics.getInstance().get(WebObject.SERVLETCONTEXT);
		StringReader stringReader=new StringReader(convertHTML());
		url="bigIndex";
		try
		{
			FileSaveService fileSave=new FileProjectIml(context.getRealPath("/"), FileSaveIndex.getBigIndexHTML());
			JSONType json=fileSave.saveFile(stringReader,FileProjectIml.randomFileName()+".html" );
			FileInfo info=(FileInfo)json.getBean();
			
			BigIndex bigIndex=new BigIndex();
			bigIndex.setCreateTime(TimeTransform.transform(new Date(), TimeTransform.DEFAULT));
			bigIndex.setIntro(intro);
			bigIndex.setName(name);
			bigIndex.setState("0");
			bigIndex.setUrl(info.getPath());
			BigIndexService service=new BigIndexService();
			service.saveNewBigIndex(bigIndex);
			return "ok";
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
	}
	
	private String convertHTML()
	{
		StringBuilder builder=new StringBuilder();
		builder.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		builder.append("<html>");
		builder.append("<head>");
		builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		builder.append("<title>bigIndex</title>");
		builder.append("</head>");
		builder.append("<body>");
		builder.append("<a href=\"/nineEyes/Manager/logon.html\">"); 
		builder.append("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"1024\" height=\"600\" title=\"banner\">");
		builder.append("<param name=\"movie\" value=\"/nineEyes"+fileURI+"\" />");			
		builder.append("<param value=\"transparent\" name=\"wmode\">");
		builder.append("<param name=\"quality\" value=\"high\" />");
		builder.append("<embed src=\"/nineEyes"+fileURI+"\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"1024\" height=\"600\"></embed>");
		builder.append("</object>");
		builder.append("</a>");
		builder.append("</body>");
		builder.append("</html>");
		return builder.toString();
	}
	
}
