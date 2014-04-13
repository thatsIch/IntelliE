package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import de.thatsich.minecraft.core.module.AModule
import de.thatsich.minecraft.core.registries.IRegistries
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
class AeroChestModule(implicit itemAeroChest: ItemAeroChest, registries: IRegistries)
	extends AModule(Some[ Item ](itemAeroChest), None, None, None)
{}
