package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.{BaseID, ID}


/**
 *
 *
 * @author thatsIch
 * @since 12.08.2014.
 */
class IncMiningSpeed(modid: ID, log: Log) extends BaseItem(modid, new IncMiningSpeedID, log)

private[this] class IncMiningSpeedID extends BaseID("incMiningSpeed")