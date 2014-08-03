package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.block.Block
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class DissemblerItem extends Item
                             with AEWrench
                             with PrecisionHarvester
                             with BlockBreakEventHandler
                             with AEPowerStorage
{
	this.setMaxStackSize( 1 )
	this.hasSubtypes = false
	this.setMaxDamage( 32 )
	this.setUnlocalizedName( "dissembler" )
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
		if( this.getAECurrentPower( stack ) > this.energyPerBlockBreak )
		{
			this.precisionHarvest( stack, world, player, x, y, z )
		} else
		{
			true
		}
	}

	override def onEntitySwing( entityLiving: EntityLivingBase, stack: ItemStack ): Boolean =
	{
		if( this.getAECurrentPower( stack ) > this.energyPerBlockBreak )
		{
			this.extractAEPower( stack, this.energyPerBlockBreak )
			false
		}
		else
		{
			true
		}
	}


	override def onItemRightClick( is: ItemStack, world: World, player: EntityPlayer ): ItemStack =
	{
		if( !world.isRemote )
		{
			player.openGui( AppliedAerodynamics.id, 0, world, player.posX.toInt, player.posY.toInt, player.posZ.toInt )
		}

		is
	}

	/**
	 * Sets the mining speed to 5000 per default, configureable
	 *
	 * @param is ItemStack of this
	 * @param b Mining block
	 *
	 * @return configured mining speed (5000 default)
	 */
	override def func_150893_a( is: ItemStack, b: Block ): Float =
	{
		if( this.getAECurrentPower( is ) > this.energyPerBlockBreak ) this.miningSpeed else 0
	}

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
		val roundCurrent = currentPower.toInt
		val maxPower = this.getAEMaxPower( itemStack )

		val percent = (currentPower / maxPower * 100).toInt
		// TODO format scala int to whole number without 10^x

		val message = s"Stored Energy: $roundCurrent AE - $percent%"

		val list = information.asInstanceOf[ java.util.List[ String ] ]
		list.add( message )
	}

	/**
	 * Can harvest block?
	 *
	 * @param block block to be harvested
	 *
	 * @return true if you can harvest the block
	 */
	override def func_150897_b( block: Block ): Boolean = true

	override def getDurabilityForDisplay( stack: ItemStack ): Double =
	{
		1 - this.getAECurrentPower( stack ) / this.getAEMaxPower( stack )
	}

	override def isBookEnchantable( stack: ItemStack, book: ItemStack ): Boolean = false
}

