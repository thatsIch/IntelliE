package de.thatsich.common;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.handler.RegistryBlock;
import de.thatsich.common.handler.RegistryConfig;
import de.thatsich.common.handler.RegistryItem;
import de.thatsich.common.handler.RegistryTileEntity;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedList;


public abstract class AGuiceMod
{
	private final RegistryConfig configs;
	private final RegistryBlock blocks;
	private final RegistryItem items;
	private final RegistryTileEntity tileEntites;

	/**
	 * To make sure that the initialization of Guice-based JavaFX application
	 * works flawlessly, the original init method of the base JavaFX Application
	 * class is overwritten here. All of the
	 */
	protected AGuiceMod ()
	{
		super();

		// Prepare
		final Collection<Module> modules = new LinkedList<>();
		final Injector tempInjector = Guice.createInjector();

		@SuppressWarnings("unchecked")
		final Class<AGuiceMod> clazz = (Class<AGuiceMod>) this.getClass();

		this.isConstructorInjected( this );

		modules.add( new AGuiceMod.bindInstanceClassModule( clazz ) );

		// Propagates initialization of additional modules to the specific
		// subclass of this GuiceApplication instance.
		final Collection<Class<? extends AMinecraftModule>> additionalModuleClasses = this.initModules();
		for ( Class<? extends Module> moduleClass : additionalModuleClasses )
		{
			final Module moduleInstance = tempInjector.getInstance( moduleClass );
			modules.add( moduleInstance );
		}

		// Creates an injector with all of the required modules.
		final Injector injector = Guice.createInjector( modules );

		// Injects all fields annotated with @Inject into this GuiceApplication instance.
		injector.injectMembers( this );

		this.configs = tempInjector.getInstance( RegistryConfig.class );
		this.blocks = tempInjector.getInstance( RegistryBlock.class );
		this.items = tempInjector.getInstance( RegistryItem.class );
		this.tileEntites = tempInjector.getInstance( RegistryTileEntity.class );
		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final HandlerGui gui = tempInjector.getInstance( HandlerGui.class );
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
	 * @return A list of modules (initially empty) that shall be used to
	 * create the injector to be used in the context of this application.
	 */
	public abstract Collection<Class<? extends AMinecraftModule>> initModules ();

	/**
	 * Checks the GuiceApplication instance and makes sure that none of the
	 * constructors is annotated with @Inject!
	 *
	 * @param instance to be checked instance
	 */
	private boolean isConstructorInjected ( AGuiceMod instance )
	{
		final Class<? extends AGuiceMod> classInstance = instance.getClass();
		for ( final Constructor<?> constructor : classInstance.getConstructors() )
		{
			if ( this.isInjectAnnotationPresent( constructor ) )
			{
				throw new IllegalStateException( "GuiceApplication with constructor that is marked with @Inject is not allowed!" );
			}
		}

		return false;
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
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	protected void preInit ( FMLPreInitializationEvent event )
	{
		final File suggConfigFile = event.getSuggestedConfigurationFile();

		this.configs.load( suggConfigFile );
		this.blocks.registerBlocks();
		this.items.registerItems();
		// super.getEntities().register();
		// proxy.initSounds();
		// proxy.initRenders();
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	protected void init ( FMLInitializationEvent event )
	{
		this.tileEntites.registerTileEntities();
		// super.getItems().addNames();
		// super.getBlocks().registerNames();
		// super.getItems().registerRecipes();
		// super.getTileEntities().init();
		// super.getGui().init( this );

		MinecraftForge.EVENT_BUS.register( this );
	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	protected void modLoaded ( FMLPostInitializationEvent event )
	{

	}

	private class bindInstanceClassModule extends AbstractModule
	{
		private final Class<AGuiceMod> clazz;

		bindInstanceClassModule ( final Class<AGuiceMod> clazz )
		{
			super();
			this.clazz = clazz;
		}

		@Override
		protected void configure ()
		{
			final AnnotatedBindingBuilder<AGuiceMod> bindingBuilder = this.bind( this.clazz );
			bindingBuilder.toInstance( AGuiceMod.this );
		}
	}
}
