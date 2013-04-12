package com.cuc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.nineEyes.bean.SessionBean;

public class Logout
{
	public String execute()
	{
		HttpServletRequest request = (HttpServletRequest) ActionStatistics
				.getInstance().get(WebObject.SERVLETREQUEST);
		HttpSession session = request.getSession();
		SessionBean sessionBean=(SessionBean)session.getAttribute("user");
		if(sessionBean!=null)
		{
			session.setAttribute("user", null);
			session.invalidate();
		}
		return "ok";
	}
}
