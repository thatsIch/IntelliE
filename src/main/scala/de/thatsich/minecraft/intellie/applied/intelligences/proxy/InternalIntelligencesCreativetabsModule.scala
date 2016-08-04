package de.thatsich.minecraft.intellie.applied.intelligences.proxy

import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.intelligences.module.IntelligencesCreativetabsModule
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.creativetab.IntelligencesCreativetabDefinitions
import net.minecraft.item.Item

/**
  * Created by thatsIch on 04.08.2016.
  */
class InternalIntelligencesCreativetabsModule(icon: Item, modid: ID, log: Log) extends IntelligencesCreativetabsModule
{
	override lazy val definitions: Definitions = new IntelligencesCreativetabDefinitions(this.icon, this.modid, this.log)
}
