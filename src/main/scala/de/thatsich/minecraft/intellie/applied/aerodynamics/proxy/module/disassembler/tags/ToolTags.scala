package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class ToolTags(config: DisassemblerFunctionalityConfig) extends NBTTags
{
	override def values = Vector(MiningLevel, MiningSpeed)

	object MiningLevel extends BaseBoundNBTProperty[Int](this.config.minimalMiningLevel, this.config.maximalMiningLevel)

	object MiningSpeed extends BaseBoundNBTProperty[Int](this.config.minimalMiningSpeed, this.config.maximalMiningSpeed)

}
