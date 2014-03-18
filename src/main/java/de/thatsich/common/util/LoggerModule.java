package de.thatsich.common.util;

import dagger.Module;
import dagger.Provides;
import de.thatsich.common.module.IModule;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = ILog.class,
	library = true
)
public class LoggerModule implements IModule
{
	@Provides
	@Singleton
	ILog provideILog ( Logger logger )
	{
		return logger;
	}
}
