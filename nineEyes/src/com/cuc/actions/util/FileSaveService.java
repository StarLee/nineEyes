package com.cuc.actions.util;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import com.nineEyes.bean.JSONType;

/**
 * 主要是封装一下保存文件的动作
 * 用在文件上传
 * @author starlee
 *
 */
public interface FileSaveService
{
	/**
	 * 保存文件的核心方法
	 * @param file 文件
	 * @param target 文件名 给定文件名，当setFileNameTransform未设置时，用此文件名保存
	 * @return JSONType,FileInfo
	 */
	public JSONType saveFile(File file,String target);
	/**
	 * 保存文件的核心方法
	 * @param file 文件
	 * 当setFileNameTransform未设置时，用此文件名的原来名字保存
	 * @return JSONType,FileInfo
	 */
	
	
	
	public JSONType saveFile(File file);
	
	/**
	 * 文件流保存成文件
	 * @param inputStream 流
	 * @param target
	 * @return
	 */
	public JSONType saveFile(InputStream inputStream,String target);
	/**
	 * reader保存文件
	 * @param reader
	 * @param target
	 * @return
	 */
	public JSONType saveFile(Reader reader,String target);
	
	/**
	 * 获取保存目录
	 * @return
	 */
	public String getFileIndex();
	/**
	 * 设置保存目录（默认为根目录下）
	 * @param fileIndex
	 */
	public void setFileIndex(String fileIndex);
	/**
	 * 是否变换文件的名字
	 * @param transform
	 */
	public void setFileNameTransform(boolean transform);
}
