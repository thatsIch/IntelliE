package de.thatsich.minecraft.common.util.nbt


import scala.language.implicitConversions


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait BoundNBTProperty[T]
{
	def min: T

	def max: T

	def scale: T

	override def toString: String = this.getClass.getSimpleName.split("\\$").last.toLowerCase
}