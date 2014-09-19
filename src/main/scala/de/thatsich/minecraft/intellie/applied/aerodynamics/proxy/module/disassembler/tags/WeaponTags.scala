package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerWeaponConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class WeaponTags(config: DisassemblerWeaponConfig) extends NBTTags
{
	override def values = Vector(Damage)

	object Damage extends BaseBoundNBTProperty[Double](this.config.minimalDamageVsEntites, this.config.maximalDamageVsEntites)

}
