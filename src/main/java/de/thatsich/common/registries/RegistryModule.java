package de.thatsich.common.registries;

import dagger.Module;
import de.thatsich.common.module.IModule;
import de.thatsich.common.util.logging.LoggerModule;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = {
		RegistryConfigFactory.class, RegistryBlock.class, RegistryItem.class, RegistryTileEntity.class
		//		HandlerGui.class, HandlerRenderer.class, HandlerSound.class
	},
	includes = LoggerModule.class,
	library = true)
public class RegistryModule implements IModule
{
}
