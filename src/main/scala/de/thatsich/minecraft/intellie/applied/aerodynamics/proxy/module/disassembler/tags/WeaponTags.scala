package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerWeaponConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class WeaponTags(config: DisassemblerWeaponConfig) extends NBTTags
{
	override def values: Seq[BoundNBTProperty] = Vector[BoundNBTProperty](Damage)

	object Damage extends BaseBoundNBTProperty(this.config.minimalDamageVsEntites, this.config.maximalDamageVsEntites)

}
