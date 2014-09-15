package de.thatsich.minecraft.common.proxy.module.util


import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
trait NBTAccess
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
