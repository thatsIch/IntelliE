package de.thatsich.minecraft.common.module.gui


import de.thatsich.minecraft.common.string.id.ID
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
trait BlockGuiHandler
{
	def name: ID

	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef
}
