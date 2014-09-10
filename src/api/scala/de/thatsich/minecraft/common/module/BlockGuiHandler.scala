package de.thatsich.minecraft.common.module

import de.thatsich.minecraft.common.util.string.ID
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
