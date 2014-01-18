package com.akamon.tdd.auth.src.auth;


import com.akamon.tdd.auth.api.auth.IAuth;
import com.akamon.tdd.auth.api.auth.internal.IInternal;
import com.akamon.tdd.auth.api.auth.ISocialMedia;

public class Auth implements IAuth
{
	private IInternal internal;
	private ISocialMedia socialMedia;

	public Auth()
	{
	}

	@Override
	public IAuth setInternal(IInternal internal)
	{
		this.internal = internal;
		return this;
	}

	@Override
	public IAuth setSocialMedia(ISocialMedia socialMedia)
	{
		this.socialMedia = socialMedia;
		return this;
	}

	@Override
	public boolean run()
	{
		Boolean isAuth = false;

		try
		{
		    isAuth = this.internal.authentication();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return (isAuth) ? this.socialMedia.authentication() : false;
		}
	}
}
