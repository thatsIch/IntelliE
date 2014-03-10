package de.thatsich.intellie.decorative.test;

import dagger.Module;
import de.thatsich.common.registries.RegistryModule;
import de.thatsich.common.util.LoggerModule;

/**
 * @author thatsIch
 * @date 06.03.14.
 */
@Module(
	injects = {
		Test.class
	},
	includes = {
		LoggerModule.class, RegistryModule.class
	}
)
public class ModuleTest
{

}
