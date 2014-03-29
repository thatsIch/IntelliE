package de.thatsich.intellie.common.registries;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.util.logging.ILogger;
import de.thatsich.intellie.common.util.logging.LoggerModule;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 05.03.14. */
@Module(
	injects = {
		ConfigRegistry.class, BlockRegistry.class, ItemRegistry.class, TileEntityRegistry.class
		//		GuiRegistry.class, HandlerRenderer.class, SoundRegistry.class
	},
	library = true,
	includes = LoggerModule.class)
public class RegistryModule implements IModule
{
	private final String id;

	public RegistryModule ( String id )
	{
		this.id = id;
	}

	@Provides
	@Singleton
	LoggerModule provideLoggerModule ()
	{
		return new LoggerModule( this.id );
	}

	@Provides
	@Singleton
	public ConfigRegistry provideConfigRegistry ( ILogger log )
	{
		return new ConfigRegistry( log, this.id );
	}
}
