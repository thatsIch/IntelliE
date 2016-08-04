package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module

import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.DisassemblerDefinitions
import de.thatsich.minecraft.intellie.applied.intelligences.module.replicator.ReplicatorModule
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.replicator.ReplicatorDefinitions

/**
  * Created by thatsIch on 04.08.2016.
  */
class InternalReplicatorModule(modid: ModID, log: Log) extends ReplicatorModule
{
	override def definitions: Definitions = new ReplicatorDefinitions(this.modid, this.log)
}
