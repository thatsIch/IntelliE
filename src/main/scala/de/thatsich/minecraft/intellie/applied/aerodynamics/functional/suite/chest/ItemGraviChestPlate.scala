package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraftforge.common.ISpecialArmor
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.relauncher.{SideOnly, Side}
import appeng.api.config.AccessRestriction
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
object ItemGraviChestPlate
{
	private final val ENERGY_MAX: Int = 30000000
	private final val DOUBLE: Double = 20.0D
	var maxCharge: Int = 30000000
	var minCharge: Int = 80000
	var transferLimit: Int = 60000
	var tier: Int = 4
	var dischargeOnTick: Int = 278
	var boostSpeed: Float = 0.11F
	var boostMultiplier: Int = 2
}

class ItemGraviChestPlate extends ItemArmor with ISpecialArmor with IAEItemPowerStorage
{
	def this(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
	{
		this()
		`super`(material, renderIndex, armorType)
		this.setUnlocalizedName("GraviChestPlate")
		this.setCreativeTab(CreativeTabs.tabCombat)
	}

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

		Math.round(ItemGraviChestPlate.DOUBLE * baseAbsorptionRatio * damageAbsorptionRatio).asInstanceOf[ Int ]
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

	@Override def isRepairable: Boolean =
	{
		false
	}

	@Override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		val clazz: Nothing = this.getClass
		val wearsSuite: Boolean = player.inventory.armorItemInSlot(2).getItem.getClass == clazz
		val isInCreative: Boolean = player.capabilities.isCreativeMode
		val isInSurvival: Boolean = !isInCreative
		player.capabilities.allowFlying = wearsSuite || isInCreative
		if( player.capabilities.isFlying )
		{
			System.out.println(itemStack)
		}
	}

	@Override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: Nothing): Nothing =
	{
		"gravisuite:textures/armor/armor_graviChestPlate.png"
	}

	@SideOnly(Side.CLIENT)
	@Override def registerIcons(par1IconRegister: IIconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("appaero:itemGraviChestPlate")
	}

	@Override def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		0
	}

	@Override def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		0
	}

	@Override def getAEMaxPower(is: ItemStack): Double =
	{
		0
	}

	@Override def getAECurrentPower(is: ItemStack): Double =
	{
		0
	}

	@Override def getPowerFlow(is: ItemStack): AccessRestriction =
	{
		null
	}
}
