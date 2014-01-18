package com.akamon.tdd.auth.src.internal;

import org.junit.Assert;
import org.junit.Test;


public class DBATest
{
	@Test
	public void testRunVictor() throws Exception
	{
		final String excepted = "Password";
		final DBA dba = new DBA("Victor");

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunJuanma() throws Exception
	{
		final String excepted = "";
		final DBA dba = new DBA("Juanma");

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}
}
