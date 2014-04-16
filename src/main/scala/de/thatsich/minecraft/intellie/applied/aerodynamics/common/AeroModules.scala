package de.thatsich.minecraft.intellie.applied.aerodynamics.common

import de.thatsich.minecraft.core.module.AModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.AeroChestModule
import de.thatsich.minecraft.core.registries.IRegistries
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.AeroBootsModule

/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
class AeroModules(implicit registries: IRegistries)
	extends AModules
{
	this.add(new AeroChestModule)
	this.add(new AeroBootsModule)
}
