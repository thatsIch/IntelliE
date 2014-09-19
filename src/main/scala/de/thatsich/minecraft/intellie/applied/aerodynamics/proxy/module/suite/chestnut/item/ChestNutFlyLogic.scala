package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item


import cpw.mods.fml.common.FMLCommonHandler
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.flylogic.{ChestNutKeyInputEventHandler, ChestNutLivingUpdadeEventHandler}
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

	val keys = new ChestNutKeyInputEventHandler
	MinecraftForge.EVENT_BUS.register(new ChestNutLivingUpdadeEventHandler(this))
	FMLCommonHandler.instance().bus().register(this.keys)

	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		this.fly(player, is)
	}

	private var flyToggleTimer = 0
	private var jumped = true
	private var on = false

	private def fly(player: EntityPlayer, armor: ItemStack): Unit =
	{
		// jumps for first time, starts toggle timer
		if (this.keys.isJumping && this.flyToggleTimer == 0)
		{
			this.flyToggleTimer = 7
			this.jumped = false
		}
		// released jump
		else if (!this.keys.isJumping && this.flyToggleTimer > 0)
		{
			this.jumped = true
		}
		// double jumped
		else if (this.keys.isJumping && this.flyToggleTimer > 0 && this.jumped)
		{
			this.on = !this.on
		}

		if (this.flyToggleTimer > 0) this.flyToggleTimer -= 1

		if (this.on && this.inAir(player) && this.hasEnoughPower(armor))
		{
			val discharge = this.getDischargePerTick(armor)
			this.extractAEPower(armor, discharge)

			val flyspeed = this.getFlySpeed(armor)
			val sidewaysSpeed = flyspeed.toFloat
			val verticalAccel = 1.25 * flyspeed
			val verticalSpeedCap = 4 * flyspeed

			// fly upwards
			if (this.keys.isJumping && !this.keys.isSneaking) player.motionY = (player.motionY + verticalAccel) min verticalSpeedCap
			else if (!this.keys.isJumping && this.keys.isSneaking) player.motionY = (player.motionY + verticalAccel) min -verticalSpeedCap
			else player.motionY = 0

			// fly sideways
			if (this.keys.isForward && !this.keys.isBackward) player.moveFlying(0, sidewaysSpeed, sidewaysSpeed)
			else if (this.keys.isBackward && !this.keys.isForward) player.moveFlying(0, -sidewaysSpeed, 0.8F * sidewaysSpeed)
			if (this.keys.isLeft && !this.keys.isRight) player.moveFlying(sidewaysSpeed, 0, sidewaysSpeed)
			else if (this.keys.isRight && !this.keys.isLeft) player.moveFlying(-sidewaysSpeed, 0, sidewaysSpeed)

			// if no keys are pressed
			if (!this.keys.isForward && !this.keys.isBackward && !this.keys.isLeft && !this.keys.isRight)
			{
				player.motionX = 0
				player.motionZ = 0
			}

			// set fall distance to 0 else player dies after landing
			if (!player.worldObj.isRemote)
			{
				player.fallDistance = 0
				player.capabilities.allowFlying = true
			}
		}

		// emergency truster
	}

	private def inAir(player: EntityPlayer): Boolean = !player.onGround

	private def hasEnoughPower(is: ItemStack): Boolean = this.getAECurrentPower(is) >= this.getDischargePerTick(is)

	def getFlySpeed(is: ItemStack): Double = this.withinBounds(is, this.funcTags.FlySpeed)
}
