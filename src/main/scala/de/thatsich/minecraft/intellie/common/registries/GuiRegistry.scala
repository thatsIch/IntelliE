package de.thatsich.minecraft.intellie.common.registries

import cpw.mods.fml.common.network.{NetworkRegistry, IGuiHandler}
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import de.thatsich.minecraft.intellie.common.ABaseMod

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class GuiRegistry
	extends IGuiHandler
{
	def init(instance: ABaseMod)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, this)
	}

	def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Object =
	{
		null
	}

	def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Object =
	{
		null
	}
}
