package de.thatsich.minecraft.intellie.applied.intelligences.proxy

import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.intelligences.IntelligencesModules
import de.thatsich.minecraft.intellie.applied.intelligences.module.IntelligencesCreativetabsModule
import de.thatsich.minecraft.intellie.applied.intelligences.module.replicator.ReplicatorModule
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.InternalReplicatorModule
import net.minecraft.item.Item

/**
  * Created by thatsIch on 04.08.2016.
  */
class InternalIntelligencesModules(icon: Item, modid: ModID, log: Log) extends IntelligencesModules
{
	val replicator: ReplicatorModule = new InternalReplicatorModule(this.modid, this.log)
	val creativetabs: IntelligencesCreativetabsModule = new InternalIntelligencesCreativetabsModule(this.icon, this.modid, this.log)

	val vectorized = Vector[Module](this.replicator, this.creativetabs)
}
