package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots

import de.thatsich.minecraft.core.OModIDs
import cpw.mods.fml.common.Optional
import net.minecraft.item.{ItemStack, ItemArmor}
import net.minecraft.creativetab.CreativeTabs
import de.thatsich.minecraft.core.module.item.AItemArmor
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.Entity
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.renderer.texture.IIconRegister

private[ boots ] object ItemAeroBoots
{
	private[ boots ] final val ENERGY_MAX           : Int    = 30000000
	private[ boots ] final val BASE_VALUE           : Double = 20.0D
	private[ boots ] final val maxCharge            : Int    = 30000000
	private[ boots ] final val minCharge            : Int    = 80000
	private[ boots ] final val transferLimit        : Int    = 60000
	private[ boots ] final val tier                 : Int    = 4
	private[ boots ] final val dischargeOnTick      : Int    = 278
	private[ boots ] final val boostSpeed           : Float  = 0.11F
	private[ boots ] final val boostMultiplier      : Int    = 2
	private[ boots ] final val baseAbsorptionRatio  : Double = 0.4D
	private[ boots ] final val damageAbsorptionRatio: Double = 1.1D
	private[ boots ] final val energyPerDamage      : Int    = 900
}

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
@Optional.Interface(iface = "appeng.api.implementations.items.ISpecialArmor", modid = OModIDs.AE2, striprefs = true)
class ItemAeroBoots(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                   (implicit creativeTab: CreativeTabs)
	extends AItemArmor(material, renderIndex, armorType)
	        with TAeroBootsSpecialArmor
	        with TAeroBootsAEItemPowerStorage
{
	override def isRepairable: Boolean =
	{
		false
	}

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		if( player.isSprinting )
		{
			player.stepHeight = 1F
		}
		else
		{
			player.stepHeight = 0.5F
		}
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
