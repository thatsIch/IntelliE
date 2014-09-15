package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy


import net.minecraft.item.{ItemStack, Item}


/**
 * 
 *
 * @author thatsIch
 * @since 15.09.2014.
 */
trait NBTItemRegistry
{
	def items: Seq[Item]

	def itemstacks: Seq[ItemStack]
}