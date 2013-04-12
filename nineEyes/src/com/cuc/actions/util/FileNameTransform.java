package com.cuc.actions.util;

/**
 * 变换文件名
 * @author starlee
 *
 */
public interface FileNameTransform
{
	/**
	 * 
	 * @param oldName 原来的名字
	 * @return 转换之后的名字
	 */
	String change(String oldName);
}
