package de.thatsich.minecraft.core.module.item

import net.minecraft.item.{ItemStack, ItemBlock}
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait IItemBlock extends IItem
{
	/**
	Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
	  */
	@Override def setUnlocalizedName(name: Nothing): ItemBlock

	@SideOnly(Side.CLIENT) def func_150936_a(p_150936_1_ : World, p_150936_2_ : Int, p_150936_3_ : Int, p_150936_4_ : Int, p_150936_5_ : Int, p_150936_6_ : EntityPlayer, p_150936_7_ : ItemStack): Boolean

	/**
	Called to actually place the block, after the location is determined
	 and all permission checks have been made.

	 @param stack  The item stack that was used to place the block. This can be changed inside the method.
	@param player The player who is placing the block. Can be null if the block is not being placed by a player.
	@param side   The side the player (or machine) right-clicked on.
	  */
	def placeBlockAt(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float, metadata: Int): Boolean
}
