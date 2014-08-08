package de.thatsich.minecraft.common.module.registries


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
class GuiBridge(table: util.Hashtable[Int, BlockGuiHandler]) extends IGuiHandler
{
	def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
		if (this.table.contains(ID))
		{
			this.table.get(ID).getServerGuiElement(player, world.getTileEntity(x, y, z))
		}
		else
		{
			null
		}
	}

	def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
		if (this.table.contains(ID))
		{
			this.table.get(ID).getClientGuiElement(player, world.getTileEntity(x, y, z))
		}
		else
		{
			null
		}
	}
}
