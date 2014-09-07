package de.thatsich.minecraft.intellie.applied.aerodynamics.common

import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.IBlockAccess


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait Definition
{
	/**
		 * @return the {@link Block} Implementation if applicable
		 */
	def block: Option[Block]

	/**
		 * @return the {@link Item} Implementation if applicable
		 */
	def item: Option[Item]

	/**
		 * @return the {@link TileEntity} Class if applicable.
		 */
	def entity: Option[Class[_ <: TileEntity]]

	/**
		 * @return an {@link ItemStack} with specified quantity of this item.
		 */
	def stack(stackSize: Int): Option[ItemStack]

	/**
		 * Compare {@link ItemStack} with this {@link AEItemDefinition}
		 *
		 * @param comparableItem
		 * @return true if the item stack is a matching item.
		 */
	def sameAsStack(comparableItem: ItemStack): Boolean

	/**
		 * Compare Block with world.
		 *
		 * @param world
		 * @param x
		 * @param y
		 * @param z
		 *
		 * @return if the block is placed in the world at the specific location.
		 */
	def sameAsBlock(world: IBlockAccess, x: Int, y: Int, z: Int): Boolean
}
