package com.akamon.tdd.auth.src.internal;

import org.junit.Assert;
import org.junit.Test;


public class DBATest
{
	private static final String VICTOR = "Victor";
	private static final String JUANMA = "Juanma";
	private static final String PASSWORD = "Password";
	private static final String NULO = "";

	@Test
	public void testRunVictor() throws Exception
	{
		final String excepted = PASSWORD;
		final DBA dba = new DBA(VICTOR);

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunJuanma() throws Exception
	{
		final String excepted = NULO;
		final DBA dba = new DBA(JUANMA);

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}
}
