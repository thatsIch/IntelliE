package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.{Module, ModuleRegistry}
import de.thatsich.minecraft.api.mod.network.PacketPipeline
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.AeroCreativeTabs
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.dissembler.ItemDissembler
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.{ItemAeroBoots, ModuleAeroBoots}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.{AeroChestModule, ItemAeroChest}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm.{AeroHelmModule, ItemAeroHelm}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs.{AeroLegsModule, ItemAeroLegs}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.{AeroLog, AeroPacketPipeline}
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
	implicit val log     : Log            = AeroLog
	implicit val aeroTab : CreativeTabs   = new AeroCreativeTabs
	implicit val pipeline: PacketPipeline = AeroPacketPipeline

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
