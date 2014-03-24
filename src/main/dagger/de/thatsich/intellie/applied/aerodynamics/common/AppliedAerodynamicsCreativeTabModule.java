package de.thatsich.intellie.applied.aerodynamics.common;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 24.03.2014. */
@Module(
	injects = AppliedAerodynamicsCreativeTab.class)
public class AppliedAerodynamicsCreativeTabModule
{
	@Provides
	@Singleton
	public AppliedAerodynamicsCreativeTab provideAppliedAerodynamicsCreativeTab ()
	{
		return new AppliedAerodynamicsCreativeTab();
	}
}
