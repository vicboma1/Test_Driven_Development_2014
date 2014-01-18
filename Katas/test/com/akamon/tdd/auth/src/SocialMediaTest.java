package com.akamon.tdd.auth.src;

import com.akamon.tdd.auth.api.auth.ISocialMedia;
import com.akamon.tdd.auth.src.auth.SocialMedia;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
public class SocialMediaTest
{
	private static final String VICTOR = "Victor";
	private static final String JUANMA = "Juanma";
	private static final String PASSWORD = "Password";

	@Test
	public void testAuthenticationVictor() throws Exception
	{
		final Boolean excepted = true;
		final ISocialMedia socialMedia = new SocialMedia(VICTOR, PASSWORD);

		Boolean pass = socialMedia.authentication();

		Assert.assertEquals("Not Authentication", pass, excepted);
	}

	@Test
	public void testAuthenticationJuanma() throws Exception
	{
		final Boolean excepted = false;
		final ISocialMedia socialMedia = new SocialMedia(JUANMA, PASSWORD);

		Boolean pass = socialMedia.authentication();

		Assert.assertEquals("Not Authentication", pass, excepted);
	}
}
