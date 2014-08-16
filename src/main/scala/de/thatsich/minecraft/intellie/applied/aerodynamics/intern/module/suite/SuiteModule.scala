package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item.{AeroBootsItem, AeroChestItem, AeroHelmItem, AeroLegsItem}


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
class SuiteModule(log: Log, modid: ID) extends BaseModule(
	items = Vector(
		new AeroHelmItem,
		new AeroChestItem,
		new AeroLegsItem,
		new AeroBootsItem
	)
)