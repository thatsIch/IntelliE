package de.thatsich.minecraft.common.log


/**
 * Logger interface with basic methods
 * to not use all kinds of log level
 * but with logical needs
 * - info basic information
 * - warn when something is happening which is not bad but not good either
 * - debug additional information needed when debugging
 * - trace for exceptions
 * - severe when something is not supposed to happen at all
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
trait Log
{
	def info(format: String): Unit

	def warn(format: String): Unit

	def debug(format: String): Unit

	def trace(exception: Throwable): Unit

	def severe(format: String): Unit
}
