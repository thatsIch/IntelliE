package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item


import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.ArmorPower
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.movementlogic.FreeRunnerLivingUpdateEventHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge


/**
 * 
 *
 * @author thatsIch
 * @since 18.09.2014.
 */
trait FreeRunnerMovementLogic
extends ItemArmor
        with ArmorPower
        with BoundDetection
{
	def funcTags: FreeRunnerFunctionalityTags

	MinecraftForge.EVENT_BUS.register(new FreeRunnerLivingUpdateEventHandler(this))

	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentPower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		if (currentPower >= discharge)
		{
			this.extractAEPower(is, discharge)

			if (player.isSprinting)
			{
				player.capabilities.setPlayerWalkSpeed(this.getRunSpeed(is))
			}
			else
			{
				player.capabilities.setPlayerWalkSpeed(this.getWalkSpeed(is))
			}
		}
		else
		{
			player.capabilities.setPlayerWalkSpeed(this.funcTags.WalkSpeed.min / this.funcTags.WalkSpeed.scale)
		}
	}

	def getWalkSpeed(is: ItemStack): Float = this.withinBounds(is, this.funcTags.WalkSpeed)

	def getRunSpeed(is: ItemStack): Float = this.withinBounds(is, this.funcTags.RunSpeed)
}
