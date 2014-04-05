package de.thatsich.intellie.common.registries;

import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SoundRegistry
{
	private final ILog log;

	@Inject
	SoundRegistry( final ILog log )
	{
		this.log = log;
	}
}
