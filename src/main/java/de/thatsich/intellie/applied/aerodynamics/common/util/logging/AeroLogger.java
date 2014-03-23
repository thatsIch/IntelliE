package de.thatsich.intellie.applied.aerodynamics.common.util.logging;

import de.thatsich.intellie.common.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 23.03.2014.
 */
@Singleton
public class AeroLogger extends Logger
{
	/**
	 * Constructor either only be injected or tested
	 * thus package private
	 */
	@Inject
	AeroLogger ()
	{
		super( "Aero" );
	}
}
