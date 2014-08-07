package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
class AeroGuiHandler extends IGuiHandler
{
	def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
	}

	def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef =
	{
	}
}
