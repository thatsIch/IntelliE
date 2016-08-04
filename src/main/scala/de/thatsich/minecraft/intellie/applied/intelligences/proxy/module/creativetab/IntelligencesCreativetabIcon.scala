package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.creativetab

import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.Item

/**
  * Created by thatsIch on 04.08.2016.
  */
class IntelligencesCreativetabIcon(id: ID) extends Item
{
	private val modid: String = this.id

	this.setUnlocalizedName(s"$modid.creativeTabIcon")
	this.setTextureName(s"$modid:creativeicon")
	this.setHarvestLevel("fake", 0)
}
