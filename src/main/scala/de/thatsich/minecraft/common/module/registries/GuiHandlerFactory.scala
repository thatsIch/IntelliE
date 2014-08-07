package de.thatsich.minecraft.common.module.registries


import cpw.mods.fml.common.network.IGuiHandler


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
trait GuiHandlerFactory
{
	def get(): IGuiHandler
}
