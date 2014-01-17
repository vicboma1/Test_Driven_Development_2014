package com.akamon.tdd.countLines.src.reader.processor.internal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 17/01/14
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class InternalParserTest
{
	private InternalParser _internalParser;

	@Before
	public void initialize() throws Exception
	{
		this._internalParser = new InternalParser();
	}

	@Test
	public void testRun() throws Exception
	{
		final int excepted = 2;
		final List<String> line =  Arrays.asList("Hola", "Probando");

		int res = this._internalParser.run(line);

		Assert.assertEquals(excepted, res);
	}

	@Test
	public void testGetLinesAccept() throws Exception
	{
		final List<String> exceptedline =  Arrays.asList("Hola", "Probando");

		this._internalParser.run(exceptedline);
		Collection<String> res = this._internalParser.getLinesAccept();

		Assert.assertEquals(exceptedline.toString() , res.toString());
	}

	@Test
	public void testGetLinesReject() throws Exception
	{
		final List<String> exceptedline =  Arrays.asList("//Hola", "//Probando");

		this._internalParser.run(exceptedline);
		Collection<String> res = this._internalParser.getLinesReject();

		Assert.assertEquals(exceptedline.toString() , res.toString());
	}


}
