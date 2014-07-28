package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item.ToolMaterial
import net.minecraft.item.{ItemPickaxe, ItemStack}
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ItemDissembler( mat: ToolMaterial ) extends ItemPickaxe( mat )
                                                  with AEWrench
                                                  with PrecisionHarvester
{
	this.setMaxStackSize( 1 )
	this.setCreativeTab( CreativeTabs.tabTools )
	this.setUnlocalizedName( "AppliedAerodynamics.ItemDissembler" )
	this.setTextureName( "AppliedAerodynamics:ItemDissembler" )


	override def onItemUseFirst( stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float ): Boolean =
	{
		println( "onItemUseFirst" )

		false
		//		this.instantHarvestBlockIntoInventory( player, world, x, y, z )
	}


	//
	//	override def func_150893_a( p_150893_1_ : ItemStack, p_150893_2_ : Block ): Float =
	//	{
	//		println( "func_150893_a" )
	//		1.0F
	//	}
	//
	//	override def func_150897_b( block: Block ): Boolean =
	//	{
	////		val world: World = block.
	////		block.harvestBlock()
	//		println( "func_150897_b" )
	//		false
	//	}
	//
	//	override def onUsingTick( stack: ItemStack, player: EntityPlayer, count: Int ): Unit = {
	//		println( "onUsingTick" )
	//	}

	override def onItemUse( is: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, i1: Int, f1: Float, f2: Float, f3: Float ): Boolean =
	{
		println( "onItemUse" )

		this.instantHarvestBlockIntoInventory( player, world, x, y, z )
	}

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

