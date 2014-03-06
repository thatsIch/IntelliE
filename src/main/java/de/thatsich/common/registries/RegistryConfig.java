package de.thatsich.common.registries;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * @author thatsIch
 * @date 25.02.14.
 */
public class RegistryConfig
{
	private Configuration config = null;

	public Configuration load (final File suggestedConfigFile)
	{
		final String configFolder = suggestedConfigFile.getParent();
		final String aeFolder = configFolder + File.separator + "AppliedEnergistics2" + File.separator;
		final String ieFolder = aeFolder + "IntelliE" + File.separator;
		final String ieConfig = ieFolder + "IntelliE.cfg";
		final File ieConfigFile = new File( ieConfig );
		this.config = new Configuration( ieConfigFile );

		this.config.load();

		return this.config;
	}

	@Override
	protected void finalize () throws Throwable
	{
		super.finalize();

		if ( !this.config.hasChanged() )
		{
			this.config.save();
		}
	}

	public boolean getBoolean ( final String category, final String key, final boolean defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBoolean( defaultValue );
	}

	public boolean[] getBooleanList ( final String category, final String key, final boolean... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getBooleanList();
	}

	public double getDouble ( final String category, final String key, final double defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDouble( defaultValue );
	}

	public double[] getDoubleList ( final String category, final String key, final double... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getDoubleList();
	}

	public int getInt ( final String category, final String key, final int defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getInt();
	}

	public int[] getIntList ( final String category, final String key, final int... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getIntList();
	}

	public String getString ( final String category, final String key, final String defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getString();
	}

	public String[] getStringList ( final String category, final String key, final String... defaultValue )
	{
		return this.config.get( category, key, defaultValue ).getStringList();
	}
}
