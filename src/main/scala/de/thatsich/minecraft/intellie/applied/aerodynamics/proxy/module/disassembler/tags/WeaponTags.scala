package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.DisassemblerConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object WeaponTags extends NBTTags with DisassemblerConfigAccess
{
	override def values: Seq[BoundNBTProperty] = Vector[BoundNBTProperty](Damage)

	object Damage extends BaseBoundNBTProperty(this.initDamageVsEntites, this.maxDamageVsEntites)
}
