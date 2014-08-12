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
class IncMiningLevel(modid: ID, log: Log) extends BaseItem(modid, new IncMiningLevelID, log)

private[this] class IncMiningLevelID extends BaseID("incMiningLevel")