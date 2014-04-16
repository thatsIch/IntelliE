package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm

import de.thatsich.minecraft.core.registries.IRegistries
import de.thatsich.minecraft.core.module.AModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class AeroHelmModule(implicit itemAeroHelm: ItemAeroHelm, registries: IRegistries)
	extends AModule(Some[ Item ](itemAeroHelm), None, None, None)
{

}
