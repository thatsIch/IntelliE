package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.ArmorPower
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.steplogic.BoostedRegistry
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags.FunctionalityTags
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 12.09.2014.
 */
private[horseshoes]
trait HorseShoesStepHeightLogic
	extends ItemArmor
	with ArmorPower
	with BoundDetection {

	def boosted: BoostedRegistry

	def functionalityTags: FunctionalityTags

	/**
	 * Ticks every tick when equipped in armor slot
	 * when player is sprinting and has enough power
	 * power is drained and the stepheight is increased
	 */
	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit = {
		val currentpower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		val isBoosted = this.boosted.contains(player)
		val isSprinting: Boolean = player.isSprinting
		val isPowered: Boolean = currentpower >= discharge
		val stepHeight: Float = this.getStepHeight(is).toFloat

		if (isBoosted) {
			this.extractAEPower(is, discharge)

			player.stepHeight = stepHeight
			player.fallDistance = 0
		}

		if (!isBoosted && isSprinting && isPowered) {
			this.boosted.add(player)
		}
		else if (isBoosted && (!isSprinting || !isPowered)) {
			this.boosted.remove(player)
			player.stepHeight = player.stepHeight - stepHeight + 0.5F
		}
	}

	def getStepHeight(armor: ItemStack): Double = this.withinBounds(armor, this.functionalityTags.StepHeight)
}
