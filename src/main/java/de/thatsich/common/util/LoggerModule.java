package de.thatsich.common.util;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 05.03.14.
 */
@Module(
	library = true,
	overrides = true
)
public class LoggerModule
{
	@Provides
	@Singleton
	ILog provideLog ( Logger logger )
	{
		return logger;
	}
}
