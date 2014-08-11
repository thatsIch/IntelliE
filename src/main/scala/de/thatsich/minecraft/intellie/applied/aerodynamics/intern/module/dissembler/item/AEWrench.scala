package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import appeng.api.implementations.items.IAEWrench
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 26.07.2014.
 */
private[dissembler] trait AEWrench extends Item
                                           with IAEWrench
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
	def canWrench(wrench: ItemStack, player: EntityPlayer, x: Int, y: Int, z: Int): Boolean = true

	/**
	 * Does not activate blocks when sneaking
	 *
	 * @param world current world
	 * @param x x pos
	 * @param y y pos
	 * @param z z pos
	 * @param player sneaking player
	 *
	 * @return true
	 */
	override def doesSneakBypassUse(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean = true

}
