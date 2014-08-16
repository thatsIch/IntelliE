package de.thatsich.minecraft.common.log


import de.thatsich.minecraft.common.string.Abbreviation
import org.apache.logging.log4j.{Level, LogManager, Logger}


/**
 * Uses a special name to display the log
 * Cause of readability an abbreviation is enough
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class NamedLog(abbr: Abbreviation) extends Log
{
	private final val target: String = abbr
	private final val logger: Logger = LogManager.getLogger(target)

	/**
	 * Information
	 *
	 * @param message formated String
	 */
	def info(message: String): Unit =
	{
		this.logging(Level.INFO, message)
	}

	/**
	Warning
	  *
	  * @param message formated String
	  */
	def warn(message: String): Unit =
	{
		this.logging(Level.WARN, message)
	}

	/**
	 * Debug output
	 *
	 * @param message formated String
	 */
	def debug(message: String): Unit =
	{
		this.logging(Level.DEBUG, message)
	}

	/**
	 * Default Logging if enabled
	 *
	 * @param level  Logging-Level
	 * @param message log message
	 */
	private def logging(level: Level, message: String): Unit =
	{
		this.logger.log(level, message)
	}

	/**
	 * Used in try catch of exceptions
	 *
	 * @param exception thrown exception
	 */
	def trace(exception: Throwable): Unit =
	{
		val message: String = exception.getMessage
		this.severe(s"Exception: $message")
		exception.printStackTrace()
	}

	/**
	 * Severe Error
	 *
	 * @param message formated String
	 */
	def severe(message: String): Unit =
	{
		this.logging(Level.FATAL, message)
	}
}
