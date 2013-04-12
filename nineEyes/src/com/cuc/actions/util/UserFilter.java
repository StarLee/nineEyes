package com.cuc.actions.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.nineEyes.bean.SessionBean;



public class UserFilter implements Filter
{
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
		HttpServletRequest request=(HttpServletRequest)arg0;
		
		String uri=request.getRequestURI();
		//System.out.println("================="+uri);
		//System.out.println("============"+request.getContextPath());
		String[] context=request.getServletPath().split("/");
		if("/nineEyes/Logon.do".equals(uri));
		if(context.length>1)
		{	
			
			if(context[0]!=null&&"customer".equals(context[0].trim()));
		}
		else
		{
			SessionBean bean=(SessionBean)request.getSession().getAttribute("user");
			if(bean==null)
			{
				request.getRequestDispatcher("/").forward(arg0, arg1);
				return ;
			}
		}
		arg2.doFilter(arg0, arg1);
	}

	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	
}
