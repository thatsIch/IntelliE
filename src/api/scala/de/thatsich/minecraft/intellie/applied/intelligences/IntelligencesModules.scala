package de.thatsich.minecraft.intellie.applied.intelligences

import de.thatsich.minecraft.common.{Module, Modules}
import de.thatsich.minecraft.intellie.applied.intelligences.module.replicator.ReplicatorModule

/**
  * Created by thatsIch on 04.08.2016.
  */
trait IntelligencesModules extends Modules {
	def replicator: ReplicatorModule

	def vectorized: Seq[Module]
}
