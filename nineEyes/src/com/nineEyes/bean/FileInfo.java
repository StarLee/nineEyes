package com.nineEyes.bean;
/**
 * 文件相关信息的类
 * @author starlee
 *
 */
public class FileInfo
{
	private String path;//文件路径
	private String  length;//文件长度
	private String fileName;//文件名
	private String code= "1";//默认为成功，失败为0
	private String fileNameOld;//文件的本来名字
	private String fileType;//取得后缀
	public String getFileNameOld()
	{
		return fileNameOld;
	}
	public void setFileNameOld(String fileNameOld)
	{
		this.fileNameOld = fileNameOld;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getLength()
	{
		return length;
	}
	public void setLength(String length)
	{
		this.length = length;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getFileType()
	{
		return fileType;
	}
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}
}
