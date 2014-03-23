package de.thatsich.intellie.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dagger.Module;
import dagger.ObjectGraph;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.RegistryBlock;
import de.thatsich.intellie.common.registries.RegistryConfig;
import de.thatsich.intellie.common.registries.RegistryConfigFactory;
import de.thatsich.intellie.common.registries.RegistryItem;
import de.thatsich.intellie.common.registries.RegistryModule;
import de.thatsich.intellie.common.registries.RegistryTileEntity;
import de.thatsich.intellie.common.util.ICommonProxy;
import de.thatsich.intellie.common.util.IProxy;
import de.thatsich.intellie.common.util.logging.ILog;
import de.thatsich.intellie.common.util.logging.LoggerModule;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
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
		final Collection<IModule> moduleInstances = this.getClassModule();

		moduleInstances.add( new LoggerModule() );
		moduleInstances.add( new RegistryModule() );

		final Object[] modules = moduleInstances.toArray();
		final ObjectGraph injector = ObjectGraph.create( modules );

		// Enable Logging
		this.log = injector.get( ILog.class );

		// Inject all Registries
		this.configs = injector.get( RegistryConfigFactory.class ).get( "Test" );
		this.blocks = injector.get( RegistryBlock.class );
		this.items = injector.get( RegistryItem.class );
		this.tileEntites = injector.get( RegistryTileEntity.class );
		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final HandlerGui gui = tempInjector.getInstance( HandlerGui.class );

		// using injector and modules to instantiate them once
		this.instantiateModules( injector, modules );
	}

	/**
	 * Derives the needed module from the child classname
	 *
	 * If Mod is called <b>MyMod</b> then the required module name is <b>MyModModule</b> in the same package
	 *
	 * @return Collection of the mod module. Is empty when attempt to fetch failed.
	 */
	private Collection<IModule> getClassModule ()
	{
		final Collection<IModule> moduleInstances = new LinkedList<>();

		final String childName = this.getClass().getName();
		final String moduleName = childName + "Module";

		try
		{
			final IModule module = (IModule) Class.forName( moduleName ).getConstructor().newInstance();
			moduleInstances.add( module );
		}
		catch ( InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e )
		{
			e.printStackTrace();
		}

		return moduleInstances;
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
			final Object injected = injector.get( injection );
		}
	}

	protected abstract ICommonProxy getProxy ();

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

	@Override
	public void postInit ( FMLPostInitializationEvent event )
	{
		this.log.info( "PostInit Begin" );
		this.log.info( "PostInit End" );
	}
}
