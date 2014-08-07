package de.thatsich.minecraft.common.proxy


import appeng.api.AEApi
import com.google.common.base.Stopwatch
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.{Log, NamedLog}
import de.thatsich.minecraft.common.module.registries.{GuiRegistry, TileEntityRegistry, RecipeRegistry, BlockRegistry, ItemRegistry}
import de.thatsich.minecraft.common.string.Abbreviation


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
	def abbr: Abbreviation

	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	def modules: Modules

	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	def mod: AnyRef

	protected final val log: Log = new NamedLog(this.abbr)
	protected final val stopwatch: Stopwatch = Stopwatch.createUnstarted

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

		val items: ItemRegistry = new ItemRegistry
		val blocks: BlockRegistry = new BlockRegistry

		items.registerItems(this.modules)
		blocks.registerBlocks(this.modules)

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

		val recipes: RecipeRegistry = new RecipeRegistry
		val tiles: TileEntityRegistry = new TileEntityRegistry
		val guis: GuiRegistry = new GuiRegistry

		recipes.registerRecipes(this.modules)
		tiles.registerTileEntities(this.modules)
		guis.registerGuis(this.modules)

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
