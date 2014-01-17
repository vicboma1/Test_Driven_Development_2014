package com.akamon.tdd.countLines.src.utils;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches Marin
 * Date: 17/01/14
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class LineMapper
{
	private Map<Integer, String> _mapLinesAccept;
	private Map<Integer, String> _mapLinesRejected;

	/**
	 * Constructor
	 */
	public LineMapper()
	{
		_mapLinesAccept   = new ConcurrentSkipListMap();
		_mapLinesRejected = new ConcurrentSkipListMap();
	}

	/**
	 * Metodo que devuelve los datos aceptados
	 * @return
	 */
	public Collection<String> getValuesAccept()
	{
		return this._mapLinesAccept.values();
	}

	/**
	 * Metodo que devuelve los datos rechazados
	 * @return
	 */
	public Collection<String> getValuesReject()
	{
		return this._mapLinesRejected.values();
	}

	/**
	 * Metodo que sete las lineas correctas
	 * @param key
	 * @param value
	 * @return String
	 */
	public String setLinesAccept(Integer key, String value)
	{
		return this._mapLinesAccept.put(key, value);
	}

	/**
	 * Metodo que setea las lineas incorrectas
	 * @param key
	 * @param value
	 * @return String
	 */
	public String setLinesRejected(Integer key, String value)
	{
		return this._mapLinesRejected.put(key,value);
	}

	/**
	 * Metodo que devuelve el numero de lineas erroneas
	 * @return
	 */
	public int sizeLinesRejected()
	{
		return this._mapLinesRejected.size();
	}
}
