package de.thatsich.minecraft.common.config


/**
 *
 *
 * @author thatsIch
 * @since 08.04.2014.
 */
trait Config
{
	/**
	 * saves the file if changed
	 */
	def save(): Unit

	/**
	 * Boolean
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getBoolean(category: String, key: String, defaultValue: Boolean): Boolean

	/**
	 * Array of Booleans
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getBooleanList(category: String, key: String, defaultValue: Array[Boolean]): Array[Boolean]

	/**
	 * Double
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getDouble(category: String, key: String, defaultValue: Double): Double

	/**
	 * Array of doubles
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getDoubleList(category: String, key: String, defaultValue: Array[Double]): Array[Double]

	/**
	 * Integer
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getInt(category: String, key: String, defaultValue: Int): Int

	/**
	 * Array of integers
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getIntList(category: String, key: String, defaultValue: Array[Int]): Array[Int]

	/**
	 * String
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getString(category: String, key: String, defaultValue: String): String

	/**
	 * Array of Strings
	 *
	 * @param category     Requested Category
	 * @param key          Requested Key
	 * @param defaultValue Defaultvalue if key does not exist
	 *
	 * @return Requested category and key
	 */
	def getStringList(category: String, key: String, defaultValue: Array[String]): Array[String]
}
