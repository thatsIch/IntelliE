package de.thatsich.minecraft.intellie.common

import net.minecraftforge.common.config.Configuration
import java.io.File

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class Config(val configPath: String)
	extends IConfig
{
	private val config = new Configuration(new File(this.configPath))

	def save()
	{
		if( this.config.hasChanged )
		{
			this.config.save()
		}
	}

	/**
	Boolean

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getBoolean(category: String, key: String, defaultValue: Boolean): Boolean =
	{
		this.config.get(category, key, defaultValue).getBoolean(defaultValue)
	}

	/**
	Array of Booleans

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getBooleanList(category: String, key: String, defaultValue: Array[ Boolean ]): Array[ Boolean ] =
	{
		this.config.get(category, key, defaultValue).getBooleanList
	}

	/**
	Double

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getDouble(category: String, key: String, defaultValue: Double): Double =
	{
		this.config.get(category, key, defaultValue).getDouble(defaultValue)
	}

	/**
	Array of doubles

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getDoubleList(category: String, key: String, defaultValue: Array[ Double ]): Array[ Double ] =
	{
		this.config.get(category, key, defaultValue).getDoubleList
	}

	/**
	Integer

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getInt(category: String, key: String, defaultValue: Int): Int =
	{
		this.config.get(category, key, defaultValue).getInt
	}

	/**
	Array of integers

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getIntList(category: String, key: String, defaultValue: Array[ Int ]): Array[ Int ] =
	{
		this.config.get(category, key, defaultValue).getIntList
	}

	/**
	String

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getString(category: String, key: String, defaultValue: String): String =
	{
		this.config.get(category, key, defaultValue).getString
	}

	/**
	Array of Strings

	 @param category     Requested Category
	@param key          Requested Key
	@param defaultValue Defaultvalue if key does not exist

	@return Requested category and key
	  */
	def getStringList(category: String, key: String, defaultValue: Array[ String ]): Array[ String ] =
	{
		this.config.get(category, key, defaultValue).getStringList
	}
}
