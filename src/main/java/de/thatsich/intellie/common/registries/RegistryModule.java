package de.thatsich.intellie.common.registries;

import dagger.Module;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.util.logging.LoggerModule;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = {
		RegistryConfigFactory.class, RegistryBlock.class, RegistryItem.class, RegistryTileEntity.class
		//		HandlerGui.class, HandlerRenderer.class, HandlerSound.class
	},
	library = true,
	includes = LoggerModule.class)
public class RegistryModule implements IModule
{}
