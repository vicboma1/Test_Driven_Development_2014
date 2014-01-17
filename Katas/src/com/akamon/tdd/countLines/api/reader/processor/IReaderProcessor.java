package com.akamon.tdd.countLines.api.reader.processor;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 17/01/14
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public interface IReaderProcessor
{
	/**
	 * Metodo que ejecuta el inicio de lectura
	 * @param data
	 * @return lineas contadas
	 */
	int readLinesExecute(String data);

	/**
	 * Metodo que imprime la informacion parseada
	 * @return
	 */
	String toString();
}
