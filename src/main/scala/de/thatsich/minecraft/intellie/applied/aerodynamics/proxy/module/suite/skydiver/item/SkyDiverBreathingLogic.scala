package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.item


import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.ArmorPower
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.item.tags.FunctionalityTags
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.world.World


/**
 * 
 *
 * @author thatsIch
 * @since 26.09.2014.
 */
private[skydiver]
trait SkyDiverBreathingLogic
extends ItemArmor
        with ArmorPower
        with BoundDetection
{
	def functionalityTags: FunctionalityTags

	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentpower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		if (player.isInWater && currentpower >= discharge)
		{
			this.extractAEPower(is, discharge)

			val currentAir: Int = player.getAir
			val maxAir: Int = 300 min (currentAir + this.getBreathing(is))
			player.setAir(maxAir)
		}
	}

	def getBreathing(armor: ItemStack): Int = this.withinBounds(armor, this.functionalityTags.Breathing)
}
