package de.thatsich.minecraft.common.util.nbt


import scala.language.implicitConversions


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait BoundNBTProperty
{
	def min: Double

	def max: Double
}

object BoundNBTProperty
{
	implicit def propertyToString(prop: BoundNBTProperty): String = prop.getClass.getSimpleName.split("\\$").last.toLowerCase
}