package com.akamon.tdd.auth.api.auth;


import com.akamon.tdd.auth.api.auth.internal.IInternal;

public interface IAuth
{
	IAuth setInternal(IInternal internal);
	IAuth setSocialMedia(ISocialMedia socialMedia);
	boolean run();
}
