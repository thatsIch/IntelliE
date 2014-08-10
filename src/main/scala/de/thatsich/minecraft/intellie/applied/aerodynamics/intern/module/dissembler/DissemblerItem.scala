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
import org.lwjgl.input.Keyboard


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
		val block: Block = world.getBlock(x, y, z)
		if (this.canHarvestBlock(block, stack))
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

	//	override def func_150893_a(is: ItemStack, b: Block): Float =
	//	{
	//		if (this.getAECurrentPower(is) > this.getCurrentEnergyPerBlockBreak(is))
	//		{
	//			5000
	//			//			this.getCurrentMiningSpeed(is)
	//		}
	//		else
	//		{
	//			0
	//		}
	//	}

	/**
	 * gets the mining speed
	 *
	 * @param is ItemStack of this
	 * @param block Mining block
	 * @param metadata metadata of bloc
	 *
	 * @return configured mining speed
	 */
	override def getDigSpeed(is: ItemStack, block: Block, metadata: Int): Float =
	{
		if (this.canHarvestBlock(block, is))
		{
			this.getCurrentMiningSpeed(is)
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

	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(is)
		val roundCurrent = currentPower.toInt

		val maxPower = this.getAEMaxPower(is)
		val percent = (currentPower / maxPower * 100).toInt

		val list = information.asInstanceOf[java.util.List[String]]

		// add additional information when sneaking
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			val energyBlockBreak: Double = this.getCurrentEnergyPerBlockBreak(is)
			val multiplier: Double = this.getCurrentChargeMultiplier(is)
			val speed: Int = this.getCurrentMiningSpeed(is)
			val level: Int = this.getCurrentMiningLevel(is)
			val damage: Double = this.getCurrentDamageVsEntities(is)

			list.add(s"Stored Energy: $roundCurrent AE - $percent%")
			list.add(s"Energy Cost: $energyBlockBreak")
			list.add(s"Charge multiplier: $multiplier")

			list.add(s"Mining Speed: $speed")
			list.add(s"Mining Level: $level")

			list.add(s"Damage: $damage")
		}
		else
		{
			val shortCurrent = this.readableForm(roundCurrent)
			list.add(s"Stored Energy: $shortCurrent AE - $percent%")
			list.add("Hold shift for more information")
		}
	}

	override def canHarvestBlock(block: Block, is: ItemStack): Boolean =
	{
		val harvestLevel: Int = block.getHarvestLevel(0)
		val currentMiningLevel: Int = this.getCurrentMiningLevel(is)

		val currentEnergy = this.getAECurrentPower(is)
		val energyUsage = this.getCurrentEnergyPerBlockBreak(is)

		currentMiningLevel >= harvestLevel && currentEnergy >= energyUsage
	}

	override def getDurabilityForDisplay(stack: ItemStack): Double =
	{
		1 - this.getAECurrentPower(stack) / this.getAEMaxPower(stack)
	}

	override def showDurabilityBar(stack: ItemStack): Boolean = true

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false

	private def readableForm(value: Int): String =
	{
		val unit = 1000
		if (value < unit) return value + " AE"
		val exp = (Math.log(value) / Math.log(unit)).toInt
		val pre: String = "kMBT".charAt(exp - 1) + ""
		"%.1f %sAE".format(value / Math.pow(unit, exp), pre)
	}
}

