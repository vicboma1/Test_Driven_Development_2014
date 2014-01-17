package com.akamon.tdd.fizzBuzz; /**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches y Juanma Martin
 * Date: 11/01/14
 * Time: 10:58
 * To change this template use ReaderProcessor | Settings | ReaderProcessor Templates.
 */

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest
{
	@org.junit.Test
	public void oneTriggersOne() throws Exception
	{
		final String expected = "1";   //Arrange
		final int sequence = 1;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not One", expected, say); //Assert
	}

	@org.junit.Test
	public void twoTriggersTwo() throws Exception
	{
		final String expected = "2";   //Arrange
		final int sequence = 2;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Two", expected, say); //Assert
	}

	@org.junit.Test
	public void threeTriggersFizz() throws Exception
	{
		final String expected = "Fizz";   //Arrange
		final int sequence = 3;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Fizz", expected, say); //Assert
	}

	@org.junit.Test
	public void sixTriggersFizz() throws Exception
	{
		final String expected = "Fizz";   //Arrange
		final int sequence = 6;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Fizz", expected, say); //Assert
	}

	@org.junit.Test
	public void tenTriggersBuzz() throws Exception
	{
		final String expected = "Buzz";   //Arrange
		final int sequence = 10;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Buzz", expected, say); //Assert
	}

	@org.junit.Test
	public void fiveTriggersBuzz() throws Exception
	{
		final String expected = "Buzz";   //Arrange
		final int sequence = 5;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Buzz", expected, say); //Assert
	}

	@org.junit.Test
	public void nineTriggersFizz() throws Exception
	{
		final String expected = "Fizz";   //Arrange
		final int sequence = 9;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not Fizz", expected, say); //Assert
	}

	@org.junit.Test
	public void fifteenTriggersFizzBuzz() throws Exception
	{
		final String expected = "FizzBuzz";   //Arrange
		final int sequence = 15;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not FizzBuzz.FizzBuzz", expected, say); //Assert
	}


	@org.junit.Test
	public void answersNumberAsString() throws Exception
	{
		final String anyNumber = "11";   //Arrange
		final int sequence = 11;

		String say = FizzBuzz.say(sequence);  //Action

		assertEquals("not eleven", anyNumber, say); //Assert
	}
}
