package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.legs


import de.thatsich.minecraft.common.module.BaseModule
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class AeroLegsModule(implicit itemAeroLegs: AeroLegsItem)
	extends BaseModule(Some[Item](itemAeroLegs), None, None, None)
{
}
