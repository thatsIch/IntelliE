package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class ToolTags(config: DisassemblerFunctionalityConfig) extends NBTTags
{
	override def values: Seq[BoundNBTProperty] = Vector[BoundNBTProperty](MiningLevel, MiningSpeed)

	object MiningLevel extends BaseBoundNBTProperty(this.config.minimalMiningLevel, this.config.maximalMiningLevel)

	object MiningSpeed extends BaseBoundNBTProperty(this.config.minimalMiningSpeed, this.config.maximalMiningSpeed)

}
