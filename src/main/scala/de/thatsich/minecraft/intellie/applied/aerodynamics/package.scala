package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.ModuleRegistry
import de.thatsich.minecraft.core.config.IConfig
import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.module.IModule
import de.thatsich.minecraft.core.network.PacketPipeline
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.AeroCreativeTabs
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.ItemAeroBoots
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.ItemAeroChest
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm.ItemAeroHelm
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs.ItemAeroLegs
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 25.04.2014.
 */
package object aerodynamics
{
	implicit val log     : ILog           = new Log( "Aero" )
	implicit val aeroTab : CreativeTabs   = new AeroCreativeTabs
	implicit val pipeline: PacketPipeline = new PacketPipeline

	implicit final val configs: List[ IConfig ] = List( )

	implicit val itemAeroHelm  = new ItemAeroHelm
	implicit val itemAeroChest = new ItemAeroChest
	implicit val itemAeroLegs  = new ItemAeroLegs
	implicit val itemAeroBoots = new ItemAeroBoots

	implicit final val modules   : List[ IModule ] = List( )
	implicit final val registries: ModuleRegistry  = new ModuleRegistry
}
