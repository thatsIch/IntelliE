package de.thatsich.minecraft.common.proxy


import com.google.common.base.Stopwatch
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}
import cpw.mods.fml.common.network.{IGuiHandler, NetworkRegistry}
import de.thatsich.minecraft.common.log.{Log, SimpleLog}
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.module.registry.{BlockRegistry, CraftHandlerRegistry, GuiRegistry, ItemRegistry, RecipeRegistry, TileEntityRegistry}
import de.thatsich.minecraft.common.string.Abbreviation


/**
 *
 *
 * @author thatsIch
 * @since 07.08.2014.
 */
abstract class CommonProxy extends EventProxy
{
	final lazy val log: Log = new SimpleLog(this.abbr)
	final val stopwatch: Stopwatch = Stopwatch.createUnstarted
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	val modules: Seq[Module]
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	val abbr: Abbreviation
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	val mod: AnyRef

	def onPreInit(event: FMLPreInitializationEvent): Unit =
	{
		this.log.info("PreInit Begin")
		this.stopwatch.reset.start

		val items: ItemRegistry = new ItemRegistry(this.modules, this.log)
		val blocks: BlockRegistry = new BlockRegistry(this.modules, this.log)

		items.registerAll()
		blocks.registerAll()

		this.stopwatch.stop
		this.log.info(s"PreInit End ($stopwatch)")
	}

	def onInit(event: FMLInitializationEvent): Unit =
	{
		this.log.info("Init Begin")
		this.stopwatch.reset.start

		val craftHandlers: CraftHandlerRegistry = new CraftHandlerRegistry(this.modules, this.log)
		val recipes: RecipeRegistry = new RecipeRegistry(this.modules, this.log)
		val tiles: TileEntityRegistry = new TileEntityRegistry(this.modules, this.log)
		val guis: GuiRegistry = new GuiRegistry(this.modules, this.log)

		craftHandlers.registerAll()
		recipes.registerAll()
		tiles.registerAll()
		val handler: IGuiHandler = guis.registerAll()
		NetworkRegistry.INSTANCE.registerGuiHandler(this.mod, handler)

		this.stopwatch.stop
		this.log.info(s"Init End ($stopwatch)")
	}

	def onPostInit(event: FMLPostInitializationEvent): Unit =
	{
		this.log.info("PostInit Begin")
		this.stopwatch.reset.start

		this.stopwatch.stop
		this.log.info(s"PostInit End ($stopwatch)")
	}

	def onServerStarting(event: FMLServerStartingEvent): Unit =
	{
		this.log.info("ServerStarting Begin")
		this.stopwatch.reset.start

		this.stopwatch.stop
		this.log.info(s"ServerStarting End ($stopwatch)")
	}
}
