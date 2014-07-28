package de.thatsich.minecraft

import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.{Abbreviation, Configs, Modules}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern._
import de.thatsich.minecraft.intellie.intern.{IEAbbreviation, IEConfigs, IEModules}

/**
 *
 *
 * @author thatsIch
 * @since 25.07.2014.
 */
package object intellie
{
	implicit lazy val abbreviation: Abbreviation = new IEAbbreviation
	implicit      val configs     : Configs      = new IEConfigs
	implicit      val itemStacks  : ItemStacks   = new ItemStacks

	implicit val log: Log = new AeroLog( abbreviation )

	implicit val modules: Modules = new IEModules( )
}
