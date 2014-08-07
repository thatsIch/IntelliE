package de.thatsich.minecraft.common.module.registries


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
trait ModuleGuiHandler
{
	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef
}
