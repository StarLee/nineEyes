package com.nineEyes.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

import com.nineEyes.bean.MediaPic;

/**
 * 
 * @author starlee
 * 
 */
public class MediaPicType extends TagSupport
{
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int doStartTag()
	{
		pageContext.setAttribute(name, MediaPic.TYPE);
		return EVAL_BODY_INCLUDE;
	}
}
