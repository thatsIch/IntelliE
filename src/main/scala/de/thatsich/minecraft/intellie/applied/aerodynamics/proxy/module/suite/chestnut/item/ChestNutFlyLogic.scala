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
//		val currentPower = this.getAECurrentPower(is)
		//		val discharge = this.getDischargePerTick(is)
		//
		//		if (currentPower >= discharge)
		//		{
		//			player.capabilities.allowFlying = true
		//			if (player.capabilities.isFlying)
		//			{
		//				this.extractAEPower(is, discharge)
		//			}
		//			//			player.capabilities.setFlySpeed()
		//		}
		//		else
		//		{
		//			player.capabilities.allowFlying = false
		//			player.capabilities.isFlying = false
		//		}
		this.fly(player, is)
	}

	private def fly(player: EntityPlayer, armor: ItemStack): Unit =
	{
		val flyspeed = this.getFlySpeed(armor)

		println(flyspeed)

		val sidewaysSpeed = flyspeed.toFloat
		val verticalAccel = 0.75 * flyspeed
		val verticalSpeedCap = 4 * flyspeed

		val currentAccel = if (player.motionY < 0.3) verticalAccel * 2.5 else verticalAccel

		if (this.isOn)
		{
			if (this.isFlying(player))
			{
				if (this.hasEnoughPower(armor))
				{
					val discharge = this.getDischargePerTick(armor)
					this.extractAEPower(armor, discharge)

					// fly upwards
					if (this.keys.isJumping && !this.keys.isSneaking)
					{
						player.motionY = (player.motionY + currentAccel) min verticalSpeedCap
					}
					else if (!this.keys.isJumping && this.keys.isSneaking)
					{
						player.motionY = (player.motionY + currentAccel) min -verticalSpeedCap
					}
					else
					{
						player.motionY = 0
					}

					if (this.keys.isForward)
					{
						player.moveFlying(0, sidewaysSpeed, sidewaysSpeed)
					}

					if (this.keys.isBackward)
					{
						player.moveFlying(0, -sidewaysSpeed, 0.8F * sidewaysSpeed)
					}

					if (this.keys.isLeft)
					{
						player.moveFlying(sidewaysSpeed, 0, sidewaysSpeed)
					}

					if (this.keys.isRight)
					{
						player.moveFlying(-sidewaysSpeed, 0, sidewaysSpeed)
					}

					if (!this.keys.isForward && !this.keys.isBackward && !this.keys.isLeft && !this.keys.isRight)
					{
						player.motionX = 0
						player.motionZ = 0
					}

					// set fall distance to 0 else player dies after landing
					if (!player.worldObj.isRemote)
					{
						player.fallDistance = 0
					}
				}
			}
		}

		// emergency truster

	}

	private def isOn: Boolean = true

	private def isFlying(player: EntityPlayer): Boolean = !player.onGround

	private def hasEnoughPower(is: ItemStack): Boolean = this.getAECurrentPower(is) >= this.getDischargePerTick(is)

	def getFlySpeed(is: ItemStack): Double = this.withinBounds(is, this.funcTags.FlySpeed)
}
