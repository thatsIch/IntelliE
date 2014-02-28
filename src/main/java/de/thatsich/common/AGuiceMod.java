package de.thatsich.common;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.handler.RegistryBlock;
import de.thatsich.common.handler.RegistryConfig;
import de.thatsich.common.handler.RegistryItem;
import de.thatsich.common.handler.RegistryTileEntity;
import de.thatsich.common.util.Logger;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Minecraft Mod with enabled Guice Injection namely @Inject
 */
public abstract class AGuiceMod
{
	private final RegistryConfig configs;
	private final RegistryBlock blocks;
	private final RegistryItem items;
	private final RegistryTileEntity tileEntites;
	private final Logger log;

	/**
	 * To make sure that the initialization of Guice-based JavaFX application
	 * works flawlessly, the original init method of the base JavaFX Application
	 * class is overwritten here. All of the
	 */
	protected AGuiceMod ()
	{
		if ( this.isConstructorInjected() )
		{
			throw new IllegalStateException( "GuiceApplication with constructor that is marked with @Inject is not allowed!" );
		}

		// Creates an injector with all of the required modules.
		final Collection<? extends Module> modules = this.getModuleInstances();
		final Injector injector = Guice.createInjector( modules );

		// Enable Logging
		this.log = injector.getInstance( Logger.class );

		// Injects all fields annotated with @Inject into this GuiceApplication instance.
		injector.injectMembers( this );

		// Inject all Registries
		this.configs = injector.getInstance( RegistryConfig.class );
		this.blocks = injector.getInstance( RegistryBlock.class );
		this.items = injector.getInstance( RegistryItem.class );
		this.tileEntites = injector.getInstance( RegistryTileEntity.class );
		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final HandlerGui gui = tempInjector.getInstance( HandlerGui.class );
	}

	/**
	 * Checks the GuiceApplication instance and makes sure that none of the
	 * constructors is annotated with @Inject!
	 */
	private boolean isConstructorInjected ()
	{
		final Class<? extends AGuiceMod> classInstance = this.getClass();
		boolean result = false;

		for ( final Constructor<?> constructor : classInstance.getConstructors() )
		{
			if ( this.isInjectAnnotationPresent( constructor ) )
			{
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * Helper method to determine whether a given {@link java.lang.reflect.AccessibleObject} is
	 * annotated
	 * with one of the Inject annotations known by Guice.
	 *
	 * @param object Accessible object to be analyzed. Must not be {@code null}
	 *
	 * @return {@code true} if the given constructor is annotated with an Inject
	 * annotation, {@code false} otherwise.
	 *
	 * @see Inject
	 */
	private boolean isInjectAnnotationPresent ( final AnnotatedElement object )
	{
		return object.isAnnotationPresent( Inject.class );
	}

	/**
	 * Propagates initialization of additional modules to the specific
	 * subclass of this GuiceApplication instance.
	 *
	 * @return ModuleInstances
	 */
	private Collection<? extends Module> getModuleInstances ()
	{
		// Preprare
		final Injector injector = Guice.createInjector();
		final Collection<Module> instances = new LinkedList<>();
		final Collection<Class<? extends AMinecraftModule>> classModules = new LinkedList<>();

		// Fetch all ModuleClasses
		this.initModules( classModules);

		// Process
		for ( Class<? extends Module> moduleClass : classModules )
		{
			final Module moduleInstance = injector.getInstance( moduleClass );
			instances.add( moduleInstance );
		}

		// Finalize
		return instances;
	}

	/**
	 * This method is used to fetch and/or create (Guice) modules necessary
	 * to fully construct this application.
	 * <p>
	 * The modules that are initialized in this method and added to the passed
	 * List will be used to create the {@link com.google.inject.Injector} instance that is used in
	 * the context of this application.
	 * </p>
	 *
	 * @param modules A list of modules (initially empty) that shall be used to
	 * create the injector to be used in the context of this application.
	 */
	protected abstract void initModules ( Collection<Class<? extends AMinecraftModule>> modules);

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	protected void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "preinit begin" );
		final File suggConfigFile = event.getSuggestedConfigurationFile();

		this.configs.load( suggConfigFile );
		this.blocks.registerBlocks();
		this.items.registerItems();
		// super.getEntities().register();
		// proxy.initSounds();
		// proxy.initRenders();
		this.log.info( "preinit end" );
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	protected void init ( FMLInitializationEvent event )
	{
		this.log.info( "init begin" );
		this.tileEntites.registerTileEntities();
		// super.getItems().addNames();
		// super.getBlocks().registerNames();
		// super.getItems().registerRecipes();
		// super.getTileEntities().init();
		// super.getGui().init( this );

		MinecraftForge.EVENT_BUS.register( this );
		this.log.info( "init end" );
	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	protected void modLoaded ( FMLPostInitializationEvent event )
	{
		this.log.info( "loaded begin" );
		this.log.info( "loaded end" );
	}
}
