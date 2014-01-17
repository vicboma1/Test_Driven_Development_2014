package com.akamon.tdd.countLines.src.reader;

import com.akamon.tdd.countLines.api.reader.processor.IReaderProcessor;
import com.akamon.tdd.countLines.api.reader.IReader;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches Marin
 * Date: 17/01/14
 * Time: 15:26
 */
public class Reader implements IReader
{
	/**
	 * Procesador de lineas
	 */
	private IReaderProcessor _fileProcessor;

	/**
	 * Constructor
	 */
	public Reader()
	{
	}

	/**
	 * Metodo que inyecta un IReaderProcessor, de esta manera controlamos el control de inversion y desacomplamos dependencias.
	 *
	 * @param fileProcessor IReaderProcessor
	 * @return IReader - la propia clase para poder hacer metodos channeables.
	 */
	public IReader setFileProcessor(IReaderProcessor fileProcessor)
	{
		this._fileProcessor = fileProcessor;
		return this;
	}

	/**
	 * Metodo que lee lineas a través de una String
	 * @param data String
	 * @return int - lineas contadas
	 */
	public int lines(String data)
	{
		return this._fileProcessor.readLinesExecute(data);
	}

	/**
	 * Metodo que lee lineas a través de un StringBuffer
	 * @param data StringBuffer
	 * @return int - lineas contadas
	 */
	public int lines(StringBuffer data)
	{
		return lines(data.toString());
	}

	/**
	 * Metodo que lee lineas a través de un StringBuilder (synchronized)
	 * @param data StringBuilder
	 * @return int - lineas contadas
	 */
	public int lines(StringBuilder data)
	{
		return lines(data.toString());
	}

	/**
	 * Metodo que imprime la informacion parseada
	 * @return
	 */
	public String toString()
	{
		return this._fileProcessor.toString();
	}
}
