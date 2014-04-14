package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraftforge.common.ISpecialArmor
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.util.DamageSource
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.client.renderer.texture.IIconRegister
import de.thatsich.minecraft.core.module.item.AItemArmor
import cpw.mods.fml.common.Optional
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.core.OModIDs
import appeng.api.config.AccessRestriction

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
/**
@author thatsIch
@since 26.03.2014. */
object ItemAeroChest
{
	val ENERGY_MAX: Int = 30000000
	val BASE_VALUE: Double = 20.0D
	val maxCharge: Int = 30000000
	val minCharge: Int = 80000
	val transferLimit: Int = 60000
	val tier: Int = 4
	val dischargeOnTick: Int = 278
	val boostSpeed: Float = 0.11F
	val boostMultiplier: Int = 2
	val baseAbsorptionRatio: Double = 0.4D
	val damageAbsorptionRatio: Double = 1.1D
	val energyPerDamage: Int = 900
}

@Optional.Interface(iface = "appeng.api.implementations.items.ISpecialArmor", modid = OModIDs.APPENG, striprefs = true)
class ItemAeroChest(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                   (implicit creativeTab: CreativeTabs)
	extends AItemArmor(material, renderIndex, armorType)
	with ISpecialArmor
	with IAEItemPowerStorage
{
	def getPowerFlow(is: ItemStack): AccessRestriction =
	{
		AccessRestriction.WRITE
	}

	def getAECurrentPower(is: ItemStack): Double =
	{
		0.0
	}

	def getAEMaxPower(is: ItemStack): Double =
	{
		0.0
	}

	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		0.0
	}

	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		0.0
	}

	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val absorptionRatio: Double = ItemAeroChest.baseAbsorptionRatio * ItemAeroChest.damageAbsorptionRatio
		val damageLimit: Int = if( ItemAeroChest.energyPerDamage > 0 ) 25 * 100 / ItemAeroChest.energyPerDamage else 0

		new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(ItemAeroChest.BASE_VALUE *
			ItemAeroChest.baseAbsorptionRatio *
			ItemAeroChest.damageAbsorptionRatio
		).toInt
	}

	override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int)
	{
	}

	override def isRepairable: Boolean =
	{
		false
	}

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		player.capabilities.allowFlying = true
	}

	def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: Nothing): String =
	{
		"gravisuite:textures/armor/armor_graviChestPlate.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("appaero:itemGraviChestPlate")
	}
}
