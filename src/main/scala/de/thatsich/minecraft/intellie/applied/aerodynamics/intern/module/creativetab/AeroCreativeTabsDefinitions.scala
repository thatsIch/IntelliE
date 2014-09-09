package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class AeroCreativeTabsDefinitions(icon: Item, modid: ID, log: Log) extends BaseDefinitions(
	fakes = Vector(new ItemStack(icon))
)