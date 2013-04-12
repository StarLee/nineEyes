package com.cuc.actions.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.nineEyes.bean.FileInfo;
import com.nineEyes.bean.JSONType;

/**
 * 上传实现（一），如有特殊情况可以重写 另外此类强烈的耦合着servlet
 * 
 * @author starlee
 * 
 */
public class FileProjectIml implements FileSaveService, FileNameTransform
{

	private String fileIndex;// 目录
	private String envURL;// 根据系统决定比如ServletActionContext.getServletContext().getRealPath("/")

	public String getEnvURL()
	{
		return envURL;
	}

	public void setEnvURL(String envURL)
	{
		this.envURL = envURL;
	}

	private boolean changeName = false;// 默认是不转换名字的

	/* 放到构造函数中spring下面这句不能成功，因为服务器并没有启动 */
	// private static String
	// URL=ServletActionContext.getServletContext().getRealPath("/");,
	public FileProjectIml(String envURL, String fileIndex) throws IOException
	{
		setEnvURL(envURL);
		setFileIndex(fileIndex);
	}


	/**
	 * 
	 * 如果文件名有后缀的，会用FileInfo设置文件类型(小写)，如果没有，则fileType为null
	 * 
	 * @param file
	 *            要保存的文件
	 * @param target
	 *            给定文件名，当setFileNameTransform未设置时，用此文件名保存。一般用的是原来的名字
	 * @return 返回地址
	 */
	public JSONType saveFile(File file, String target)
	{

		FileInputStream inputFile = null;

		try
		{

			inputFile = new FileInputStream(file);
			return saveFile(inputFile, target);
		} catch (Exception e)
		{

			e.printStackTrace();
			return null;

		} finally
		{
			try
			{
				if (inputFile != null)
					inputFile.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getFileIndex()
	{
		return fileIndex;
	}

	public void setFileIndex(String fileIndex)
	{
		this.fileIndex = fileIndex;
	}

	public void setFileNameTransform(boolean transform)
	{
		this.changeName = transform;
	}

	public  String change(String oldName)
	{
		StringBuilder builder = new StringBuilder(oldName);
		builder.replace(0, oldName.lastIndexOf("."), randomFileName());
		return builder.toString();
	}

	public static String randomFileName()
	{
		SimpleDateFormat formatFileName = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String newName = formatFileName.format(date);
		Random ran = new Random();
		int position = ran.nextInt(newName.length());
		StringBuilder builderNewName = new StringBuilder(newName);
		builderNewName.insert(position, position + "-");
		return builderNewName.toString();
	}
	
	public JSONType saveFile(File file)
	{
		return saveFile(file, file.getName());
	}

	@Override
	public JSONType saveFile(InputStream inputStream, String target)
	{
		JSONType type = new JSONType();
		FileInfo info = new FileInfo();
		if (target.contains("."))
		{
			String suffix = target.substring(target.lastIndexOf(".") + 1,
					target.length());
			info.setFileType(suffix.toLowerCase());
		}
		info.setFileNameOld(target);
		FileOutputStream outputFile = null;
		String fileIndex = getFileIndex();
		File f = new File(envURL + fileIndex);
		if (!f.exists())
			f.mkdirs();
		try
		{
			if (!f.isDirectory())
				throw new IOException(fileIndex + " is not a Directory");
			if (changeName)
				target = change(target);
			String saveURL = fileIndex + "/" + target;
			String combinURL = envURL + saveURL;

			// inputFile = new FileInputStream(file);
			outputFile = new FileOutputStream(combinURL);
			byte[] buffer = new byte[1024];// 设置缓存区为1024b
			int count = 0;
			long size = 0;
			while ((count = inputStream.read(buffer)) > 0)
			{
				outputFile.write(buffer, 0, count);
				size = size + count;
			}
			info.setFileName(target);
			info.setLength(String.valueOf(size));
			info.setPath(saveURL);
		} catch (Exception e)
		{
			info.setCode("0");
			e.printStackTrace();

		} finally
		{
			try
			{
				if (outputFile != null)
					outputFile.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		type.setBean(info);
		return type;
	}

	@Override
	public JSONType saveFile(Reader reader, String target)
	{
		JSONType type = new JSONType();
		FileInfo info = new FileInfo();
		if (target.contains("."))
		{
			String suffix = target.substring(target.lastIndexOf(".") + 1,
					target.length());
			info.setFileType(suffix.toLowerCase());
		}
		info.setFileNameOld(target);
		FileWriter outputFile = null;
		String fileIndex = getFileIndex();
		File f = new File(envURL + fileIndex);
		if (!f.exists())
			f.mkdirs();
		try
		{
			if (!f.isDirectory())
				throw new IOException(fileIndex + " is not a Directory");
			if (changeName)
				target = change(target);
			String saveURL = fileIndex + "/" + target;
			String combinURL = envURL + saveURL;

			// inputFile = new FileInputStream(file);
			outputFile = new FileWriter(combinURL);
			char[] buffer = new char[1024];// 设置缓存区为1024b
			int count = 0;
			long size = 0;
			while ((count = reader.read(buffer)) > 0)
			{
				outputFile.write(buffer, 0, count);
				size = size + count;
			}
			info.setFileName(target);
			info.setLength(String.valueOf(size));
			info.setPath(saveURL);
		} catch (Exception e)
		{
			info.setCode("0");
			e.printStackTrace();

		} finally
		{
			try
			{
				if (outputFile != null)
					outputFile.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		type.setBean(info);
		return type;
	}
}
