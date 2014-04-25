package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs

import de.thatsich.minecraft.core.module.AModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class AeroLegsModule( implicit itemAeroLegs: ItemAeroLegs )
	extends AModule( Some[ Item ]( itemAeroLegs ), None, None, None )
{

}
