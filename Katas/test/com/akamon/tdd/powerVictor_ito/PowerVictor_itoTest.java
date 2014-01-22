package com.akamon.tdd.powerVictor_ito;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches Marin
 * Date: 22/01/14
 * Time: 17:45
 */
public class PowerVictor_itoTest
{
	private static final String NAME = "Victor";
	private static final String SURNAME = "Bolinches";
	private static final int AGE = 27;

	private static final String PREFIX = "_SETTER!";
	private static final int PREFIX_NUMERIC = 10;

	private static final String NAME_FIELD = "_name";
	private static final String SURNAME_FIELD = "_surname";
	private static final String AGE_FIELD = "_age";
	private static final String CREATE_TOSTRING ="createToString";

	private static final String TO_STRING = "Name: Victor Surname: Bolinches Age: 27";

	private Victor_itoMockTest victor_itoMockTest;
	private PowerVictor_ito powerVictor_ito;

	@Before
	public void setUp() throws Exception
	{
		powerVictor_ito = new PowerVictor_ito();
		victor_itoMockTest = new Victor_itoMockTest(NAME,SURNAME,AGE);
	}

	@Test
	public void testSetInstanceNameField() throws Exception
	{
		final String nameField = NAME_FIELD;
		final String expected = NAME+PREFIX;
		String resultNameReflect = "";

		try
		{
			resultNameReflect = powerVictor_ito.<String>setInstanceField(victor_itoMockTest, nameField, expected);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not set reflect private field name", resultNameReflect , expected );
	}

	@Test
	public void testGetInstanceNameField() throws Exception
	{
		final String nameField = NAME_FIELD;
		final String expected = NAME;
		String resultNameReflect = "";

		try
		{
			resultNameReflect = powerVictor_ito.<String>getInstanceField(victor_itoMockTest, nameField);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not read reflect private field name", resultNameReflect , expected );
	}

	@Test
	public void testSetInstanceSurnameField() throws Exception
	{
		final String surnameField = SURNAME_FIELD;
		final String expected = SURNAME+PREFIX;
		String resultSurnameReflect = "";

		try
		{
			resultSurnameReflect = powerVictor_ito.<String>setInstanceField(victor_itoMockTest,surnameField,expected);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not set reflect private field surname", resultSurnameReflect , expected );
	}

	@Test
	public void testGetInstanceSurnameField() throws Exception
	{
		final String surnameField = SURNAME_FIELD;
		final String expected = SURNAME;
		String resultSurnameReflect = "";

		try
		{
			resultSurnameReflect = powerVictor_ito.<String>getInstanceField(victor_itoMockTest, surnameField);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not read reflect private field surname", resultSurnameReflect , expected );
	}


	@Test
	public void testSetInstanceAgeField() throws Exception
	{
		final String ageField = AGE_FIELD;
		final int expected = AGE+PREFIX_NUMERIC;
		int resultAGEReflect = -1;

		try
		{
			resultAGEReflect = powerVictor_ito.<Integer>setInstanceField(victor_itoMockTest,ageField,expected);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not set reflect private field age", resultAGEReflect , expected );
	}

	@Test
	public void testGetInstanceAgeField() throws Exception
	{
		final String ageField = AGE_FIELD;
		final int expected = AGE;
		int resultNameReflect = PREFIX_NUMERIC;

		try
		{
			resultNameReflect = powerVictor_ito.<Integer>getInstanceField(victor_itoMockTest, ageField);
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		assertEquals("Not read reflect private field age", resultNameReflect , expected );
	}

	@Test
	public void testToString() throws Exception
	{
		final String expected = TO_STRING;

		final String resutToString = victor_itoMockTest.toString();

		assertEquals("Not same ToString", expected, resutToString);
	}

	@Test
	public void testPrivateMethod() throws Exception
	{
		final String expected = TO_STRING;

		final String privateMethod = powerVictor_ito.<String>getInstanceMethod(victor_itoMockTest,CREATE_TOSTRING);

		assertEquals("Not same ToString", expected, privateMethod);
	}
}


//internal semantic class
class Victor_itoMockTest
{

	private String _name;
	private String _surname;
	private int _age;

	public Victor_itoMockTest(String _name, String _surname, int _age)
	{
		this._name = _name;
		this._surname = _surname;
		this._age = _age;
	}

	private String createToString()
	{
		final String result =  "Name: "+_name+" Surname: "+_surname+" Age: "+_age;

		return result;
	}

	public String toString()
	{
		return createToString();
	}


}