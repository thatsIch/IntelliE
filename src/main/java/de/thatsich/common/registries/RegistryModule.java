package de.thatsich.common.registries;

import dagger.Module;
import de.thatsich.common.util.LoggerModule;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = {
		RegistryConfig.class, RegistryBlock.class, RegistryItem.class, RegistryTileEntity.class
//		HandlerGui.class, HandlerRenderer.class, HandlerSound.class
	},
	includes = {
		LoggerModule.class
	}
)
public class RegistryModule
{}
