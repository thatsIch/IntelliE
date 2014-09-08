package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.nbtkey


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseFakeItem
import de.thatsich.minecraft.common.string.id.SimpleID
import de.thatsich.minecraft.common.util.string.ID


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class DamageItem(modid: ID, log: Log) extends BaseFakeItem(modid, new SimpleID("damage"), log)
