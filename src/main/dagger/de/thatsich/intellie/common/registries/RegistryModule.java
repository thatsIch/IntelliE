package de.thatsich.intellie.common.registries;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 05.03.14. */
@Module(
	injects = {
		ArmorRenderingRegistry.class, BlockContainerRegistry.class, BlockRegistry.class, BlockRenderingRegistry.class, ConfigRegistry.class, EntityRenderingRegistry.class, GuiRegistry.class, ItemRegistry.class, SoundRegistry.class, TileEntityRegistry.class
	},
	library = true,
	complete = false)
public class RegistryModule implements IModule
{
	private final String id;

	public RegistryModule ( String id )
	{
		this.id = id;
	}

	@Provides
	@Singleton
	public ConfigRegistry provideConfigRegistry ( ILog log )
	{
		return new ConfigRegistry( log, this.id );
	}
}
