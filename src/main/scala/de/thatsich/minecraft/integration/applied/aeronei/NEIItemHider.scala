package de.thatsich.minecraft.integration.applied.aeronei


import codechicken.nei.api.API
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
class NEIItemHider
{
	println("CONSTRUCTED")

	val modules: Seq[Module] = AppliedAerodynamics.proxy.modules

	for (module <- modules; item <- module.items)
	{
		if (item.getToolClasses(null).contains("fake"))
		{
			API.hideItem(new ItemStack(item))
		}
	}
}
