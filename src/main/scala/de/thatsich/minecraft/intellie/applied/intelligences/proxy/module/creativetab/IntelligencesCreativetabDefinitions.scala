package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.creativetab

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.Item

/**
  * Created by thatsIch on 04.08.2016.
  */
class IntelligencesCreativetabDefinitions(icon: Item, modid: ID, log: Log) extends BaseDefinitions(
	fakes = Vector(icon)
)
