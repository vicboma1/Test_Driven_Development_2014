package com.akamon.tdd.countLines.src.reader;

import com.akamon.tdd.countLines.api.reader.IReader;
import com.akamon.tdd.countLines.src.pattern.Pattern;
import com.akamon.tdd.countLines.src.reader.processor.ReaderProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 17/01/14
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class ReaderTest
{
	private IReader _reader;

	@Before
	public void initialize() throws Exception
	{
		_reader = new Reader()
						.setFileProcessor(new ReaderProcessor());
	}

	@Test
	public void testLinesString() throws Exception
	{
		final String data = "En un pais de la mancha....";
		final int expected = 1;

		int res = _reader.lines(data);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void testLinesToStringAccept() throws Exception
	{
		final String mockLine = "Lineas Aceptadas - 1 -\n" +"[En un pais de la mancha....]\n" + "Lineas Ignoradas - 0 -\n" + "[]";
		final String data = "En un pais de la mancha....";

		this._reader.lines(data);
		String str = this._reader.toString();

		Assert.assertEquals(str, mockLine);
	}

	@Test
	public void testLinesToStringReject() throws Exception
	{
		final String mockLine = "Lineas Aceptadas - 0 -\n" +"[]\n" + "Lineas Ignoradas - 1 -\n" + "[//En un pais de la mancha....]";
		final String data = "//En un pais de la mancha....";

		this._reader.lines(data);
		String str = this._reader.toString();

		Assert.assertEquals(str,mockLine);
	}

	@Test
	public void testLinesToStringAcceptAndReject() throws Exception
	{
		final String mockLine = "Lineas Aceptadas - 2 -\n" +"[En un pais de la mancha...., Hola y adios]\n" + "Lineas Ignoradas - 1 -\n" + "[//Comentario]";

		StringBuffer data = new StringBuffer();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");
		data.append(Pattern.SEPARATOR);
		data.append("//Comentario");

		this._reader.lines(data);
		String str = this._reader.toString();

		Assert.assertEquals(str,mockLine);
	}

	@Test
	public void testLinesBuffer() throws Exception
	{
		final int expected = 2;

		StringBuffer data = new StringBuffer();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");

		int res = _reader.lines(data);

		Assert.assertEquals(expected, res);

	}

	@Test
	public void testLinesBuilder() throws Exception
	{
		final int expected = 2;

		StringBuilder data = new StringBuilder();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");

		int res = _reader.lines(data);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeDontCountBlankLineWithAppendLines() throws Exception
	{
		final int expected = 2;

		StringBuffer data = new StringBuffer();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");

		int res = _reader.lines(data); //"En un pais de la mancha....\n\nHola y adios"

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsWithAppendLines() throws Exception
	{
		final int expected = 3;

		StringBuffer data = new StringBuffer();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append(Pattern.SPACE);
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");
		data.append(Pattern.SEPARATOR);
		data.append(" dsdsds //  Comentarios");

		int res = _reader.lines(data);

		Assert.assertEquals(expected,res);
	}

}
