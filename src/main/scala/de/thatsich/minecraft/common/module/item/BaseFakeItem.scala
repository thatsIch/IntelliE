package de.thatsich.minecraft.common.module.item

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
abstract class BaseFakeItem(modid: ID, itemName: ID, log: Log) extends BaseItem(modid, itemName, log)
{
	this.setHarvestLevel("fake", 0)
}