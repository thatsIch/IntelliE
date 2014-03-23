package de.thatsich.intellie.common.util.logging;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;

import javax.inject.Singleton;

/**
 @author thatsIch
 @date 05.03.14. */
@Module(injects = ILog.class, library = true)
public class LoggerModule implements IModule
{
	private final String name;

	public LoggerModule ( final String name ) {this.name = name;}

	@Provides
	@Singleton
	ILog provideILog () { return new Logger( this.name ); }
}
