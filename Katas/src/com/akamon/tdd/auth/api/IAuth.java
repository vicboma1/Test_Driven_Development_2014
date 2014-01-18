package com.akamon.tdd.auth.api;


import com.akamon.tdd.auth.api.internal.IInternal;

public interface IAuth
{
	IAuth setInternal(IInternal internal);
	IAuth setSocialMedia(ISocialMedia socialMedia);
	boolean run();
}
