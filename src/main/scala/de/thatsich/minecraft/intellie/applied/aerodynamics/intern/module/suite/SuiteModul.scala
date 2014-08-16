package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.item.fake.{MiningSpeed, MiningLevel, MaxEnergyStorage, DamageVsEntites, CurrentEnergyStorage, ChargeSpeedItem, EnergyCostItem}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item.{AeroBootsItem, AeroLegsItem, AeroChestItem, AeroHelmItem}


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
class SuiteModul(log: Log, modid: ID) extends BaseModule(
	items = Vector(
		new AeroHelmItem,
		new AeroChestItem,
		new AeroLegsItem,
		new AeroBootsItem
	)
)