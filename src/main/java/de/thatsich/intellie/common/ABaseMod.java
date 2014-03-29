package de.thatsich.intellie.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dagger.Module;
import dagger.ObjectGraph;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.BlockRegistry;
import de.thatsich.intellie.common.registries.ConfigRegistry;
import de.thatsich.intellie.common.registries.ItemRegistry;
import de.thatsich.intellie.common.registries.RegistryModule;
import de.thatsich.intellie.common.registries.TileEntityRegistry;
import de.thatsich.intellie.common.util.ICommonProxy;
import de.thatsich.intellie.common.util.IProxy;
import de.thatsich.intellie.common.util.logging.ILogger;
import de.thatsich.intellie.common.util.logging.LoggerModule;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;

/**
 Minecraft Mod with enabled Dependency Injection namely @Inject

 @author thatsIch
 @date 16.03.14. */
public abstract class ABaseMod implements IProxy
{
	private static final Character[] CHARACTERS = new Character[0];
	// Logger
	final ILogger log;
	// Injector
	private final ObjectGraph injector;
	// Registries
	private final ConfigRegistry configs;
	private final BlockRegistry blocks;
	private final ItemRegistry items;
	private final TileEntityRegistry tileEntites;

	/**
	 To make sure that the initialization of Guice-based JavaFX application
	 works flawlessly, the original init method of the base JavaFX Application
	 class is overwritten here. All of the
	 */
	protected ABaseMod ()
	{
		final String modName = this.getModAcronym();

		// Creates an injector with all of the required modules.
		final Collection<IModule> moduleInstances = this.getClassModule();

		moduleInstances.add( new BaseModInstanceModule( this ) );
		moduleInstances.add( new RegistryModule( modName ) );
		moduleInstances.add( new LoggerModule( modName ) );

		final Object[] modules = moduleInstances.toArray();
		this.injector = ObjectGraph.create( modules );

		// Enable Logging
		this.log = this.injector.get( ILogger.class );

		// Inject all Registries
		this.configs = this.injector.get( ConfigRegistry.class );
		this.blocks = this.injector.get( BlockRegistry.class );
		this.items = this.injector.get( ItemRegistry.class );
		this.tileEntites = this.injector.get( TileEntityRegistry.class );

		//		final RegistryEntity entities = tempInjector.getInstance( RegistryEntity.class );
		//		final GuiRegistry gui = tempInjector.getInstance( GuiRegistry.class );

		// using injector and modules to instantiate them once
		this.instantiateModules( modules );
	}

	/**
	 Derives the needed module from the child classname

	 If Mod is called <b>MyMod</b> then the required module name is <b>MyModModule</b> in the same package

	 @return Collection of the mod module. Is empty when attempt to fetch failed.
	 */
	private Collection<IModule> getClassModule ()
	{
		final Collection<IModule> moduleInstances = new LinkedList<>();

		final String childName = this.getClass().getName();
		final String moduleName = childName + "Module";
		final String id = this.getModAcronym();

		try
		{
			final Class<?> clazz = Class.forName( moduleName );
			final Constructor<?> ctor = clazz.getConstructor( String.class );
			final Object instance = ctor.newInstance( id );
			final IModule module = (IModule) instance;

			moduleInstances.add( module );
		}
		catch ( InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e )
		{
			e.printStackTrace();
		}

		return moduleInstances;
	}

	/**
	 Instantiates module objects

	 @param modules To be instantiated modules
	 */
	private void instantiateModules ( Object... modules )
	{
		for ( Object obj : modules )
		{
			final Class<?> clazz = obj.getClass();
			if ( clazz.isAnnotationPresent( Module.class ) )
			{
				final Module module = clazz.getAnnotation( Module.class );
				final Class<?>[] injects = module.injects();
				this.instantiateInjections( injects );
			}
		}
	}

	/**
	 Fed classes are instantiated by ObjectGraph

	 @param injections instantiated class references
	 */
	private void instantiateInjections ( Class<?>... injections )
	{
		for ( Class<?> injection : injections )
		{
			final Object injected = this.injector.get( injection );
		}
	}

	/**
	 Retrieves the modname from the @Mod Annotation
	 If Modname is too long, it takes the first letters of each capital word
	 MyMod will generate MM

	 @return Modname
	 */
	private String getModAcronym ()
	{
		final Mod annotation = this.getClass().getAnnotation( Mod.class );
		final String name = annotation.name();

		return this.toAcronym( name );
	}

	/**
	 converts a camelcase into an abreviation

	 @param camelCaseString to be converted string

	 @return an abbreviated version of the camelcasestring
	 */
	private String toAcronym ( final String camelCaseString )
	{
		final char[] cArray = camelCaseString.toCharArray();
		final StringBuilder builder = new StringBuilder( 1 );

		for ( char c : cArray )
		{
			if ( Character.isUpperCase( c ) )
			{
				builder.append( c );
			}
		}

		return builder.toString();
	}

	/**
	 Instantiates a creative tab

	 @param tabClass class of the tab
	 */
	protected void addTab ( Class<? extends CreativeTabs> tabClass )
	{
		final CreativeTabs tab = this.injector.get( tabClass );
	}

	@Override
	public void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "PreInit Begin" );

		final File suggConfigFile = event.getSuggestedConfigurationFile();
		final Configuration config = this.configs.load( suggConfigFile );

		//		this.items.loadConfig( config );

		this.tileEntites.loadConfig( config );

		this.blocks.register();
		this.items.register();

		final ICommonProxy proxy = this.getProxy();

		// proxy.initSounds();
		// proxy.initRenders();

		this.log.info( "PreInit End" );
	}

	/**
	 retrieves the proxy class of the child by reflecting it

	 @return proxy
	 */
	private ICommonProxy getProxy ()
	{
		final Class<? extends ABaseMod> clazz = this.getClass();
		final Field[] potentialProxy = clazz.getDeclaredFields();

		// search for the proxy field
		for ( Field field : potentialProxy )
		{
			try
			{
				final Object object = field.get( null );
				if ( object instanceof ICommonProxy )
				{
					return (ICommonProxy) object;
				}
			}
			catch ( IllegalAccessException e )
			{
				e.printStackTrace();
			}
		}

		this.log.warn( "No proxy found." );
		throw new IllegalArgumentException( "No proxy was given." );
	}

	@Override
	public void init ( FMLInitializationEvent event )
	{
		this.log.info( "Init Begin" );

		this.tileEntites.registerTileEntities();
		// super.getItems().registerRecipes();

		// super.getTileEntities().init();
		// super.getGui().init( this );
		//		this.recipeRegistry.register();

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
