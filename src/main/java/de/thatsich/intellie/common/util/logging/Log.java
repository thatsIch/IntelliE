package de.thatsich.intellie.common.util.logging;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import org.apache.logging.log4j.Level;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 Log Class
 */
@Singleton
public class Log implements ILog
{
	private final String name;

	/**
	 Constructor either only be injected or tested
	 thus package private
	 */
	public Log( String name )
	{
		this.name = name;
	}

	/**
	 Dagger CTOR
	 */
	@Inject
	Log() { this.name = ""; }

	/**
	 Information

	 @param format formated String
	 @param data   Input into formated String
	 */
	@Override
	public void info( String format, Object... data )
	{
		this.logging( Level.INFO, format, data );
	}

	/**
	 Warning

	 @param format formated String
	 @param data   Input into formated String
	 */
	@Override
	public void warn( String format, Object... data )
	{
		this.logging( Level.WARN, format, data );
	}

	/**
	 Debug output

	 @param format formated String
	 @param data   Input into formated String
	 */
	@Override
	public void debug( String format, Object... data )
	{
		this.logging( Level.DEBUG, format, data );
	}

	/**
	 Used in try catch of exceptions

	 @param exception thrown exception
	 */
	@Override
	public void trace( Throwable exception )
	{
		final String message = exception.getMessage();
		this.severe( "Exception: %s", message );
		exception.printStackTrace();
	}

	/**
	 Severe Error

	 @param format formated String
	 @param data   Input into formated String
	 */
	@Override
	public void severe( String format, Object... data )
	{
		this.logging( Level.FATAL, format, data );
	}

	/**
	 Default Logging if enabled

	 @param level  Logging-Level
	 @param format formated String
	 @param data   Input into formated String
	 */
	private void logging( Level level, String format, Object... data )
	{
		FMLRelaunchLog.log( this.name, level, format, data );
	}
}
