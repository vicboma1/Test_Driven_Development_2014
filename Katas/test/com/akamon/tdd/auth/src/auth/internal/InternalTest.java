package com.akamon.tdd.auth.src.auth.internal;

import com.akamon.tdd.auth.api.auth.internal.IInternal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
	private static final String NOT_PASSWORD = "NO_Password";

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
	public void testAuthenticationJuanmaMock() throws Exception
	{
		final boolean excepted = false;

		DBA dbaMock = mock(DBA.class);
		when(dbaMock.run()).thenReturn(NOT_PASSWORD);
		internal.config(dbaMock);

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password", auth, excepted );
	}

	@Test
	public void testMockDBAAccept() throws Exception
	{
		final boolean excepted = true;

		DBA dbaMock = mock(DBA.class);
		when(dbaMock.run()).thenReturn(PASSWORD);
		internal.config(dbaMock);

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}

	@Test
	public void testMockDBARejected() throws Exception
	{
		final boolean excepted = false;

		DBA dbaMock = mock(DBA.class);
		when(dbaMock.run()).thenReturn(VICTOR);
		internal.config(dbaMock);

		Boolean auth = internal.authentication();

		Assert.assertEquals("Not password",excepted,auth );
	}

	/**
	 * He utilizado solo una variable para el valor esperado.
	 * He jugado un poco con la "cleverada" del ! antes de la variables.
	 * Es que no queria llenar el campo de declaracion con 4 booleanos.
	 * @throws Exception
	 */
	@Test
	public void testMockDBATimerOut() throws Exception
	{
		final boolean excepted = true;

		long time_start, time_end;
		Boolean isTimerOut;

		DBA dbaMock = mock(DBA.class);
		internal.config(dbaMock);

		time_start = System.currentTimeMillis();
		when(dbaMock.run()).thenReturn(VICTOR);
		time_end   = System.currentTimeMillis();

		Boolean auth = internal.authentication();
		isTimerOut = ((time_end - time_start) > DBA.TIMER);

		Assert.assertEquals("TimerOut",!isTimerOut,excepted );
		Assert.assertEquals("Not password",!excepted,auth );
	}
}
