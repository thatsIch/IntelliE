package de.thatsich.common.util.logging;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
public interface ILog
{
	void info ( String format, Object... data );

	void warn ( String format, Object... data );

	void debug ( String format, Object... data );

	void trace ( Throwable exception );

	void severe ( String format, Object... data );
}
