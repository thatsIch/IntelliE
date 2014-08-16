package de.thatsich.minecraft.common.proxy


import com.google.common.base.Stopwatch
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.{IGuiHandler, NetworkRegistry}
import de.thatsich.minecraft.common.log.{Log, NamedLog}
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
	protected final lazy val log: Log = new NamedLog(this.abbr)
	protected final val stopwatch: Stopwatch = Stopwatch.createUnstarted
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
	protected val abbr: Abbreviation
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	protected val mod: AnyRef

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit(event: FMLPreInitializationEvent): Unit =
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

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init(event: FMLInitializationEvent): Unit =
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

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit(event: FMLPostInitializationEvent): Unit =
	{
		this.log.info("PostInit Begin")
		this.stopwatch.reset.start

		this.stopwatch.stop
		this.log.info(s"PostInit End ($stopwatch)")
	}
}
