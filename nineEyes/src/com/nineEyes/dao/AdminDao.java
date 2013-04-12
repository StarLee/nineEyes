package com.nineEyes.dao;

import com.develop.data.annotation.SQL;
import com.develop.data.annotation.SQLTYPE;
import com.nineEyes.bean.Admin;

public interface AdminDao
{
	@SQL(resultType="com.nineEyes.bean.Admin", sql = "select ID as id,NAME as name,PASSWORD as password,STATE as state from Admin where Name='#{name}'", sqlType = SQLTYPE.SELECT)
	public Admin getAdmin(String name);
}
