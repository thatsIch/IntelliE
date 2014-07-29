package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
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
                                                       with ListensToMouse
{
	this.setMaxStackSize( 1 )
	this.setCreativeTab( CreativeTabs.tabTools )
	this.setUnlocalizedName( "appaero.dissembler" )
	this.setTextureName( "appaero:dissembler" )

	var useItem = false

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
		if( world.isRemote && this.notInUse )
		{
			this.instantHarvestBlockIntoInventory( player, world, x, y, z )
			this.notInUse = false
			this.useItem = true
		}
		else if( !world.isRemote && this.useItem )
		{
			this.instantHarvestBlockIntoInventory( player, world, x, y, z )
			this.useItem = false
		}

		false
	}

	/**
	 * Try to intercept the mining and collect the dropped item here
	 *
	 * @param is used itemstack
	 * @param world world where item will be spawned
	 * @param block mined block
	 * @param x x pos of block
	 * @param y y pos of block
	 * @param z z pos of block
	 * @param entity dropped entity
	 *
	 * @return true if block is destroyed
	 */
	override def onBlockDestroyed( is: ItemStack, world: World, block: Block, x: Int, y: Int, z: Int, entity: EntityLivingBase ): Boolean =
	{
		val player: EntityPlayer = entity.asInstanceOf[ EntityPlayer ]

		//		this.instantHarvestBlockIntoInventory(player, world, x,y,z)
		//		println(entity.getClass)
		super.onBlockDestroyed( is, world, block, x, y, z, entity )

		true
	}

	//
	//
	//	override def onPlayerStoppedUsing( is: ItemStack, world: World, player: EntityPlayer, itemInUseCount: Int ): Unit =
	//	{
	//		println( "STOPPPED" )
	//
	//		super.onPlayerStoppedUsing( is, world, player, itemInUseCount )
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

