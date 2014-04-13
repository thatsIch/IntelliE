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
}

class ItemAeroChest(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                   (implicit creativeTab: CreativeTabs)
	extends ItemArmor(material, renderIndex, armorType)
	with ISpecialArmor
{
	this.setUnlocalizedName("GraviChestPlate")
	this.setCreativeTab(creativeTab)

	@Override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val absorptionRatio: Double = this.getBaseAbsorptionRatio * this.getDamageAbsorptionRatio
		val energyPerDamage: Int = this.getEnergyPerDamage
		val damageLimit: Int = if( energyPerDamage > 0 ) 25 * 100 / energyPerDamage else 0

		new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit)
	}

	@Override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		val baseAbsorptionRatio: Double = this.getBaseAbsorptionRatio
		val damageAbsorptionRatio: Double = this.getDamageAbsorptionRatio

		Math.round(ItemAeroChest.BASE_VALUE * baseAbsorptionRatio * damageAbsorptionRatio).toInt
	}

	@Override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int)
	{
	}

	private def getBaseAbsorptionRatio: Double =
	{
		0.4D
	}

	def getDamageAbsorptionRatio: Double =
	{
		1.1D
	}

	def getEnergyPerDamage: Int =
	{
		900
	}

	override def isRepairable: Boolean =
	{
		false
	}

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		val clazz = this.getClass
		val wearsSuite: Boolean = player.inventory.armorItemInSlot(2).getItem.getClass == clazz
		val isInCreative: Boolean = player.capabilities.isCreativeMode

		player.capabilities.allowFlying = wearsSuite || isInCreative
		if( player.capabilities.isFlying )
		{
			//			System.out.println(itemStack)
		}
	}

	def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: Nothing): String =
	{
		"gravisuite:textures/armor/armor_graviChestPlate.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(par1IconRegister: IIconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("appaero:itemGraviChestPlate")
	}
}
