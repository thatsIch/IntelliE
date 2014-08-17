package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.FreeRunnerItem
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.chest.AeroChestItem
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.helm.AeroHelmItem
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.legs.AeroLegsItem


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
		new FreeRunnerItem
	)
)