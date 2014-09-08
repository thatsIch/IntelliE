package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class AeroCreativeTabsModule(icon: Item, log: Log, modid: ID) extends BaseModule(
	fakes = Vector(icon)
)