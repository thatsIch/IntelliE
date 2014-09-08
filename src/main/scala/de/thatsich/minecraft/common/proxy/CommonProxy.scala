package de.thatsich.minecraft.common.proxy


import com.google.common.base.Stopwatch
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.{IGuiHandler, NetworkRegistry}
import de.thatsich.minecraft.common.log.{Log, SimpleLog}
import de.thatsich.minecraft.common.module.ModuleRegistry
import de.thatsich.minecraft.intellie.common.Modules
import de.thatsich.minecraft.intellie.common.util.string.{Abbreviation, ID}


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
abstract class CommonProxy extends EventProxy
{
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	val abbr: Abbreviation

	final lazy val log: Log = new SimpleLog(this.abbr)
	private val stopwatch: Stopwatch = Stopwatch.createUnstarted
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	val modules: Modules

	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	val mod: AnyRef

	/**
	 * ID of the mod
	 */
	val modid: ID

	val registry = new ModuleRegistry(this.modules, this.modid, this.log)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit

	def onInheritatedInit(event: FMLInitializationEvent): Unit

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit

	final def onPreInit(event: FMLPreInitializationEvent): Unit =
	{
		this.log.info("PreInit Begin")
		this.stopwatch.reset.start

		this.registry.itemRegistry.registerAll()
		this.registry.blockRegistry.registerAll()
		this.registry.fakeRegistry.registerAll()

		this.onInheritatedPreInit(event)

		this.stopwatch.stop
		this.log.info(s"PreInit End ($stopwatch)")
	}

	final def onInit(event: FMLInitializationEvent): Unit =
	{
		this.log.info("Init Begin")
		this.stopwatch.reset.start

		this.registry.craftRegistry.registerAll()
		this.registry.recipeRegistry.registerAll()
		this.registry.tileRegistry.registerAll()
		val handler: IGuiHandler = this.registry.guiRegistry.registerAll()

		NetworkRegistry.INSTANCE.registerGuiHandler(this.mod, handler)

		this.onInheritatedInit(event)

		this.stopwatch.stop
		this.log.info(s"Init End ($stopwatch)")
	}

	final def onPostInit(event: FMLPostInitializationEvent): Unit =
	{
		this.log.info("PostInit Begin")
		this.stopwatch.reset.start

		this.onInheritatedPostInit(event)

		this.stopwatch.stop
		this.log.info(s"PostInit End ($stopwatch)")
	}
}
