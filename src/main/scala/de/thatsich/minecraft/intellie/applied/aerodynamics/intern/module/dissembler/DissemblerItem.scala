package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package module
package dissembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item.{AEPowerStorage, AEWrench, BlockBreakEventHandler, MiningTool, PrecisionHarvester, Weapon}
import net.minecraft.block.Block
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class DissemblerItem(modid: ID, name: ID, log: Log) extends BaseItem(modid, name, log)
                                                            with AEWrench
                                                            with PrecisionHarvester
                                                            with BlockBreakEventHandler
                                                            with AEPowerStorage
                                                            with Weapon
                                                            with MiningTool
{
	this.setMaxStackSize(1)
	this.hasSubtypes = false
	this.setMaxDamage(32)
//	this.setUnlocalizedName("appaero.dissembler")
//	this.setTextureName("appaero:dissembler")

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
	 * @return true to stop further processing
	 */
	override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean =
	{
		if (this.getAECurrentPower(stack) > this.getCurrentEnergyPerBlockBreak(stack))
		{
			this.precisionHarvest(stack, world, player, x, y, z)
		}
		else
		{
			true
		}
	}

	/**
	 * When player.swingItem is executed
	 *
	 * @param elb swinging entity
	 * @param stack with item
	 * @return true to cancel further processing
	 */
	override def onEntitySwing(elb: EntityLivingBase, stack: ItemStack): Boolean =
	{
		val energyPerBlockBreak: Double = this.getCurrentEnergyPerBlockBreak(stack)

		if (this.getAECurrentPower(stack) > energyPerBlockBreak && elb.isClientWorld)
		{
			if (!this.inUse)
			{
				this.extractAEPower(stack, energyPerBlockBreak)
			}

			this.inUse
		}
		else
		{
			true
		}
	}

	/**
	 * Sets the mining speed to 5000 per default, configureable
	 *
	 * @param is ItemStack of this
	 * @param b Mining block
	 *
	 * @return configured mining speed (5000 default)
	 */
	override def func_150893_a(is: ItemStack, b: Block): Float =
	{
		if (this.getAECurrentPower(is) > this.getCurrentEnergyPerBlockBreak(is))
		{
			this.getCurrentMiningLevel(is)
		}
		else
		{
			0
		}
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
	override def doesSneakBypassUse(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean = true

	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def isDamaged(stack: ItemStack): Boolean = true

	override def addInformation(itemStack: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(itemStack)
		val roundCurrent = currentPower.toInt
		val maxPower = this.getAEMaxPower(itemStack)

		val percent = (currentPower / maxPower * 100).toInt
		// TODO format scala int to whole number without 10^x

		val message = s"Stored Energy: $roundCurrent AE - $percent%"

		val list = information.asInstanceOf[java.util.List[String]]
		list.add(message)

		// add additional information when sneaking
		if (player.isSneaking)
		{
			list.add("Add additional energ cells to increase energy storage")
		}
	}

	/**
	 * Can harvest block?
	 *
	 * @param block block to be harvested
	 *
	 * @return true if you can harvest the block
	 */
	override def func_150897_b(block: Block): Boolean = true

	override def getDurabilityForDisplay(stack: ItemStack): Double =
	{
		1 - this.getAECurrentPower(stack) / this.getAEMaxPower(stack)
	}

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false
}

