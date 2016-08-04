package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.replicator

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.{DisassemblerCraftRecipe, DisassemblerItem, DisassemblerUpgradeRecipe}

/**
  * Created by thatsIch on 04.08.2016.
  */
class ReplicatorDefinitions(modid: ModID, log: Log) extends BaseDefinitions(
	items = Vector(new ReplicatorItem(modid, log)),
	recipes = Vector(new ReplicatorCraftRecipe)
)
