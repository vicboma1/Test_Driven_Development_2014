package com.akamon.tdd.auth.src.auth;

import com.akamon.tdd.auth.api.auth.ISocialMedia;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class SocialMedia implements ISocialMedia
{
	private static final String VICTOR = "Victor";
	private static final String PASSWORD = "Password";
	private static final String NULL = "";

	private String name;
	private String pass;

	public SocialMedia(String name, String pass)
	{
		this.name = name;
		this.pass = pass;
	}

	@Override
	public boolean authentication()
	{
		Boolean isPass =  this.pass.equals(PASSWORD) ? true : false;
		Boolean isLogin = this.name.equals(VICTOR)   ? true : false;

		return (isLogin && isPass);
	}
}
