package com.nineEyes.tag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 这个强烈耦合文件夹与页面的js
 * @author starlee
 *
 */
public class DefaultNavigation extends TagSupport
{
	private int defaultOrder;
	
	
	

	public void setDefaultOrder(int defaultOrder)
	{
		this.defaultOrder = defaultOrder;
	}

	public int doStartTag()
	{
		String[] img={"/images/index_new.gif","/images/service_new.gif","/images/resource_new.gif","/images/case_new.gif","/images/coorperative_new.gif","/images/scholar_new.gif"};
		String defaultImg=img[defaultOrder];
		ServletContext context=pageContext.getServletContext();
		String path=(String)context.getAttribute("root");
		img[defaultOrder]=defaultImg.substring(0, defaultImg.lastIndexOf(".gif"))+"_select.gif";
		pageContext.setAttribute("index",path+img[0] );
		pageContext.setAttribute("service", path+img[1]);
		pageContext.setAttribute("resource", path+img[2]);
		pageContext.setAttribute("case", path+img[3]);
		pageContext.setAttribute("cooperative", path+img[4]);
		pageContext.setAttribute("scholar", path+img[5]);
		return EVAL_BODY_INCLUDE;
	}
}
