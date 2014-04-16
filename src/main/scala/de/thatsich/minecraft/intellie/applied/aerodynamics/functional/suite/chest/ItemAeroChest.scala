package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraft.creativetab.CreativeTabs
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.client.renderer.texture.IIconRegister
import de.thatsich.minecraft.core.module.item.AItemArmor
import cpw.mods.fml.common.Optional
import de.thatsich.minecraft.core.OModIDs

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
	private[ chest ] final val ENERGY_MAX           : Int    = 30000000
	private[ chest ] final val BASE_VALUE           : Double = 20.0D
	private[ chest ] final val maxCharge            : Int    = 30000000
	private[ chest ] final val minCharge            : Int    = 80000
	private[ chest ] final val transferLimit        : Int    = 60000
	private[ chest ] final val tier                 : Int    = 4
	private[ chest ] final val dischargeOnTick      : Int    = 278
	private[ chest ] final val boostSpeed           : Float  = 0.11F
	private[ chest ] final val boostMultiplier      : Int    = 2
	private[ chest ] final val baseAbsorptionRatio  : Double = 0.4D
	private[ chest ] final val damageAbsorptionRatio: Double = 1.1D
	private[ chest ] final val energyPerDamage      : Int    = 900
}

@Optional.Interface(iface = "appeng.api.implementations.items.ISpecialArmor", modid = OModIDs.AE2, striprefs = true)
class ItemAeroChest(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                   (implicit creativeTab: CreativeTabs)
	extends AItemArmor(material, renderIndex, armorType)
	        with TAeroChestSpecialArmor
	        with TAeroChestAEItemPowerStorage
{
	override def isRepairable: Boolean =
	{
		false
	}

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
}
