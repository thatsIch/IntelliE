package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.item

import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import cpw.mods.fml.common.Optional
import de.thatsich.minecraft.appeng.api.AE2ModInfo
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

/**
 * Trait for AE2 Power Storage handling
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
@Optional.Interface( iface = "appeng.api.implementations.items.IAEItemPowerStorage", modid = AE2ModInfo.id, striprefs = true )
private[ item ] trait TPowerStorage extends IAEItemPowerStorage
{
	self: AAEPoweredItemArmor =>

	//	def maxStorage: Double

	private final val internalCurrentPower = "internalCurrentPower"
	private final val inject               = 80000

	@Optional.Method( modid = AE2ModInfo.id )
	def getPowerFlow( is: ItemStack ): AccessRestriction = AccessRestriction.WRITE

	@Optional.Method( modid = AE2ModInfo.id )
	def extractAEPower( is: ItemStack, amt: Double ): Double =
	{
		val currentStorage = this.getAECurrentPower( is )
		val newStorage = Math.max( 0.0, currentStorage - amt )
		this.setAECurrentPower( is, newStorage )

		newStorage
	}

	@Optional.Method( modid = AE2ModInfo.id )
	def injectAEPower( is: ItemStack, amt: Double ): Double =
	{
		val currentStorage = this.getAECurrentPower( is )
		val maxStorage = this.getAEMaxPower( is )
		val newStorage = Math.min( maxStorage, currentStorage + this.inject )
		val diff = maxStorage - newStorage
		this.setAECurrentPower( is, newStorage )

		diff
	}

	@Optional.Method( modid = AE2ModInfo.id )
	def getAECurrentPower( is: ItemStack ): Double =
	{
		val tag = this.getNBTData( is )
		val currentStorage = tag.getDouble( internalCurrentPower )

		currentStorage
	}

	private def getNBTData( itemStack: ItemStack ): NBTTagCompound =
	{
		var compound = itemStack.getTagCompound
		if( compound == null )
		{
			compound = new NBTTagCompound
			itemStack.setTagCompound( compound )
		}

		compound
	}

	@Optional.Method( modid = AE2ModInfo.id )
	def setAECurrentPower( is: ItemStack, value: Double ): Unit =
	{
		val tag = this.getNBTData( is )
		tag.setDouble( internalCurrentPower, value )
	}

	@Optional.Method( modid = AE2ModInfo.id )
	def getAEMaxPower( is: ItemStack ): Double = this.maxStorage
}