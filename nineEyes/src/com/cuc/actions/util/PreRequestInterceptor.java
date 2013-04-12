package com.cuc.actions.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.develop.actions.action.ActionInterceptor;
import com.develop.actions.action.ActionInvocation;
import com.develop.actions.statistics.WebObject;

public class PreRequestInterceptor implements ActionInterceptor
{
	@Override
	public void invoke(ActionInvocation invocation)
	{
		HttpServletRequest request = (HttpServletRequest) invocation
				.getActionStatistics().get(WebObject.SERVLETREQUEST);
		FileWrapper requestWrap = new FileWrapper(request);
		invocation.getActionStatistics().set(WebObject.SERVLETREQUEST,
				requestWrap);
		invocation.invoke();
	}
}
