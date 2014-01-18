package com.akamon.tdd.auth.src.internal;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DBATest
{
	private static final String VICTOR = "Victor";
	private static final String JUANMA = "Juanma";
	private static final String PASSWORD = "Password";
	private static final String NULO = "";

	@Test
	public void testRunAccept() throws Exception
	{
		final String excepted = PASSWORD;
		final DBA dba = new DBA(VICTOR);

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunReject() throws Exception
	{
		final String excepted = NULO;
		final DBA dba = new DBA(JUANMA);

		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunMockAccepted() throws Exception
	{
		final String excepted = PASSWORD;
		final DBA dba = mock(DBA.class);

		when(dba.run()).thenReturn(PASSWORD);
		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunMockRejected() throws Exception
	{
		final String excepted = NULO;
		final DBA dba = mock(DBA.class);

		when(dba.run()).thenReturn(NULO);
		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunMockAcceptedWithStub() throws Exception
	{
		final String excepted = PASSWORD;
		final DBA dba = mock(DBA.class);

		dba.name(VICTOR);
		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}

	@Test
	public void testRunMockRejectedWithStub() throws Exception
	{
		final String excepted = NULO;
		final DBA dba = mock(DBA.class);

		dba.name(JUANMA);
		String executed = dba.run();

		Assert.assertEquals(executed,excepted);
	}
}
