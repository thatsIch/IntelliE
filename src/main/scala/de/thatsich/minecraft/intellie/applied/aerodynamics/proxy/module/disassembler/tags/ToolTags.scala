package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BoundNBTProperty, BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.DisassemblerConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object ToolTags extends NBTTags with DisassemblerConfigAccess
{
	object MiningLevel extends BaseBoundNBTProperty(this.initMiningLevel, this.maxMiningLevel)
	object MiningSpeed  extends BaseBoundNBTProperty(this.initMiningSpeed, this.maxMiningSpeed)

	override def values: Seq[BoundNBTProperty] = Vector[BoundNBTProperty](MiningLevel, MiningSpeed)
}
