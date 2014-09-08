package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import de.thatsich.minecraft.common.util.string.StringWrapper


/**
 *
 *
 * @author thatsIch
 * @since 17.08.2014.
 */
object ArmorType extends Enumeration
{
	type ArmorType = Value
	val Helmet = Value(0)
	val Plate = Value(1)
	val Legs = Value(2)
	val Boots = Value(3)

	implicit def armorTypeToInt(armorType: ArmorType): Int = armorType.id
}