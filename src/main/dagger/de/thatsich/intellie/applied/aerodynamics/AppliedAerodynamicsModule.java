package de.thatsich.intellie.applied.aerodynamics;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.applied.aerodynamics.common.AppliedAerodynamicsCreativeTabModule;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.SuiteModule;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.RegistryModule;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 20.03.2014. */
@Module(
	library = true,
	includes = {
		RegistryModule.class, SuiteModule.class, AppliedAerodynamicsCreativeTabModule.class
	})
public class AppliedAerodynamicsModule implements IModule
{
	private final String id;

	AppliedAerodynamicsModule ( final String id )
	{
		this.id = id;
	}

	@Provides
	@Singleton
	RegistryModule provideRegistryModule ()
	{
		return new RegistryModule( this.id );
	}
}
