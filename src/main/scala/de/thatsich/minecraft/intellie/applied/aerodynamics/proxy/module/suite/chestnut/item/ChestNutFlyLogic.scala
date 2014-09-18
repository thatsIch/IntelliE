package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item


import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.flylogic.ChestNutLivingUpdadeEventHandler
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.ArmorPower
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[chestnut]
trait ChestNutFlyLogic
extends ItemArmor
        with ArmorPower
        with BoundDetection
{
	def funcTags: ChestNutFunctionalityTags

	MinecraftForge.EVENT_BUS.register(new ChestNutLivingUpdadeEventHandler(this))

	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentPower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		if (currentPower >= discharge)
		{
			player.capabilities.allowFlying = true
			if (player.capabilities.isFlying)
			{
				this.extractAEPower(is, discharge)
			}
//			player.capabilities.setFlySpeed()
		}
		else
		{
			player.capabilities.allowFlying = false
			player.capabilities.isFlying = false
		}
	}

	def getFlySpeed(is: ItemStack): Double = this.withinBounds(is, this.funcTags.FlySpeed)
}
