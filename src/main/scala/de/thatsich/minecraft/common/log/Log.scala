package de.thatsich.minecraft.common.log

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
trait Log
{
	def info( format: String, data: AnyRef* ): Unit

	def warn( format: String, data: AnyRef* ): Unit

	def debug( format: String, data: AnyRef* ): Unit

	def trace( exception: Throwable ): Unit

	def severe( format: String, data: AnyRef* ): Unit
}
