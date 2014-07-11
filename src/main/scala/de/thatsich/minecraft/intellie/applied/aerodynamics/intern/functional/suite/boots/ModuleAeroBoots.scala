package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.boots

import de.thatsich.minecraft.api.mod.module.BaseModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class ModuleAeroBoots( implicit itemAeroBoots: ItemAeroBoots )
	extends BaseModule( Some[ Item ]( itemAeroBoots ), None, None, None )
{}