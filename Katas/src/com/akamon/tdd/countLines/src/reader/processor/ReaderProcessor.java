package com.akamon.tdd.countLines.src.reader.processor;

import com.akamon.tdd.countLines.api.reader.processor.IReaderProcessor;
import com.akamon.tdd.countLines.src.pattern.Pattern;
import com.akamon.tdd.countLines.src.reader.processor.internal.InternalParser;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches Marin
 * Date: 11/01/14
 * Time: 12:37
 */
public class ReaderProcessor implements IReaderProcessor
{
	private static final int ZERO = 0;
	private InternalParser _internalParser;

	/**
	 * Constructor
	 */
	public ReaderProcessor()
	{
		_internalParser = new InternalParser();
	}

	/**
	 * Metodo que ejecuta el inicio de lectura
	 * @param data  String
	 * @return int
	 */
	public int readLinesExecute(String data)
	{
		return (checkLine(data)) ? ZERO : readLineProcessor(data) ;
	}

	/**
	 * Metodo que procesa la informacion entrante
	 * @param data String
	 * @return int
	 */
	private int readLineProcessor(String data)
	{
		List<String> processorLines = getProcessorLines(data);

		return linesProcessor(processorLines);
	}

	/**
	 * Metodo que procesa el parseado de la informacion entrante
	 * @param linesList List<String>
	 * @return int
	 */
	private int linesProcessor(List<String> linesList)
	{
		return _internalParser.run(linesList);
	}


	/**
	 * Metodo que procesa las lineas.
	 * @param data String
	 * @return List<String>
	 */
	private CopyOnWriteArrayList getProcessorLines(String data)
		{
			return new CopyOnWriteArrayList(data.split(Pattern.SEPARATOR));
	}

	/**
	 * Metodo que verifica que la linea sea adecuada
	 * @param data String
	 * @return boolean
	 */
	private boolean checkLine(String data)
	{
		return (data.equals(Pattern.NULL) || data == null);
	}

	/**
	 * Metodo que imprime la informacion procesada
	 * @return String
	 */
	public String toString()
	{
		return toStringAccept()+"\n"+toStringRejected();
	}

	/**
	 * Metodo que imprime la informacion aceptada
	 * @return String
	 */
	private String toStringAccept()
	{
		return  "Lineas Aceptadas - "+this._internalParser.getLinesAccept().size()+" -\n" + this._internalParser.getLinesAccept().toString();
	}

	/**
	 * Metodo que imprime la informacion descartada
	 * @return
	 */
	private String toStringRejected()
	{
		return "Lineas Ignoradas - "+this._internalParser.getLinesReject().size()+" -\n" + this._internalParser.getLinesReject().toString();
	}
}













