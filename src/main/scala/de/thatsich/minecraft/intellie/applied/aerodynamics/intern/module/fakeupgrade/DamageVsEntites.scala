package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.id.{SimpleID, BaseID, ID}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.item.FakeBaseItem


/**
 *
 *
 * @author thatsIch
 * @since 12.08.2014.
 */
class DamageVsEntites(modid: ID, log: Log) extends FakeBaseItem(modid, new SimpleID("damage"), log)