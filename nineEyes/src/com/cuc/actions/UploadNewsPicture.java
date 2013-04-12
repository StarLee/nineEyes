package com.cuc.actions;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import com.cuc.actions.util.FileProjectIml;
import com.cuc.actions.util.FileSaveService;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.JSONType;

import cuc.basic.statics.FileSaveIndex;

public class UploadNewsPicture implements Basic
{
	private FileItem file; 
	private JSONType json;
	
	@Override
	public String execute()
	{
		ServletContext context=(ServletContext) ActionStatistics.getInstance().get(WebObject.SERVLETCONTEXT);
		try
		{
			FileSaveService saveFile=new FileProjectIml(context.getRealPath("/"),FileSaveIndex.getNewsPic());
			saveFile.setFileNameTransform(true);
			json=saveFile.saveFile(file.getInputStream(), file.getName());
			
			//System.out.println(info.getFileName()+"///"+info.getLength()+"///"+info.getPath()+"///"+info.getFileType());
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}


	public JSONType getJson()
	{
		return json;
	}


	public void setFile(FileItem file)
	{
		this.file = file;
	}
}
