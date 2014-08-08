package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[dissembler] trait NBTAccess
{
	def getNBTData(itemStack: ItemStack): NBTTagCompound =
	{
		var compound = itemStack.getTagCompound
		if (compound == null)
		{
			compound = new NBTTagCompound
			itemStack.setTagCompound(compound)
		}

		compound
	}
}
