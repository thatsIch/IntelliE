package de.thatsich.common.util;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	injects = ILog.class,
	library = true
)
public class LoggerModule
{
	@Provides
	@Singleton
	ILog provideILog ( Logger logger )
	{
		return logger;
	}
}
