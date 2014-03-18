package de.thatsich.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dagger.Module;
import dagger.ObjectGraph;
import de.thatsich.common.module.IModule;
import de.thatsich.common.registries.RegistryBlock;
import de.thatsich.common.registries.RegistryConfig;
import de.thatsich.common.registries.RegistryItem;
import de.thatsich.common.registries.RegistryModule;
import de.thatsich.common.registries.RegistryTileEntity;
import de.thatsich.common.util.ILog;
import de.thatsich.common.util.IProxy;
import de.thatsich.common.util.LoggerModule;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Minecraft Mod with enabled Dependency Injection namely @Inject
 *
 * @author thatsIch
 * @date 16.03.14.
 */
public abstract class ABaseMod implements IProxy
{
	// Logger
	final ILog log;

	// Registries
	private final RegistryConfig configs;
	private final RegistryBlock blocks;
	private final RegistryItem items;
	private final RegistryTileEntity tileEntites;

	/**
	 * To make sure that the initialization of Guice-based JavaFX application
	 * works flawlessly, the original init method of the base JavaFX Application
	 * class is overwritten here. All of the
	 */
	protected ABaseMod ()
	{
		// Creates an injector with all of the required modules.
		final Collection<IModule> moduleInstances = this.getModuleInstances();
		moduleInstances.add( new LoggerModule() );
		moduleInstances.add( new RegistryModule() );

		final Object[] modules = moduleInstances.toArray();
		final ObjectGraph injector = ObjectGraph.create( modules );

		// Enable Logging
		this.log = injector.get( ILog.class );

		// Inject all Registries
		this.configs = injector.get( RegistryConfig.class );
		this.blocks = injector.get( RegistryBlock.class );
		this.items = injector.get( RegistryItem.class );
		this.tileEntites = injector.get( RegistryTileEntity.class );
		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final HandlerGui gui = tempInjector.getInstance( HandlerGui.class );

		// using injector and modules to instantiate them once
		this.instantiateModules( injector, modules );
	}

	/**
	 * Instantiates module objects
	 *
	 * @param injector ObjectGraph
	 * @param modules  To be instantiated modules
	 */
	private void instantiateModules ( ObjectGraph injector, Object... modules )
	{
		for ( Object obj : modules )
		{
			final Class<?> clazz = obj.getClass();
			if ( clazz.isAnnotationPresent( Module.class ) )
			{
				final Module module = clazz.getAnnotation( Module.class );
				final Class<?>[] injects = module.injects();
				this.instantiateInjections( injector, injects );
			}
		}
	}

	/**
	 * Fed classes are instantiated by ObjectGraph
	 *
	 * @param injector   ObjectGraph
	 * @param injections instantiated class references
	 */
	private void instantiateInjections ( ObjectGraph injector, Class<?>... injections )
	{
		for ( Class<?> injection : injections )
		{
			injector.get( injection );
		}
	}

	/**
	 * Propagates initialization of additional modules to the specific
	 * subclass of this GuiceApplication instance.
	 *
	 * @return ModuleInstances
	 */
	private Collection<IModule> getModuleInstances ()
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
	@Override
	public void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "PreInit Begin" );

		final File suggConfigFile = event.getSuggestedConfigurationFile();
		final Configuration config = this.configs.load( suggConfigFile );

		//		this.items.loadConfig( config );

		this.tileEntites.loadConfig( config );

		this.blocks.registerBlocks();
		this.items.registerItems();

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
	@Override
	public void init ( FMLInitializationEvent event )
	{
		this.log.info( "Init Begin" );

		this.tileEntites.registerTileEntities();
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
	@Override
	public void postInit ( FMLPostInitializationEvent event )
	{
		this.log.info( "PostInit Begin" );
		this.log.info( "PostInit End" );
	}
}
