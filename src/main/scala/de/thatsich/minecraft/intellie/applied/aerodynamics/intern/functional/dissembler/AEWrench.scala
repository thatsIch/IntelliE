package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import appeng.api.implementations.items.IAEWrench
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 26.07.2014.
 */
trait AEWrench extends IAEWrench
{
	/**
	 * This item can wrench AE parts
	 *
	 * @param wrench itemstack of this item
	 * @param player player who is wrenching
	 * @param x x pos
	 * @param y y pos
	 * @param z z pos
	 *
	 * @return true
	 **/
	def canWrench( wrench: ItemStack, player: EntityPlayer, x: Int, y: Int, z: Int ): Boolean = true
}
