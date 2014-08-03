package de.thatsich.minecraft

import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.Modules
import de.thatsich.minecraft.api.mod.util.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern._
import de.thatsich.minecraft.intellie.intern.{IEAbbreviation, IEModules}

/**
 *
 *
 * @author thatsIch
 * @since 25.07.2014.
 */
package object intellie
{
	val abbreviation: Abbreviation = new IEAbbreviation

	implicit val log: Log = new AeroLog( abbreviation )

	implicit val modules: Modules = new IEModules( )
}
