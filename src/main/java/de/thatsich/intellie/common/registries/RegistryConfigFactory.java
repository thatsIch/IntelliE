package de.thatsich.intellie.common.registries;

import dagger.MembersInjector;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * @author thatsIch
 * @date 22.03.2014.
 */
@Singleton
public class RegistryConfigFactory
{
	// Fields
	private final Provider<ILog> logProvider;
	private final MembersInjector<RegistryConfig> configMembersInjector;
	private final Map<String, RegistryConfig> configMap;

	@Inject
	RegistryConfigFactory ( Provider<ILog> logProvider, MembersInjector<RegistryConfig> configMembersInjector )
	{
		this.logProvider = logProvider;
		this.configMembersInjector = configMembersInjector;
		this.configMap = new HashMap<>( 3 );
	}

	/**
	 * Tries to fetch a named RegistryConfig from local cache.
	 * If not avaiable, it will create a new named one and store it in the cache.
	 *
	 * @param fileName Name of RegistryConfig
	 *
	 * @return Named RegistryConfig
	 */
	public RegistryConfig get ( String fileName )
	{
		final RegistryConfig config;

		if ( this.configMap.containsKey( fileName ) )
		{
			config = this.configMap.get( fileName );
		} else
		{
			config = this.create( fileName );

			this.configMap.put( fileName, config );
		}

		return config;
	}

	/**
	 * Creates a new RegistryConfig with a specific filename
	 *
	 * @param fileName Name of the RegsitryConfig
	 *
	 * @return Named RegistryConfig
	 */
	private RegistryConfig create ( String fileName )
	{
		final ILog log = this.logProvider.get();
		final RegistryConfig config = new RegistryConfig( log, fileName );

		this.configMembersInjector.injectMembers( config );

		return config;
	}
}
