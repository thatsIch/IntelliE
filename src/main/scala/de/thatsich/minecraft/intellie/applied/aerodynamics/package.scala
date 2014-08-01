package de.thatsich.minecraft.intellie.applied

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.ModuleRegistry
import de.thatsich.minecraft.api.mod.{Abbreviation, Configs, Modules}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern._
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.DissemblerModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.chest.AeroChestItem
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 16.07.2014.
 */
package object aerodynamics
{
	implicit lazy val abbreviation: Abbreviation = new AeroAbbreviation
	implicit      val configs     : Configs      = new AeroConfigs
	implicit      val itemStacks  : ItemStacks   = new ItemStacks

	implicit val log: Log = new AeroLog( abbreviation )

	implicit val modules: Modules = new AeroModules( new DissemblerModule )

	// requires AeroChestItem
	val chest: AeroChestItem = new AeroChestItem

	implicit val tab: CreativeTabs = new AeroCreativeTabs( chest )

	//		dissembler.setCreativeTab( tab )
	//	GameRegistry.registerItem( itemStacks.dissembler, itemStacks.dissembler.getUnlocalizedName )
}
