package com.akamon.tdd.fizzBuzz;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches y Juanma Martin
 * Date: 11/01/14
 * Time: 11:05
 * To change this template use ReaderProcessor | Settings | ReaderProcessor Templates.
 */
public class FizzBuzz
{
	private static final int FIZZ_MULTIPLIES = 3;
	private static final int BUZZ_MULTIPLIES = 5;
	private static final int ZERO = 0;
	private static final String EMPTY = "";
	private static final String BUZZ = "Buzz";
	private static final String FIZZ = "Fizz";

	private static String res = EMPTY;

	public static String say(int number)
	{
		return run(number);
	}

	private static String run(int number)
	{
		safeFizz(number);
		safeBuzz(number);
		anyStrings(number);

		return res;
	}

	private static void anyStrings(int number)
	{
		if (res.equals(EMPTY))
			res = String.valueOf(number);
	}

	private static void safeBuzz(int number)
	{
		if (( number % BUZZ_MULTIPLIES ) == ZERO)
			res += BUZZ;
	}

	private static void safeFizz(int number)
	{
		String res = EMPTY;

		if( (number % FIZZ_MULTIPLIES) == ZERO)
			res = FIZZ;

		FizzBuzz.res = res;
	}
}
