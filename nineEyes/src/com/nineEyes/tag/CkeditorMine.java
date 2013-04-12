package com.nineEyes.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.ckeditor.CKEditorConfig;
import com.ckeditor.CKEditorTag;
import com.ckeditor.EventHandler;
/**
 * �򵥵İ�����һ��ckeditor
 * @author starlee
 * 
 */
public class CkeditorMine extends TagSupport
{

	private String defaultValue="<div>���ڴ������ճ���������</div>";
	
	public String getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	private String height;
	private String width;
	@Override
	public int doStartTag() throws JspException
	{
		CKEditorConfig defaultSettings = new CKEditorConfig();
		
		EventHandler eventHandler = new EventHandler();
		eventHandler.addEventHandler("instanceReady","function (ev) { editorCustom=ev; }");
		pageContext.setAttribute("defaultValue", defaultValue);
		pageContext.setAttribute("defaultSettings", defaultSettings);
		pageContext.setAttribute("defaultEvent", eventHandler);
		return EVAL_BODY_INCLUDE;
	}

}
