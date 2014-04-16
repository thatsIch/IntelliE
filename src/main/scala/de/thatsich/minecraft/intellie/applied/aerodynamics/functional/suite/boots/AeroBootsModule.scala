package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots

import de.thatsich.minecraft.core.registries.IRegistries
import de.thatsich.minecraft.core.module.AModule
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class AeroBootsModule(implicit itemAeroBoots: ItemAeroBoots, registries: IRegistries)
	extends AModule(Some[ Item ](itemAeroBoots), None, None, None)
{}