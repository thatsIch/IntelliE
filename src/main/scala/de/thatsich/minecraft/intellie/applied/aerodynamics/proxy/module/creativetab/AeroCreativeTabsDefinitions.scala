package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.creativetab


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class AeroCreativeTabsDefinitions(icon: Item, modid: ID, log: Log) extends BaseDefinitions(
	fakes = Vector(icon)
)