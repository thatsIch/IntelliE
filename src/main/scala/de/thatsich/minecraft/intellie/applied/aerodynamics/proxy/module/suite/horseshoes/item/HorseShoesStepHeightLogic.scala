package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.steplogic.HorseShoesLivingUpdateEventHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge


/**
 * 
 *
 * @author thatsIch
 * @since 12.09.2014.
 */
trait HorseShoesStepHeightLogic
	extends ItemArmor
	        with HorseShoesItemPowerStorage
{
	MinecraftForge.EVENT_BUS.register(new HorseShoesLivingUpdateEventHandler(this))

	/**
	 * Ticks every tick when equiped in armor slot
	 * when player is sprinting and has enough power
	 * power is drained and the stepheight is increased
	 */
	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentpower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		if (player.isSprinting && currentpower >= discharge)
		{
			this.extractAEPower(is, discharge)

			player.stepHeight = 1F
			player.fallDistance = 0
		}
		else
		{
			player.stepHeight = 0.5F
		}
	}
}
