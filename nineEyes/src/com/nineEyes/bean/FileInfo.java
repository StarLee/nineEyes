package com.nineEyes.bean;
/**
 * �ļ������Ϣ����
 * @author starlee
 *
 */
public class FileInfo
{
	private String path;//�ļ�·��
	private String  length;//�ļ�����
	private String fileName;//�ļ���
	private String code= "1";//Ĭ��Ϊ�ɹ���ʧ��Ϊ0
	private String fileNameOld;//�ļ��ı�������
	private String fileType;//ȡ�ú�׺
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
