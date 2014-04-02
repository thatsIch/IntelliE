package de.thatsich.intellie.common;

import cpw.mods.fml.common.Mod;
import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;

import javax.inject.Singleton;

/**
 @author thatsIch
 @since 26.03.2014. */
@Module(library = true)
public class BaseModModule implements IModule
{
	private final ABaseMod instance;

	public BaseModModule( ABaseMod instance )
	{
		this.instance = instance;
	}

	@Provides
	@Singleton
	ABaseMod provideBaseModInstance()
	{
		return this.instance;
	}

	@Provides
	@Singleton
	BaseModID provideBaseModID()
	{
		final String id = this.instance.getClass().getAnnotation( Mod.class ).modid();
		return new BaseModID( id );
	}
}
