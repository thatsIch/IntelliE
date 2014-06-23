package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm

import de.thatsich.minecraft.core.module.BaseModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class AeroHelmModule( implicit itemAeroHelm: ItemAeroHelm )
	extends BaseModule( Some[ Item ]( itemAeroHelm ), None, None, None )
{

}
