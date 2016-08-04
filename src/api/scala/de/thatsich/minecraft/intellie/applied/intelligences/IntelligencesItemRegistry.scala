package de.thatsich.minecraft.intellie.applied.intelligences

import net.minecraft.item.{Item, ItemStack}

/**
  * Created by thatsIch on 04.08.2016.
  */
trait IntelligencesItemRegistry {
	def items: Seq[Item]

	def itemstacks: Seq[ItemStack]
}
