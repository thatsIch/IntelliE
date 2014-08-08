package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container


/**
 *
 *
 * @author thatsIch
 * @since 02.08.2014.
 */
class DissemblerContainer extends Container
{
	def canInteractWith(player: EntityPlayer): Boolean = true
}
