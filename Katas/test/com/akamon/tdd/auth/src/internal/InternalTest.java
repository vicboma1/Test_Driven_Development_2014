package com.akamon.tdd.auth.src.internal;

import com.akamon.tdd.auth.api.internal.IInternal;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class InternalTest
{
	@Test
	public void testGetPassword() throws Exception
	{
		final String excepted = "Password";
		final IInternal internal = new Internal("Victor", "Password");

		String pass = internal.getPassword();

		Assert.assertEquals("Not password",pass,excepted );
	}

	@Test
	public void testAuthenticationVictor() throws Exception
	{
		final boolean excepted = true;
		final IInternal internal = new Internal("Victor", "Password");

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}

	@Test
	public void testAuthenticationJuanma() throws Exception
	{
		final boolean excepted = false;
		final IInternal internal = new Internal("Juanma", "Password");

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}
}
