package com.nineEyes.bean;
/**
 * 基本的用户Bean
 * @author starlee
 *
 */
public class Admin
{
	private int id;
	private String name;
	private String password;
	private String state;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
}
