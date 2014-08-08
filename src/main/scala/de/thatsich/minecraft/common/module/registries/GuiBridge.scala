package de.thatsich.minecraft.common.module.registries


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.log.Log
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
class GuiBridge(table: util.Hashtable[Int, BlockGuiHandler], log: Log) extends IGuiHandler
{
	def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
		if (this.table.containsKey(ID))
		{
			this.table.get(ID).getServerGuiElement(player, world.getTileEntity(x, y, z))
		}
		else
		{
			val keySet: util.Set[Int] = this.table.keySet()
			this.log.warn(s"Tried to access GUI with ID $ID but is not part of $keySet")
			null
		}
	}

	def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
		if (this.table.containsKey(ID))
		{
			this.table.get(ID).getClientGuiElement(player, world.getTileEntity(x, y, z))
		}
		else
		{
			this.log.warn(s"Tried to access GUI with ID $ID")
			null
		}
	}
}
