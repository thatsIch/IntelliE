package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.{AeroCreativeTabs, AeroModules, OAeroConfigFiles}
import de.thatsich.minecraft.core.module.IModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.ItemAeroChest
import de.thatsich.minecraft.core.network.PacketPipeline
import net.minecraft.creativetab.CreativeTabs
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.ItemAeroBoots
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm.ItemAeroHelm
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs.ItemAeroLegs

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object aerodynamics
{
	implicit val log        : ILog           = new Log("Aero")
	implicit val aeroTab    : CreativeTabs   = new AeroCreativeTabs
	implicit val pipeline   : PacketPipeline = new PacketPipeline
	implicit val registries : IRegistries    = new Registries
	implicit val configFiles: IConfigFiles   = OAeroConfigFiles

	implicit val itemAeroHelm  = new ItemAeroHelm
	implicit val itemAeroChest = new ItemAeroChest
	implicit val itemAeroLegs  = new ItemAeroLegs
	implicit val itemAeroBoots = new ItemAeroBoots

	implicit val modules: IModules = new AeroModules
}
