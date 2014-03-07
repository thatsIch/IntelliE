package de.thatsich.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dagger.ObjectGraph;
import de.thatsich.common.module.IModule;
import de.thatsich.common.registries.RegistryBlock;
import de.thatsich.common.registries.RegistryConfig;
import de.thatsich.common.registries.RegistryItem;
import de.thatsich.common.registries.RegistryModule;
import de.thatsich.common.registries.RegistryTileEntity;
import de.thatsich.common.util.ILog;
import de.thatsich.common.util.LoggerModule;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Minecraft Mod with enabled Dependency Injection namely @Inject
 */
public abstract class AInjectionMod
{
	private final RegistryConfig configs;
	private final RegistryBlock blocks;
	private final RegistryItem items;
	private final RegistryTileEntity tileEntites;
	private final ILog log;

	/**
	 * To make sure that the initialization of Guice-based JavaFX application
	 * works flawlessly, the original init method of the base JavaFX Application
	 * class is overwritten here. All of the
	 */
	protected AInjectionMod ()
	{
		// Creates an injector with all of the required modules.
		final Object[] modules = this.getModuleInstances().toArray();
		ObjectGraph injector = ObjectGraph.create( new LoggerModule(), new RegistryModule(), modules );

		// Enable Logging
		this.log = injector.get( ILog.class );

		// Inject all Registries
		this.configs = injector.get( RegistryConfig.class );
		this.blocks = injector.get( RegistryBlock.class );
		this.items = injector.get( RegistryItem.class );
		this.tileEntites = injector.get( RegistryTileEntity.class );
		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final HandlerGui gui = tempInjector.getInstance( HandlerGui.class );
	}

	/**
	 * Propagates initialization of additional modules to the specific
	 * subclass of this GuiceApplication instance.
	 *
	 * @return ModuleInstances
	 */
	private Collection<? extends IModule> getModuleInstances ()
	{
		// Preprare
		final Collection<IModule> instances = new LinkedList<>();

		// Fetch all ModuleClasses
		this.initModules( instances );

		// Finalize
		return instances;
	}

	/**
	 * This method is used to fetch and/or create (Guice) modules necessary
	 * to fully construct this application.
	 * <p>
	 * The modules that are initialized in this method and added to the passed
	 * List will be used to create the {@link dagger.ObjectGraph} instance that is used in
	 * the context of this application.
	 * </p>
	 *
	 * @param modules A list of modules (initially empty) that shall be used to
	 *                create the injector to be used in the context of this application.
	 */
	protected abstract void initModules ( Collection<IModule> modules );

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	protected void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "PreInit Begin" );
		final File suggConfigFile = event.getSuggestedConfigurationFile();
		final Configuration config = this.configs.load( suggConfigFile );
		this.blocks.registerBlocks();
		this.items.registerItems();
		this.tileEntites.loadConfig( config );
		// super.getEntities().register();
		// proxy.initSounds();
		// proxy.initRenders();
		this.log.info( "PreInit End" );
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	protected void init ( FMLInitializationEvent event )
	{
		this.log.info( "Init Begin" );
		this.tileEntites.registerTileEntities();
		// super.getItems().addNames();
		// super.getBlocks().registerNames();
		// super.getItems().registerRecipes();
		// super.getTileEntities().init();
		// super.getGui().init( this );

		MinecraftForge.EVENT_BUS.register( this );
		this.log.info( "Init End" );
	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	protected void modLoaded ( FMLPostInitializationEvent event )
	{
		this.log.info( "Loaded Begin" );
		this.log.info( "Loaded End" );
	}
}
