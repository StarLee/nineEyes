package com.nineEyes.bean;
/**
 * ����һ���û�Ӧ��ͳһ�����session��Ϣ
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
