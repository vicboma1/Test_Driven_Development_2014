package com.akamon.tdd.countLines.src.reader.processor.internal;

import com.akamon.tdd.countLines.src.pattern.Pattern;
import com.akamon.tdd.countLines.src.utils.LineMapper;

import java.util.*;

/**
 * Clase interna que parsea los datos entrantes con Safe Thread + Synchronized
 */
public class InternalParser
{
	private LineMapper _lineMapper;

	/**
	 * Constructor
	 */
	public InternalParser()
	{
		_lineMapper = new LineMapper();
	}

	/**
	 * Metodo que devuelve la informacion aceptada
	 * @return
	 */
	public Collection<String> getLinesAccept()
	{
		return _lineMapper.getValuesAccept();
	}

	/**
	 * Metodo que devuelve la informacion rechazada
	 * @return
	 */
	public Collection<String> getLinesReject()
	{
		return _lineMapper.getValuesReject();
	}

	/**
	 * Metodo que procesa el parseado de tokens que tiene la input data
	 *
	 * @param linesList List<String>
	 * @return numero de lineas totales
	 */
	public int run(List<String> linesList)
	{
		boolean blockComment = false;
		final int sizeProcessorLine = getLengthProcessorLines(linesList);

		for (Integer i = 0; i < sizeProcessorLine; i++)
		{
			String actualLine = linesList.get(i);
			blockComment = internalRun(blockComment, i, actualLine);
		}

		return (sizeProcessorLine - _lineMapper.sizeLinesRejected());
	}

	/**
	 * Metodo que ejecuta el parsedor de datos
	 * @param blockComment
	 * @param i
	 * @param actualLine
	 * @return
	 */
	private boolean internalRun(Boolean blockComment, Integer i, String actualLine)
	{
		if (actualLine.contentEquals(Pattern.SPACE) || actualLine.contentEquals(Pattern.NULL))
		{
			_lineMapper.setLinesRejected(i, actualLine);
		}
		else if (actualLine.startsWith(Pattern.COMMENTS))
		{
			_lineMapper.setLinesRejected(i, actualLine);
		}
		else if (actualLine.startsWith(Pattern.COMMENTS_END_BLOCK) && blockComment)
		{
			blockComment = CommentsEndBlock(i, actualLine);
		}
		else if (blockComment)
		{
			_lineMapper.setLinesRejected(i, actualLine);
		}
		else if (actualLine.startsWith(Pattern.COMMENTS_INIT_BLOCK))
		{
			blockComment = commentsInitBlock(blockComment, i, actualLine);
		}
		else
			_lineMapper.setLinesAccept(i, actualLine);

		return blockComment;
	}

	/**
	 * Metodo que parsea el inicio de un bloque con comentarios
	 * @param blockComment
	 * @param i
	 * @param actualLine
	 * @return
	 */
	private boolean commentsInitBlock(Boolean blockComment, Integer i, String actualLine)
	{
		if (actualLine.split(Pattern.SPACE).length <= 1)
		{
			_lineMapper.setLinesRejected(i, actualLine);
			blockComment = true;
		}

		if (actualLine.contains(Pattern.COMMENTS_END_BLOCK))
		{
			blockComment = false;
			_lineMapper.setLinesRejected(i, actualLine);
		}

		return blockComment;
	}

	/**
	 * Metodo que parsea los finales de los comentarios en bloque
	 * @param i
	 * @param actualLine
	 * @return
	 */
	private boolean CommentsEndBlock(Integer i, String actualLine)
	{
		final boolean blockComment = false;

		if (actualLine.split(Pattern.SPACE).length <= 1)
		{
			_lineMapper.setLinesRejected(i, actualLine);
		}
		else _lineMapper.setLinesAccept(i, actualLine);

		return blockComment;
	}

	/**
	 * Metodo que devuelve el numero de lineas a procesar
	 * @param processorLines int
	 * @return
	 */
	private int getLengthProcessorLines(List<String> processorLines)
	{
		return processorLines.size();
	}
}
