package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.DisassemblerDefinitions


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalDisassemblerModule(modid: ModID, log: Log) extends DisassemblerModule
{
	override def definitions: Definitions = new DisassemblerDefinitions(this.modid, this.log)
}
