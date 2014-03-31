package de.thatsich.intellie.common;

import com.google.common.base.Joiner;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dagger.Module;
import dagger.ObjectGraph;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.ArmorRenderingRegistry;
import de.thatsich.intellie.common.registries.BlockContainerRegistry;
import de.thatsich.intellie.common.registries.BlockRegistry;
import de.thatsich.intellie.common.registries.BlockRenderingRegistry;
import de.thatsich.intellie.common.registries.ConfigRegistry;
import de.thatsich.intellie.common.registries.EntityRenderingRegistry;
import de.thatsich.intellie.common.registries.GuiRegistry;
import de.thatsich.intellie.common.registries.ItemRegistry;
import de.thatsich.intellie.common.registries.RegistryModule;
import de.thatsich.intellie.common.registries.SoundRegistry;
import de.thatsich.intellie.common.registries.TileEntityRegistry;
import de.thatsich.intellie.common.util.ICommonProxy;
import de.thatsich.intellie.common.util.IProxy;
import de.thatsich.intellie.common.util.logging.ILog;
import de.thatsich.intellie.common.util.logging.LoggerModule;
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
	// Log
	final ILog log;
	// Injector
	private final ObjectGraph injector;
	// Registries
	private final ArmorRenderingRegistry armorRenderers;
	private final BlockContainerRegistry blockContainers;
	private final BlockRegistry blocks;
	private final BlockRenderingRegistry blockRenderers;
	private final ConfigRegistry configs;
	private final EntityRenderingRegistry entityRenderers;
	private final GuiRegistry guis;
	private final ItemRegistry items;
	private final SoundRegistry sounds;
	private final TileEntityRegistry tileEntites;

	/**
	 To make sure that the initialization of Guice-based JavaFX application
	 works flawlessly, the original init method of the base JavaFX Application
	 class is overwritten here. All of the
	 */
	protected ABaseMod ()
	{
		// Prerequisites for Modules
		final String modName = this.getModName();
		final String configPath = Joiner.on( File.separator ).join( "config", "AppliedEnergistics2", "IntelliE", modName + ".cfg" );
		final Configuration config = new Configuration( new File( configPath ) );

		// Creates an injector with all of the required modules.
		final Collection<IModule> moduleInstances = this.getClassModule();

		moduleInstances.add( new BaseModInstanceModule( this ) );
		moduleInstances.add( new RegistryModule( config ) );
		moduleInstances.add( new LoggerModule( modName ) );

		final Object[] modules = moduleInstances.toArray();
		this.injector = ObjectGraph.create( modules );

		// Enable Logging
		this.log = this.injector.get( ILog.class );

		// Inject all Registries
		this.armorRenderers = this.injector.get( ArmorRenderingRegistry.class );
		this.blockContainers = this.injector.get( BlockContainerRegistry.class );
		this.blocks = this.injector.get( BlockRegistry.class );
		this.blockRenderers = this.injector.get( BlockRenderingRegistry.class );
		this.configs = this.injector.get( ConfigRegistry.class );
		this.entityRenderers = this.injector.get( EntityRenderingRegistry.class );
		this.guis = this.injector.get( GuiRegistry.class );
		this.items = this.injector.get( ItemRegistry.class );
		this.sounds = this.injector.get( SoundRegistry.class );
		this.tileEntites = this.injector.get( TileEntityRegistry.class );

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
		final String id = this.getModName();

		try
		{
			final Class<?> clazz = Class.forName( moduleName );
			final Constructor<?> ctor = clazz.getConstructor();
			final Object instance = ctor.newInstance();
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
			final Class<?> clazz = obj instanceof Class<?> ? (Class<?>) obj : obj.getClass();

			if ( clazz.isAnnotationPresent( Module.class ) )
			{
				final Module module = clazz.getAnnotation( Module.class );
				final Class<?>[] injects = module.injects();
				final Class<?>[] includes = module.includes();

				this.instantiateInjections( injects );
				this.instantiateModules( includes );
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
			final boolean toInstantiate = IInstantiate.class.isAssignableFrom( injection );
			if ( toInstantiate )
			{
				this.injector.get( injection );
			}
		}
	}

	/**
	 Retrieves the modname from the @Mod Annotation
	 If Modname is too long, it takes the first letters of each capital word
	 MyMod will generate MM

	 @return Modname
	 */
	private String getModName ()
	{
		final Mod annotation = this.getClass().getAnnotation( Mod.class );
		return annotation.name();
	}

	@Override
	public void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "PreInit Begin" );

		//		this.items.loadConfig( config );
		//		this.tileEntites.loadConfig( config );

		this.blocks.register();
		this.items.register();

		final ICommonProxy proxy = this.getProxy();
		proxy.initRenders();
		proxy.initSounds();

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

		this.tileEntites.register();
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
