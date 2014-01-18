package com.akamon.tdd.auth.src.auth.internal;

import com.akamon.tdd.auth.api.auth.internal.IInternal;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class Internal implements IInternal
{
	private DBA dba;
	private String password;

	public Internal(String name, String password)
	{
		this.password = password;
		this.dba = new DBA(name);
	}

	public IInternal config(DBA dba)
	{
		this.dba = dba;
		return this;
	}

	public String getPassword()
	{
		return password;
	}

	@Override
	public boolean authentication() throws InterruptedException
	{
		String passwordDBA = this.dba.run();

		return (password.equals(passwordDBA) ? true : false);
	}

}
