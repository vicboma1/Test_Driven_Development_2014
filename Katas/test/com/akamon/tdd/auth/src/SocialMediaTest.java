package com.akamon.tdd.auth.src;

import com.akamon.tdd.auth.api.ISocialMedia;
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
	@Test
	public void testAuthenticationVictor() throws Exception
	{
		final Boolean excepted = true;
		final ISocialMedia socialMedia = new SocialMedia("Victor", "Password");

		Boolean pass = socialMedia.authentication();

		Assert.assertEquals("Not Authentication", pass, excepted);
	}

	@Test
	public void testAuthenticationJuanma() throws Exception
	{
		final Boolean excepted = false;
		final ISocialMedia socialMedia = new SocialMedia("Juana", "Password");

		Boolean pass = socialMedia.authentication();

		Assert.assertEquals("Not Authentication", pass, excepted);
	}
}
