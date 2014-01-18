package com.akamon.tdd.auth.src.internal;

import com.akamon.tdd.auth.api.internal.IInternal;
import org.junit.Assert;
import org.junit.Before;
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
	private static final String VICTOR = "Victor";
	private static final String JUANMA = "Juanma";
	private static final String PASSWORD = "Password";

	private  IInternal internal;

	@Before
	public void initialize() throws  Exception
	{
		internal = new Internal(VICTOR, PASSWORD);
	}

	@Test
	public void testGetPassword() throws Exception
	{
		final String excepted = PASSWORD;

		String pass = internal.getPassword();

		Assert.assertEquals("Not password",pass,excepted );
	}

	@Test
	public void testAuthenticationVictor() throws Exception
	{
		final boolean excepted = true;

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}

	@Test
	public void testAuthenticationJuanma() throws Exception
	{
		final boolean excepted = false;

		final IInternal internal = new Internal(JUANMA, PASSWORD);
		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}
}
