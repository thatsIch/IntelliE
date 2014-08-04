package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern._
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench.ModificationWorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.DissemblerModule

/**
 *
 *
 * @author thatsIch
 * @since 16.07.2014.
 */
package object aerodynamics
{
	val abbreviation: Abbreviation = new AeroAbbreviation

	implicit val log: Log = new AeroLog( abbreviation )

	implicit val modules: Modules = new AeroModules(
		new DissemblerModule,
		new ModificationWorkbenchModule
	)

	val icon = new AeroCreativeTabIcon
	new AeroCreativeTabs( icon, modules, log )
}
