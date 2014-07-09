package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.log.{BaseLog, Log}
import de.thatsich.minecraft.api.mod.network.PacketPipeline
import de.thatsich.minecraft.core.ModuleRegistry
import de.thatsich.minecraft.core.module.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.AeroCreativeTabs
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.dissembler.ItemDissembler
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.{ItemAeroBoots, ModuleAeroBoots}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.{AeroChestModule, ItemAeroChest}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm.{AeroHelmModule, ItemAeroHelm}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs.{AeroLegsModule, ItemAeroLegs}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 25.04.2014.
 */
package object aerodynamics
{
	implicit val log     : Log            = new BaseLog( "Aero" )
	implicit val aeroTab : CreativeTabs   = new AeroCreativeTabs
	implicit val pipeline: PacketPipeline = new PacketPipeline

	implicit final val configs: List[ Config ] = List( )

	implicit val itemAeroHelm  = new ItemAeroHelm
	implicit val itemAeroChest = new ItemAeroChest
	implicit val itemAeroLegs  = new ItemAeroLegs
	implicit val itemAeroBoots = new ItemAeroBoots

	implicit val itemDissembler = ItemDissembler

	implicit val stackDissembler = new ItemStack( itemDissembler )

	implicit final val modules   : List[ Module ] = List(
		new ModuleAeroBoots,
		new AeroChestModule,
		new AeroHelmModule,
		new AeroLegsModule
	)
	implicit final val registries: ModuleRegistry = new ModuleRegistry
}
