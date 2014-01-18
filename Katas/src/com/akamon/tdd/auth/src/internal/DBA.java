package com.akamon.tdd.auth.src.internal;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class DBA
{
	private static final String VICTOR = "Victor";
	private static final String PASSWORD = "Password";
	private static final String NULL = "";
	private static final int TIMER = 2000;

	private String name;

	public DBA(String name)
	{
		this.name = name;
	}

	public String run() throws InterruptedException
	{
		Thread.sleep(TIMER);
		return (this.name.equals(VICTOR) ? PASSWORD : NULL);
	}

}
