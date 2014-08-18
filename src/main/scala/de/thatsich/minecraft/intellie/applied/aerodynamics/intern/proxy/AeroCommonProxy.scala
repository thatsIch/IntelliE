package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLServerStartingEvent, FMLPostInitializationEvent, FMLInitializationEvent}
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.ModificationWorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab.{AeroCreativeTabsModule, AeroCreativeTabIcon}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler.DisassemblerModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.FakeUpgradeModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.SuiteModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.{AeroAbbreviation, AeroCreativeTabs, AeroID}


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
abstract class AeroCommonProxy extends CommonProxy
{
	private final val icon = new AeroCreativeTabIcon

	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	final lazy val modules: Seq[Module] = Seq(
		new DisassemblerModule(this.log, this.modid),
		new ModificationWorkbenchModule(this.log, this.modid),
		new FakeUpgradeModule(this.log, this.modid),
		new SuiteModule(this.log, this.modid),
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
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	final val mod = AppliedAerodynamics
	final val modid = new AeroID

	new AeroCreativeTabs(this.icon, this.modules, this.log, this.modid)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit = {}

	def onInheritatedServerStarting(event: FMLServerStartingEvent): Unit = {}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit = {}

	def onInheritatedInit(event: FMLInitializationEvent): Unit = {}
}
