package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.common.string.id.SimpleID
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.AeroModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab.AeroCreativeTabIcon
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.{AeroAbbreviation, AeroCreativeTabs, AppliedAerodynamicsModules}
import de.thatsich.minecraft.intellie.applied.aerodynamics.{AeroProxy, AppliedAerodynamics}


/**
 * Proxy class shared beetween server and client
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
abstract class AeroCommonProxy extends CommonProxy with AeroProxy
{
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	final lazy val mod = AppliedAerodynamics
	final lazy val modid = new SimpleID(this.mod.id)
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	final lazy val modules: AeroModules = new AppliedAerodynamicsModules(this.icon, this.modid, this.log)
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	final lazy val abbr: Abbreviation = new AeroAbbreviation
	private final lazy val icon = new AeroCreativeTabIcon(this.modid)

	/**
	 * Creative tab of Aerodynamics
	 */
	new AeroCreativeTabs(this.icon, this.registry.blocks, this.registry.items, this.log, this.modid)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit =
	{}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit =
	{}

	def onInheritatedInit(event: FMLInitializationEvent): Unit =
	{}
}
