package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemPickaxe, ItemStack}
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ItemDissembler( mat: Item.ToolMaterial ) extends ItemPickaxe( mat )
                                                       with AEWrench
                                                       with PrecisionHarvester
{
	this.setMaxStackSize( 1 )
	this.setCreativeTab( CreativeTabs.tabTools )
	this.setUnlocalizedName( "appaero.dissembler" )
	this.setTextureName( "appaero:dissembler" )

	/**
	 * harvests block into inventory
	 * returns false to process server side too
	 *
	 * @param stack using item
	 * @param player using player
	 * @param world current world of player
	 * @param x x coord
	 * @param y y coord
	 * @param z z coord
	 * @param side side of interacting block
	 * @param hitX hitbox x
	 * @param hitY hitbox y
	 * @param hitZ hitbox z
	 * @return
	 */
	override def onItemUseFirst( stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float ): Boolean =
	{
		this.instantHarvestBlockIntoInventory( player, world, x, y, z )

		false
	}


	//
	//	override def func_150893_a( p_150893_1_ : ItemStack, p_150893_2_ : Block ): Float =
	//	{
	//		println( "getStrVsBlock" )
	//		1.0F
	//	}

	/**
	 * Sets the mining speed to 5000 without condition
	 *
	 * @param is ItemStack of this
	 * @param b Mining block
	 *
	 * @return 5000
	 */
	override def func_150893_a( is: ItemStack, b: Block ): Float = 5000


	//
	//	override def func_150897_b( p_150897_1_ : Block ): Boolean = true

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
	override def doesSneakBypassUse( world: World, x: Int, y: Int, z: Int, player: EntityPlayer ): Boolean = true
}

