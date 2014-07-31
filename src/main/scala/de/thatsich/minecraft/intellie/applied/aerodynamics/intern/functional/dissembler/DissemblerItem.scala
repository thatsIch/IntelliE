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
class DissemblerItem( mat: Item.ToolMaterial ) extends ItemPickaxe( mat )
                                                       with AEWrench
                                                       with PrecisionHarvester
                                                       with BlockBreakEventHandler
                                                       with AEPowerStorage
{
	this.setMaxStackSize( 1 )
	this.setCreativeTab( CreativeTabs.tabTools )
	this.setMaxDamage( this.steps )
	this.hasSubtypes = false
	this.setUnlocalizedName( "appaero.dissembler" )
	this.setTextureName( "appaero:dissembler" )

	final val maxStorage: Double = 1000000

	final val injectAmount: Double = 10000

	final val steps: Int = 32

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
		this.precisionHarvest( stack, world, player, x, y, z )
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

	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def isDamaged( stack: ItemStack ): Boolean = true

	override def addInformation( itemStack: ItemStack, player: EntityPlayer, information: java.util.List[ _ ], advToolTips: Boolean ) =
	{
		val currentPower = this.getAECurrentPower( itemStack )
		val maxPower = this.getAEMaxPower( itemStack )

		val percent = (currentPower / maxPower * 100).toInt
		// TODO format scala int to whole number without 10^x

		val message = s"Stored Energy: $currentPower AE - $percent%"

		val list = information.asInstanceOf[ java.util.List[ String ] ]
		list.add( message )
	}

	override def getDamage( stack: ItemStack ): Int =
	{
		val percent = this.getAECurrentPower( stack ) / this.getAEMaxPower( stack )
		val damage = this.steps - (this.steps * percent).toInt

		damage
	}
}

