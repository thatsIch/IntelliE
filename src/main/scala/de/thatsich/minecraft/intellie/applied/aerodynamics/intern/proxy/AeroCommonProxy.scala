package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
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
	protected final val abbr: Abbreviation = new AeroAbbreviation
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	protected final val modules: Modules = new AeroModules(
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
	new AeroCreativeTabs(this.icon, this.modules, this.log, mod.id)

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	override def preInit(event: FMLPreInitializationEvent): Unit =
	{
		super.preInit(event)
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	override def init(event: FMLInitializationEvent): Unit =
	{
		super.init(event)
	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	override def postInit(event: FMLPostInitializationEvent): Unit =
	{
		super.postInit(event)
	}
}
