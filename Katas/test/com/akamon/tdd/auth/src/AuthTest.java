package com.akamon.tdd.auth.src;

import com.akamon.tdd.auth.api.IAuth;
import com.akamon.tdd.auth.api.internal.IInternal;
import com.akamon.tdd.auth.api.ISocialMedia;
import com.akamon.tdd.auth.src.internal.Internal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public class AuthTest
{
	private IAuth auth;
	private ISocialMedia socialMedia;
	private IInternal internal;

	private static final String VICTOR = "Victor";
	private static final String PASSWORD = "Password";

	@Before
	public void initialize() throws Exception
	{
		internal = new Internal(VICTOR,PASSWORD);
		socialMedia = new SocialMedia(VICTOR,PASSWORD);
	}

	@Test
	public void testRun() throws Exception
	{
		this.auth = new Auth()
							.setInternal(internal)
							.setSocialMedia(socialMedia);

		final Boolean excepted = true;

		Boolean auth = this.auth.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunRejected() throws Exception
	{
		this.auth = new Auth()
						.setInternal(internal)
						.setSocialMedia(socialMedia);

		final Boolean excepted = true;

		Boolean auth = this.auth.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}
}
