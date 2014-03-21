package de.thatsich.common.registries;

import com.google.common.base.Joiner;
import de.thatsich.common.util.ILog;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;

/**
 * All specific classes need to register their configs here
 * which will handle the loading, filenaming, saving and
 * access to the real configuration file
 *
 * @author thatsIch
 * @date 25.02.14.
 */
@Singleton
public class RegistryConfig
{
	// Final Fields
	private final ILog log;

	// Fields
	private Configuration config = null;

	/**
	 * Injected Constructor
	 *
	 * @param log Logger
	 */
	@Inject
	RegistryConfig ( ILog log )
	{
		this.log = log;
	}

	/**
	 * Loads the Configuration File needed
	 *
	 * @param suggestedConfigFile suggested Configuration File
	 *
	 * @return loaded Configuration
	 */
	public Configuration load ( final File suggestedConfigFile )
	{
		final String configFolder = suggestedConfigFile.getParent();
		final String ieConfig = Joiner.on( File.separator ).join( configFolder, "AppliedEnergistics2", "IntelliE", "IntelliE.cfg" );
		final File ieConfigFile = new File( ieConfig );

		this.config = new Configuration( ieConfigFile );

		this.config.load();

		return this.config;
	}

	/**
	 * When Registry is destructed, save the config if it has changed
	 *
	 * @throws Throwable when super.finalize() throws
	 */
	@Override
	protected void finalize () throws Throwable
	{
		super.finalize();

		if ( !this.config.hasChanged() )
		{
			this.config.save();
		}
	}

	/**
	 * Boolean
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public boolean getBoolean ( final String category, final String key, final boolean defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBoolean( defaultValue );
	}

	/**
	 * Array of Booleans
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public boolean[] getBooleanList ( final String category, final String key, final boolean... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBooleanList();
	}

	/**
	 * Double
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public double getDouble ( final String category, final String key, final double defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDouble( defaultValue );
	}

	/**
	 * Array of doubles
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public double[] getDoubleList ( final String category, final String key, final double... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDoubleList();
	}

	/**
	 * Integer
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public int getInt ( final String category, final String key, final int defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getInt();
	}

	/**
	 * Array of integers
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public int[] getIntList ( final String category, final String key, final int... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getIntList();
	}

	/**
	 * String
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public String getString ( final String category, final String key, final String defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getString();
	}

	/**
	 * Array of Strings
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	public String[] getStringList ( final String category, final String key, final String... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getStringList();
	}
}
