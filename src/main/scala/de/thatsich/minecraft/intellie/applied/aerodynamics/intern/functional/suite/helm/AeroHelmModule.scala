package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.helm

import de.thatsich.minecraft.common.module.BaseModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
object AeroHelmModule extends AeroHelmModule( AeroHelmItem )

class AeroHelmModule( itemAeroHelm: AeroHelmItem ) extends BaseModule( Some[ Item ]( itemAeroHelm ), None, None, None )
