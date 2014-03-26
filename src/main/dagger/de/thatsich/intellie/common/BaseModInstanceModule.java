package de.thatsich.intellie.common;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 26.03.2014. */
@Module(library = true)
public class BaseModInstanceModule implements IModule
{
	private final ABaseMod instance;

	public BaseModInstanceModule ( ABaseMod instance )
	{
		this.instance = instance;
	}

	@Provides
	@Singleton
	ABaseMod provideBaseModInstance ()
	{
		return this.instance;
	}
}
