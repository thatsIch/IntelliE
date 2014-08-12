package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 12.08.2014.
 */
class FakeUpgradeModule(log: Log, modid: ID) extends BaseModule(
	new DecEnergyCostItem(modid, log),
	new IncChargeSpeedItem(modid, log),
	new IncCurrentEnergyStorage(modid, log),
	new IncDamageVsEntites(modid, log),
	new IncMaxEnergyStorage(modid, log),
	new IncMiningLevel(modid, log),
	new IncMiningSpeed(modid, log)
)