package com.akamon.tdd.auth.src;


import com.akamon.tdd.auth.api.IAuth;
import com.akamon.tdd.auth.api.internal.IInternal;
import com.akamon.tdd.auth.api.ISocialMedia;

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
		return this.socialMedia.authentication();
	}
}
