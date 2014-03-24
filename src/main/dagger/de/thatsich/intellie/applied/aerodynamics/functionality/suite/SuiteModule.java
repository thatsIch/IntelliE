package de.thatsich.intellie.applied.aerodynamics.functionality.suite;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest.AeroChest;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 24.03.2014. */
@Module(
	injects = AeroChest.class)
public class SuiteModule
{
	@Provides
	@Singleton
	AeroChest provideAeroChest ()
	{
		return new AeroChest();
	}
}
