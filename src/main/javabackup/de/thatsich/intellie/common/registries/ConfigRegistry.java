package de.thatsich.intellie.common.registries;

import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 All specific classes need to register their configs here
 which will handle the loading, filenaming, saving and
 access to the real configuration file

 @author thatsIch
 @since 25.02.14. */
@Singleton
public class ConfigRegistry
{
	// Final Fields
	private final ILog log;
	private final Configuration config;

	/**
	 Injected Constructor

	 @param log    Log
	 @param config Config
	 */
	ConfigRegistry( final ILog log, final Configuration config )
	{
		this.log = log;
		this.config = config;
	}

	/**
	 Dagger Injected Constructor for Factory
	 */
	@Inject
	ConfigRegistry()
	{
		this.log = null;
		this.config = null;
	}

	/**
	 When Registry is destructed, save the config if it has changed

	 @throws Throwable when super.finalize() throws
	 */
	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();

		if( !this.config.hasChanged() )
		{
			this.config.save();
		}
	}

	/**
	 Boolean

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public boolean getBoolean( final String category, final String key, final boolean defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBoolean( defaultValue );
	}

	/**
	 Array of Booleans

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public boolean[] getBooleanList( final String category, final String key, final boolean... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBooleanList();
	}

	/**
	 Double

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public double getDouble( final String category, final String key, final double defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDouble( defaultValue );
	}

	/**
	 Array of doubles

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public double[] getDoubleList( final String category, final String key, final double... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDoubleList();
	}

	/**
	 Integer

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public int getInt( final String category, final String key, final int defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getInt();
	}

	/**
	 Array of integers

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public int[] getIntList( final String category, final String key, final int... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getIntList();
	}

	/**
	 String

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public String getString( final String category, final String key, final String defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getString();
	}

	/**
	 Array of Strings

	 @param category     Requested Category
	 @param key          Requested Key
	 @param defaultValue Defaultvalue if key does not exist

	 @return Requested category and key
	 */
	public String[] getStringList( final String category, final String key, final String... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getStringList();
	}
}
