package de.thatsich.intellie.common.registries;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.util.logging.ILog;
import de.thatsich.intellie.common.util.logging.LoggerModule;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = {
		ConfigRegistry.class, BlockRegistry.class, ItemRegistry.class, TileEntityRegistry.class
		//		GuiRegistry.class, HandlerRenderer.class, SoundRegistry.class
	},
	library = true,
	includes = LoggerModule.class)
public class RegistryModule implements IModule
{
	private final String name;

	public RegistryModule ( String name )
	{
		this.name = name;
	}

	@Provides
	@Singleton
	public ConfigRegistry provideConfigRegistry ( ILog log )
	{
		return new ConfigRegistry( log, this.name );
	}
}
