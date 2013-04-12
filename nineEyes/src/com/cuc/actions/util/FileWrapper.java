package com.cuc.actions.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.develop.actions.action.BasicHttpRequestWrapper;
import com.develop.actions.action.BasicWrapper;
import com.develop.actions.statistics.WebObject;

public class FileWrapper extends HttpServletRequestWrapper implements BasicHttpRequestWrapper
{
	private Logger log=Logger.getLogger(FileWrapper.class);
	private Map formValue=new HashMap();
	@SuppressWarnings("unchecked")
	public FileWrapper(HttpServletRequest request)
	{
		super(request);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart)
		{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(tempFile(request.getContextPath()
					+ File.pathSeparator + ManageFile.tempFileRepository));
			factory.setSizeThreshold(1024 * 1024*1024);
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(50 * 1024 * 1024);
			try
			{
				// Parse the request
				List /* FileItem */items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext())
				{
					FileItem item = (FileItem) iter.next();

					if (item.isFormField())
					{
						formValue.put(item.getFieldName(), item.getString());
					} else
					{
						formValue.put(item.getFieldName(), item);
						formValue.put(item.getFieldName()+"ContentType", item.getContentType());
						formValue.put(item.getFieldName()+"FileName", item.getName());
					}
				}
			} catch (FileUploadException e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			log.info("普通表单");
			Enumeration<String> names=  request.getParameterNames();
			while(names.hasMoreElements())
			{
				String name=names.nextElement();
				if(request.getParameterValues(name).length>=2)//数组
					formValue.put(name, request.getParameterValues(name));
				else
					formValue.put(name, request.getParameter(name));
			}
		}
	}

	@Override
	public Object getPassValue(String name)
	{
		return formValue.get(name);
	}

	@Override
	public void setPassValue(String key, Object value)
	{
		formValue.put(key, value);
	}

	private File tempFile(String url)
	{
		File file = new File(url);
		if (!file.exists())
			file.mkdirs();
		return file;
	}
}
