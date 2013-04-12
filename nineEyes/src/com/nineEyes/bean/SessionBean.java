package com.nineEyes.bean;
/**
 * 对于一个用户应该统一管理的session信息
 * @author starlee
 *
 */
public class SessionBean
{
	private Admin user;

	public SessionBean(Admin user)
	{
		this.user=user;
	}
	
	public Admin getUser()
	{
		return user;
	}
	
}
