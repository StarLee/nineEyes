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
 * �ϴ�ʵ�֣�һ���������������������д �������ǿ�ҵ������servlet
 * 
 * @author starlee
 * 
 */
public class FileProjectIml implements FileSaveService, FileNameTransform
{

	private String fileIndex;// Ŀ¼
	private String envURL;// ����ϵͳ��������ServletActionContext.getServletContext().getRealPath("/")

	public String getEnvURL()
	{
		return envURL;
	}

	public void setEnvURL(String envURL)
	{
		this.envURL = envURL;
	}

	private boolean changeName = false;// Ĭ���ǲ�ת�����ֵ�

	/* �ŵ����캯����spring������䲻�ܳɹ�����Ϊ��������û������ */
	// private static String
	// URL=ServletActionContext.getServletContext().getRealPath("/");,
	public FileProjectIml(String envURL, String fileIndex) throws IOException
	{
		setEnvURL(envURL);
		setFileIndex(fileIndex);
	}


	/**
	 * 
	 * ����ļ����к�׺�ģ�����FileInfo�����ļ�����(Сд)�����û�У���fileTypeΪnull
	 * 
	 * @param file
	 *            Ҫ������ļ�
	 * @param target
	 *            �����ļ�������setFileNameTransformδ����ʱ���ô��ļ������档һ���õ���ԭ��������
	 * @return ���ص�ַ
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
			byte[] buffer = new byte[1024];// ���û�����Ϊ1024b
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
			char[] buffer = new char[1024];// ���û�����Ϊ1024b
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
