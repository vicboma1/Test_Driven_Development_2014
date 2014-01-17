package com.akamon.tdd.countLines.src.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 17/01/14
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class LineMapperTest
{
	private LineMapper _lineMapper;

	@Before
	public void initialize() throws Exception
	{
		_lineMapper = new LineMapper();
	}

	@Test
	public void testSetLinesAccept() throws Exception
	{
		final String excepted = "Probando";
		final Integer index = 1;

		String res = this._lineMapper.setLinesAccept(index,"Probando");
		Assert.assertNull(res);
		res = this._lineMapper.setLinesAccept(index,"NuevoInput");
		Assert.assertEquals(res, excepted);

	}

	@Test
	public void testSetLinesRejected() throws Exception
	{
		final String excepted = "//Probando";
		final Integer index = 1;

		String res = this._lineMapper.setLinesRejected(index,"//Probando");
		Assert.assertNull(res);
		res = this._lineMapper.setLinesRejected(index,"NuevoInput");
		Assert.assertEquals(res,excepted);
	}

	@Test
	public void testGetValuesAccept() throws Exception
	{
		final String excepted = "[test]";
		final Integer index = 1;

		this._lineMapper.setLinesAccept(index,"test");
		Collection<String> res = this._lineMapper.getValuesAccept();
		Assert.assertEquals(excepted, res.toString());
	}

	@Test
	public void testGetValuesReject() throws Exception
	{
		final String excepted = "[//test]";
		final Integer index = 1;

		this._lineMapper.setLinesRejected(index, "//test");
		Collection<String> res = this._lineMapper.getValuesReject();
		Assert.assertEquals(excepted, res.toString());
	}


	@Test
	public void testSizeLinesRejected() throws Exception
	{
		final Integer expected = 1;
		final Integer index = 1;

		this._lineMapper.setLinesRejected(index,"//test");
		this._lineMapper.getValuesReject();
		Integer res = this._lineMapper.sizeLinesRejected();
		Assert.assertEquals(expected,res);
	}
}
