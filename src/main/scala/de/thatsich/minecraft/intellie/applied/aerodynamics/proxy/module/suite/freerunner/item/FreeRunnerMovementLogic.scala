package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item


import java.util.UUID

import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.ArmorPower
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.movementlogic.FreeRunnerLivingUpdateEventHandler
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
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

	private val modifierID = UUID.randomUUID()
	MinecraftForge.EVENT_BUS.register(new FreeRunnerLivingUpdateEventHandler(this, this.modifierID))


	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentPower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		val attribute = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		val modifier = attribute.getModifier(this.modifierID)

		if (currentPower >= discharge)
		{
			this.extractAEPower(is, discharge)

			if (modifier == null)
			{
				val speed = if (player.isSprinting) this.getRunSpeed(is) else this.getWalkSpeed(is)
				val newmodifier = new AttributeModifier(this.modifierID, "Movement speed boost" , speed, 2)

				attribute.applyModifier(newmodifier)
			}
		}
		else
		{
			if (modifier != null)
			{
				attribute.removeModifier(modifier)
			}
		}
	}

	def getWalkSpeed(is: ItemStack): Double = this.withinBounds(is, this.funcTags.WalkSpeed)

	def getRunSpeed(is: ItemStack): Double = this.withinBounds(is, this.funcTags.RunSpeed)
}
