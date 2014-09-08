package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinition
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class AeroCreativeTabsDefinition(icon: Item, log: Log, modid: ID) extends BaseDefinition(
	fakes = Vector(new ItemStack(icon))
)