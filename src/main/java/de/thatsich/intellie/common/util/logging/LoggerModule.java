package de.thatsich.intellie.common.util.logging;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.common.IntelliE;
import de.thatsich.intellie.common.module.IModule;

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
	@IntelliE
	ILog provideILog ()
	{
		return new Logger( "IE" );
	}
}
