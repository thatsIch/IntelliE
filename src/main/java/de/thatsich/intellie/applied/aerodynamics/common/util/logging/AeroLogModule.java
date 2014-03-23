package de.thatsich.intellie.applied.aerodynamics.common.util.logging;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.applied.aerodynamics.common.Aerodynamics;
import de.thatsich.intellie.common.util.logging.ILog;
import de.thatsich.intellie.common.util.logging.Logger;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 23.03.2014.
 */
@Module(
	injects = ILog.class,
	library = true)
public class AeroLogModule
{
	@Provides
	@Singleton
	@Aerodynamics
	ILog provideAeroLogger ()
	{
		return new Logger( "Aero" );
	}
}
