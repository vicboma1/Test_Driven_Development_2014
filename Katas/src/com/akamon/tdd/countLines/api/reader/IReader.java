package com.akamon.tdd.countLines.api.reader;

import com.akamon.tdd.countLines.api.reader.processor.IReaderProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 11/01/14
 * Time: 12:37
 * To change this template use ReaderProcessor | Settings | ReaderProcessor Templates.
 */
public interface IReader
{
	/**
	 * Metodo que lee lineas a través de una String
	 * @param data
	 * @return lineas contadas
	 */
	int lines(String data);

	/**
	 * Metodo que lee lineas a través de un StringBuffer
	 * @param data
	 * @return
	 */
	int lines(StringBuffer data);

	/**
	 * Metodo que lee lineas a través de un StringBuilder
	 * @param data
	 * @return
	 */
	int lines(StringBuilder data);

	/**
	 * Metodo que inyecta un IReaderProcessor
	 *
	 * @param fileProcessor
	 * @return la propia clase para poder hacer metodos channeables
	 */
	 IReader setFileProcessor(IReaderProcessor fileProcessor);

	/**
	 * Metodo que imprime la informacion parseada
	 * @return
	 */
	String toString();
}
