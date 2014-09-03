package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.common.string.id.SimpleID
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.ModificationWorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab.{AeroCreativeTabIcon, AeroCreativeTabsModule}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler.DisassemblerModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.FakeUpgradeModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.SuiteModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.{AeroAbbreviation, AeroCreativeTabs}


/**
 * Proxy class shared beetween server and client
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
abstract class AeroCommonProxy extends CommonProxy
{
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	final lazy val mod = AppliedAerodynamics
	final lazy val modid = new SimpleID(this.mod.id)

	private final lazy val icon = new AeroCreativeTabIcon(this.modid)

	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	final lazy val modules: Seq[Module] = Vector(
		new DisassemblerModule(this.log, this.modid),
		new ModificationWorkbenchModule(this.log, this.modid),
		new FakeUpgradeModule(this.log, this.modid),
		new SuiteModule(this.modid, this.log),
		new AeroCreativeTabsModule(this.icon, this.log, this.modid)
	)
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	final lazy val abbr: Abbreviation = new AeroAbbreviation

	/**
	 * Creative tab of Aerodynamics
	 */
	new AeroCreativeTabs(this.icon, this.registry.blocks, this.registry.items, this.log, this.modid)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit = {}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit = {}

	def onInheritatedInit(event: FMLInitializationEvent): Unit = {}
}
