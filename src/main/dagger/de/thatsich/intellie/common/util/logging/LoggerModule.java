package de.thatsich.intellie.common.util.logging;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.module.IModule;

import javax.inject.Singleton;

/**
 Module for Logging
 Requires an actual ID which is used to identify from which logger
 the message was actual printed

 @author thatsIch
 @date 05.03.14. */
@Module(
	injects = ILogger.class,
	library = true)
public class LoggerModule implements IModule
{
	private final String name;

	public LoggerModule ( final String name ) {this.name = name;}

	@Provides
	@Singleton
	public ILogger provideLogger () { return new Logger( this.name ); }
}
