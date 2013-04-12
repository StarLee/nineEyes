package com.cuc.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.cuc.services.UserLogon;
import com.develop.actions.statistics.ActionStatistics;
import com.develop.actions.statistics.WebObject;
import com.develop.actions.test.Basic;
import com.nineEyes.bean.Admin;
import com.nineEyes.bean.SessionBean;

public class Logon implements Basic
{

	private String userName;
	private String password;
	private String url;
	public String getUrl()
	{
		return url;
	}

	private String id;

	public String execute()
	{
		UserLogon logon = new UserLogon();
		HttpServletRequest request = (HttpServletRequest) ActionStatistics
				.getInstance().get(WebObject.SERVLETREQUEST);
		HttpSession session = request.getSession();

		Admin user = new Admin();

		user.setPassword(password);
		user.setName(userName);
		if (logon.checkUser(user, session))
		{
			SessionBean sessionBean = (SessionBean) session
					.getAttribute("user");
			if (sessionBean == null)
				return "fail";
			user = sessionBean.getUser();
			url="index";
			return "user";
		}
		return "fail";
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getPassword()
	{
		return password;
	}

}
