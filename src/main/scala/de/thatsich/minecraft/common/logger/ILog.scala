package de.thatsich.minecraft.common.logger

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
trait ILog
{
	def info(format: String, data: AnyRef*)

	def warn(format: String, data: AnyRef*)

	def debug(format: String, data: AnyRef*)

	def trace(exception: Throwable)

	def severe(format: String, data: AnyRef*)
}
