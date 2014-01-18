package com.akamon.tdd.auth.src;

import com.akamon.tdd.auth.api.IAuth;
import com.akamon.tdd.auth.api.ISocialMedia;
import com.akamon.tdd.auth.api.internal.IInternal;
import com.akamon.tdd.auth.src.internal.DBA;
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
	private static final String NO_VICTOR = "No_Victor";
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
	public void testRunMockedRejected() throws Exception
	{
		final Boolean excepted = false;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  mock(ISocialMedia.class);

		//fluid Inteface
		IAuth authWithMocks = new Auth()
								.setInternal(internalMock)
								.setSocialMedia(socialMediaMock);

		when(authWithMocks.run()).thenReturn(false);

		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockSocialMediaMockAccept() throws Exception
	{
		final Boolean excepted = true;


		IInternal internalMock = new Internal(VICTOR,PASSWORD);
		ISocialMedia socialMediaMock =  mock(ISocialMedia.class);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(socialMediaMock.authentication()).thenReturn(true);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedSocialMediaMockRejected() throws Exception
	{
		final Boolean excepted = false;

		IInternal internalMock = new Internal(NO_VICTOR,PASSWORD);
		ISocialMedia socialMediaMock =  mock(ISocialMedia.class);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(socialMediaMock.authentication()).thenReturn(false);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedInternalMockRejected() throws Exception
	{
		final Boolean excepted = false;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  new SocialMedia(NO_VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(false);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}


	@Test
	public void testRunMockedInternakMockAccept() throws Exception
	{
		final Boolean excepted = true;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  new SocialMedia(VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(true);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedInternakMockAcceptWitStub() throws Exception
	{
		final Boolean excepted = true;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  new SocialMedia(VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(true);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedInternakMockRejectedWitStub() throws Exception
	{
		final Boolean excepted = false;

		IInternal internalMock = mock(IInternal.class);
		ISocialMedia socialMediaMock =  new SocialMedia(NO_VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(false);
		Boolean auth = authWithMocks.run();

		Assert.assertEquals("Not Authentication", auth, excepted);
	}


	@Test
	public void testRunMockedInternalMockAcceptedWithStubDBATimer() throws Exception
	{
		long time_start, time_end;
		Boolean isTimerOut;

		final DBA dba = mock(DBA.class);
		final Boolean excepted = true;

		IInternal internalMock = mock(IInternal.class);
		internalMock.config(dba);
		ISocialMedia socialMediaMock =  new SocialMedia(VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(true);

		time_start = System.currentTimeMillis();
		Boolean auth = authWithMocks.run();
		time_end   = System.currentTimeMillis();

		isTimerOut = ((time_end - time_start) < DBA.TIMER);

		Assert.assertEquals("TimeOut", isTimerOut, excepted);
		Assert.assertEquals("Not Authentication", auth, excepted);
	}

	@Test
	public void testRunMockedInternalMockRejectedWithStubDBATimer() throws Exception
	{
		long time_start, time_end;
		Boolean isTimerOut;

		final DBA dba = mock(DBA.class);
		final Boolean excepted = false;

		IInternal internalMock = mock(IInternal.class);
		internalMock.config(dba);
		ISocialMedia socialMediaMock =  new SocialMedia(NO_VICTOR,PASSWORD);

		IAuth authWithMocks = new Auth()
			.setInternal(internalMock)
			.setSocialMedia(socialMediaMock);

		when(internalMock.authentication()).thenReturn(true);

		time_start = System.currentTimeMillis();
		Boolean auth = authWithMocks.run();
		time_end   = System.currentTimeMillis();

		isTimerOut = ((time_end - time_start) < DBA.TIMER);

		Assert.assertEquals("TimeOut", !isTimerOut, excepted);
		Assert.assertEquals("Not Authentication", auth, excepted);
	}


}
