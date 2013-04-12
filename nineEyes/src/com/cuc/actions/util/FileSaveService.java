package com.cuc.actions.util;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import com.nineEyes.bean.JSONType;

/**
 * ��Ҫ�Ƿ�װһ�±����ļ��Ķ���
 * �����ļ��ϴ�
 * @author starlee
 *
 */
public interface FileSaveService
{
	/**
	 * �����ļ��ĺ��ķ���
	 * @param file �ļ�
	 * @param target �ļ��� �����ļ�������setFileNameTransformδ����ʱ���ô��ļ�������
	 * @return JSONType,FileInfo
	 */
	public JSONType saveFile(File file,String target);
	/**
	 * �����ļ��ĺ��ķ���
	 * @param file �ļ�
	 * ��setFileNameTransformδ����ʱ���ô��ļ�����ԭ�����ֱ���
	 * @return JSONType,FileInfo
	 */
	
	
	
	public JSONType saveFile(File file);
	
	/**
	 * �ļ���������ļ�
	 * @param inputStream ��
	 * @param target
	 * @return
	 */
	public JSONType saveFile(InputStream inputStream,String target);
	/**
	 * reader�����ļ�
	 * @param reader
	 * @param target
	 * @return
	 */
	public JSONType saveFile(Reader reader,String target);
	
	/**
	 * ��ȡ����Ŀ¼
	 * @return
	 */
	public String getFileIndex();
	/**
	 * ���ñ���Ŀ¼��Ĭ��Ϊ��Ŀ¼�£�
	 * @param fileIndex
	 */
	public void setFileIndex(String fileIndex);
	/**
	 * �Ƿ�任�ļ�������
	 * @param transform
	 */
	public void setFileNameTransform(boolean transform);
}
