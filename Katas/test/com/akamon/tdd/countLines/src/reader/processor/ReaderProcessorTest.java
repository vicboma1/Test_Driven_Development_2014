package com.akamon.tdd.countLines.src.reader.processor;

import com.akamon.tdd.countLines.api.reader.processor.IReaderProcessor;
import com.akamon.tdd.countLines.src.pattern.Pattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 11/01/14
 * Time: 12:34
 * To change this template use ReaderProcessor | Settings | ReaderProcessor Templates.
 */
public class ReaderProcessorTest
{
	private IReaderProcessor _fileProcessor;

	@Before
	public void initialize() throws Exception
	{
		_fileProcessor =  new ReaderProcessor();
	}

	@Test
	public void readZeroLine() throws Exception
	{
		final String line = "";
		final int expected = 0;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeLine() throws Exception
	{
		final String line = "En un pais de la mancha....\n Hola y adios";
		final int expected = 2;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeDontCountBlankLines() throws Exception
	{
		final String line = "En un pais de la mancha....\n \n Hola y adios";
		final int expected = 2;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithStartComments() throws Exception
	{
		final String line = "En un pais de la mancha....\n \n Hola y adios\n//Comentarios\n";
		final int expected = 2;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithComments() throws Exception
	{
		final String line = "En un pais de la mancha....\n \n Hola y adios\n//Comentarios\ndsdsds //Comentarios";
		final int expected = 3;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndComments() throws Exception
	{
		final String line = "En un pais de la mancha....\n \n Hola y adios\n//Comentarios\n  dsdsds //  Comentarios";
		final int expected = 3;

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsInitBlock() throws Exception
	{
		final int expected = 3;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** ";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsIniEndBlock() throws Exception
	{
		final int expected = 3;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** \n" +
			" holsldslks */";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsIniEndSpaceBlock() throws Exception
	{
		final int expected = 3;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** \n" +
			" holsldslks \n " +
			" */";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsIniEndSpaceBlockAndLineCode() throws Exception
	{
		final int expected = 4;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** \n" +
			" holsldslks \n" +
			" */   Esta linea la debemos de contar";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsIniEndSpaceBlockAndLineCodeComment() throws Exception
	{
		final int expected = 4;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** \n" +
			" holsldslks \n" +
			" */   Esta linea la debemos de contar //Aunque tenga comentario";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void readCodeWithBlankSpaceAndCommentsInitEndSpaceBlockAndLineCodeCommentAndBlockCommentLineal() throws Exception
	{
		final int expected = 4;
		final String line = "En un pais de la mancha...." +
			"\n" +
			" \n" +
			" Hola y adios\n" +
			"//Comentarios\n" +
			"  dsdsds //  Comentarios \n" +
			"/** \n" +
			" holsldslks \n" +
			" */   Esta linea la debemos de contar //Aunque tenga comentario\n" +
			"/** Esta linea no la debe de contar */";

		int res = _fileProcessor.readLinesExecute(line);

		Assert.assertEquals(expected,res);
	}

	@Test
	public void testLinesToStringAccept() throws Exception
	{
		final String expected = "Lineas Aceptadas - 1 -\n" +"[En un pais de la mancha....]\n" + "Lineas Ignoradas - 0 -\n" + "[]";
		final String data = "En un pais de la mancha....";

		this._fileProcessor.readLinesExecute(data.toString());
		String str = this._fileProcessor.toString();

		Assert.assertEquals(str,expected);
	}

	@Test
	public void testLinesToStringReject() throws Exception
	{
		final String expected = "Lineas Aceptadas - 0 -\n" +"[]\n" + "Lineas Ignoradas - 1 -\n" + "[//En un pais de la mancha....]";
		final String data = "//En un pais de la mancha....";

		this._fileProcessor.readLinesExecute(data.toString());
		String str = this._fileProcessor.toString();

		Assert.assertEquals(str,expected);
	}

	@Test
	public void testLinesToStringAcceptAndReject() throws Exception
	{
		final String expected = "Lineas Aceptadas - 2 -\n" +"[En un pais de la mancha...., Hola y adios]\n" + "Lineas Ignoradas - 1 -\n" + "[//Comentario]";

		StringBuffer data = new StringBuffer();
		data.append("En un pais de la mancha....");
		data.append(Pattern.SEPARATOR);
		data.append("Hola y adios");
		data.append(Pattern.SEPARATOR);
		data.append("//Comentario");

		this._fileProcessor.readLinesExecute(data.toString());
		String str = this._fileProcessor.toString();

		Assert.assertEquals(str,expected);
	}
}
