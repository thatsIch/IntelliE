package de.thatsich.intellie.common.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import org.apache.logging.log4j.Level;

//@Singleton
public class IELog
{
	private static void log ( Level level, String format, Object... data )
	{
		final boolean isClient = FMLCommonHandler.instance().getEffectiveSide().isClient();
		final boolean loggingEnabled = true; // TODO shift to config and inject
		final boolean configExists = true; // TODO shift to config
		final String side = ( isClient ) ? "C" : "S";

		if ( configExists && loggingEnabled )
		{
			FMLRelaunchLog.log( "IE:" + side, level, format, data );
		}
	}

	public void info ( String format, Object... data )
	{
		IELog.log( Level.INFO, format, data );
	}

	public void warn ( String format, Object... data )
	{
		IELog.log( Level.WARN, format, data );
	}

	public void debug ( String format, Object... data )
	{
		IELog.log( Level.DEBUG, format, data );
	}

	public void severe ( String format, Object... data )
	{
		IELog.log( Level.FATAL, format, data );
	}

	public void trace ( Throwable exception ) {
		this.severe( "Exception: " + exception.getMessage(), new Object[0] );
		exception.printStackTrace();
	}
}
