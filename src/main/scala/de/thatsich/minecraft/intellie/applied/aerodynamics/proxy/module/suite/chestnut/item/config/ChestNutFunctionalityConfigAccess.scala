package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private [chestnut]
class ChestNutFunctionalityConfigAccess(config: Config)
extends ChestNutFunctionalityConfig
{
//	val minimalWalkSpeed = this.config.getFloat("Functionality", "minimalWalkSpeed", 0.1F)
//	val minimalRunSpeed = this.config.getFloat("Functionality", "minimalRunSpeed", 0.15F)
//	val maximalRunSpeed = this.config.getFloat("Functionality", "maximalRunSpeed", 0.2F)
//	val maximalWalkSpeed = this.config.getFloat("Functionality", "maximalWalkSpeed", 0.11F)

	this.config.save()
}
