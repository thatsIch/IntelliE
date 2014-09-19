package de.thatsich.minecraft.common.config


/**
 * A configuration interface to simplify the access to the real configuration
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

	def getBoolean(category: String, key: String, defaultValue: Boolean): Boolean

	def getBoolean(category: String, key: String, defaultValue: Boolean, comment: String): Boolean

	def getInt(category: String, key: String, defaultValue: Int): Int

	def getInt(category: String, key: String, defaultValue: Int, comment: String): Int

	def getDouble(category: String, key: String, defaultValue: Double): Double

	def getDouble(category: String, key: String, defaultValue: Double, comment: String): Double
}
