package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.client.renderer.texture.IIconRegister
import de.thatsich.minecraft.core.module.item.AItemArmor

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
/**
@author thatsIch
@since 26.03.2014. */
private[ chest ] object ItemAeroChest
{
	private[ chest ] final val ENERGY_MAX: Int = 80000000
	private[ chest ] final val BASE_VALUE           : Double = 20.0D
	private[ chest ] final val TRANSFER: Int = 80000
	private[ chest ] final val tier                 : Int    = 4
	private[ chest ] final val dischargeOnTick      : Int    = 278
	private[ chest ] final val boostSpeed           : Float  = 0.11F
	private[ chest ] final val boostMultiplier      : Int    = 2
	private[ chest ] final val baseAbsorptionRatio  : Double = 0.4D
	private[ chest ] final val damageAbsorptionRatio: Double = 1.1D
	private[ chest ] final val energyPerDamage      : Int    = 900
	private[ chest ] final val STEPS   : Int = 100
}

class ItemAeroChest(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                   (implicit creativeTab: CreativeTabs)
	extends AItemArmor(material, renderIndex, armorType)
	        with TAeroChestSpecialArmor
	        with TAeroChestAEItemPowerStorage
{
	this.setMaxDamage(ItemAeroChest.STEPS)
	this.hasSubtypes = false

	override def addInformation(itemStack: ItemStack, player: EntityPlayer, information: java.util.List[ _ ], advToolTips: Boolean) =
	{
		val tag = itemStack.getTagCompound
		var internalCurrentPower = 0D
		val internalMaxPower = this.getAEMaxPower(itemStack)

		if( tag != null )
		{
			internalCurrentPower = tag.getDouble("internalCurrentPower")
		}

		val percent = (internalCurrentPower / internalMaxPower * 100).toInt
		// TODO format scala int to whole number without 10^x
		val message = s"Stored Energy: $internalCurrentPower AE - $percent%"

		val list = information.asInstanceOf[ java.util.List[ String ] ]
		list.add(message)
	}

	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		player.capabilities.allowFlying = true
	}

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerochest")
	}

	override def getDisplayDamage(stack: ItemStack): Int =
	{
		val percent = this.getAECurrentPower(stack) / this.getAEMaxPower(stack)
		val damage = ItemAeroChest.STEPS - (ItemAeroChest.STEPS * percent).toInt

		damage
	}

	override def isDamaged(stack: ItemStack): Boolean = true
}
