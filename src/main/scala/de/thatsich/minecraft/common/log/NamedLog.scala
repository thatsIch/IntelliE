package de.thatsich.minecraft.common.log

import de.thatsich.minecraft.common.string.Abbreviation
import org.apache.logging.log4j.{Level, LogManager}

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class NamedLog( abbr: Abbreviation ) extends Log
{
	/**
	 * Information
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	def info( format: String, data: AnyRef* ): Unit =
	{
		this.logging( Level.INFO, format, data )
	}

	/**
	 * Default Logging if enabled
	 *
	 * @param level  Logging-Level
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	private def logging( level: Level, format: String, data: AnyRef* ): Unit =
	{
		this.log( this.abbr, level, format, data )
	}

	private def log( targetLog: String, level: Level, format: String, data: AnyRef* ): Unit =
	{
		LogManager.getLogger( targetLog ).log( level, format.format( data ) )
	}

	/**
	Warning
	  *
	  * @param format formated String
	  * @param data   Input into formated String
	  */
	def warn( format: String, data: AnyRef* ): Unit =
	{
		this.logging( Level.WARN, format, data )
	}

	/**
	 * Debug output
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	def debug( format: String, data: AnyRef* ): Unit =
	{
		this.logging( Level.DEBUG, format, data )
	}

	/**
	 * Used in try catch of exceptions
	 *
	 * @param exception thrown exception
	 */
	def trace( exception: Throwable ): Unit =
	{
		val message: String = exception.getMessage
		this.severe( "Exception: %s", message )
		exception.printStackTrace( )
	}

	/**
	 * Severe Error
	 *
	 * @param format formated String
	 * @param data   Input into formated String
	 */
	def severe( format: String, data: AnyRef* ): Unit =
	{
		this.logging( Level.FATAL, format, data )
	}
}
