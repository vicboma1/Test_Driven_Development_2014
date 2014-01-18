package com.akamon.tdd.auth.src;

import com.akamon.tdd.auth.api.IAuth;
import com.akamon.tdd.auth.api.ISocialMedia;
import com.akamon.tdd.auth.api.internal.IInternal;
import com.akamon.tdd.auth.src.internal.Internal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

		this.auth = new Auth()
			.setInternal(internal)
			.setSocialMedia(socialMedia);
	}

	@Test
	public void testRun() throws Exception
	{
		final Boolean excepted = true;

		Boolean auth = this.auth.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunRejected() throws Exception
	{
		final Boolean excepted = true;

		Boolean auth = this.auth.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedAccept() throws Exception
	{
		final Boolean excepted = true;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  mock(ISocialMedia.class);

		IAuth authWithMocks = new Auth()
								.setInternal(internalMock)
								.setSocialMedia(socialMediaMock);


		when(authWithMocks.run()).thenReturn(true);

	    Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedRejected() throws Exception
	{
		final Boolean excepted = false;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  mock(ISocialMedia.class);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(authWithMocks.run()).thenReturn(false);

		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

}
