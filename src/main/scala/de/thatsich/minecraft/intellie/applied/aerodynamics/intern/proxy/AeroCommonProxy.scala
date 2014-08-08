package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench.ModificationWorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.DissemblerModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.{AeroAbbreviation, AeroCreativeTabIcon, AeroCreativeTabs, AeroModules}


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
abstract class AeroCommonProxy extends CommonProxy
{
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	protected final lazy val abbr: Abbreviation = new AeroAbbreviation
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	protected final lazy val modules: Modules = new AeroModules(
		new DissemblerModule,
		new ModificationWorkbenchModule
	)
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	protected final val mod = AppliedAerodynamics
	private final val icon = new AeroCreativeTabIcon
	new AeroCreativeTabs(this.icon, this.modules, this.log, this.mod.id)
}
