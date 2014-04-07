package de.thatsich.minecraft.intellie.common

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
/**
@author thatsIch
@since 02.04.2014. */
abstract class AID
{
	private final val id: String = this.getClass.getSimpleName.toLowerCase

	override def toString: String =
	{
		this.id
	}
}