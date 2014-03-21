package de.thatsich.common.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.Side;
import org.apache.logging.log4j.Level;

import javax.inject.Inject;

/**
 * Logger Class
 */
public class Logger implements ILog
{
	private static final char COLON = ':';
	private final String name;

	/**
	 * Constructor either only be injected or tested
	 * thus package private
	 */
	@Inject
	Logger ()
	{
		this.name = "IE";
	}

	/**
	 * Information
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	@Override
	public void info ( String format, Object... data )
	{
		this.logging( Level.INFO, format, data );
	}

	/**
	 * Warning
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	@Override
	public void warn ( String format, Object... data )
	{
		this.logging( Level.WARN, format, data );
	}

	/**
	 * Debug output
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	@Override
	public void debug ( String format, Object... data )
	{
		this.logging( Level.DEBUG, format, data );
	}

	/**
	 * Used in try catch of exceptions
	 *
	 * @param exception thrown exception
	 */
	@Override
	public void trace ( Throwable exception )
	{
		final String message = exception.getMessage();
		this.severe( "Exception: %s", message );
		exception.printStackTrace();
	}

	/**
	 * Severe Error
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	@Override
	public void severe ( String format, Object... data )
	{
		this.logging( Level.FATAL, format, data );
	}

	/**
	 * Default Logging if enabled
	 *
	 * @param level  Logging-Level
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	private void logging ( Level level, String format, Object... data )
	{
		final FMLCommonHandler instance = FMLCommonHandler.instance();
		final Side effectiveSide = instance.getEffectiveSide();
		final boolean isClient = effectiveSide.isClient();
		final String side = isClient ? "C" : "S";

		FMLRelaunchLog.log( this.name + Logger.COLON + side, level, format, data );
	}
}
