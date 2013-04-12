package com.cuc.services;

import javax.servlet.http.HttpSession;

import com.develop.data.base.iml.DefaultQuery;
import com.nineEyes.bean.Admin;
import com.nineEyes.bean.SessionBean;
import com.nineEyes.dao.AdminDao;

public class UserLogon 
{
	/**
	 * ∂¡»°”√ªß
	 * @param userName
	 * @return
	 */
	public Admin readUser(String userName)
	{
		DefaultQuery query=new DefaultQuery();
		AdminDao user=(AdminDao)query.getMapper(AdminDao.class);
		
		return user.getAdmin(userName);
	}
	
	public boolean checkUser(Admin user,HttpSession session)
	{
		
		String userName=user.getName();
		Admin userFromData=readUser(userName);
		String psFromData=userFromData.getPassword();
		String psFromRequest=user.getPassword();
		try
		{
			if(psFromData.trim().equals(psFromRequest.trim()))
			{
				session.setAttribute("user",new SessionBean(userFromData));
				return true;
			}
			else
				return false;
		}
		catch (Exception e) {
			return false;
		}
				
	}
}
