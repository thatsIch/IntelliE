package de.thatsich.minecraft.common.config


import java.io.File

import de.thatsich.minecraft.common.util.string.ConfigPath
import net.minecraftforge.common.config.Configuration


/**
 * A config wrapper with simplified configuration access
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
abstract class BaseConfig(configPath: ConfigPath)
extends Configuration(new File(configPath.path))
        with Config
{
	/**
	 * Saves the underlying config if the config itself has changed
	 */
	override def save(): Unit =
	{
		if (super.hasChanged)
		{
			super.save()
		}
	}

	override def getBoolean(category: String, key: String, defaultValue: Boolean): Boolean = super.get(category, key, defaultValue).getBoolean

	override def getInt(category: String, key: String, defaultValue: Int): Int = super.get(category, key, defaultValue).getInt

	override def getDouble(category: String, key: String, defaultValue: Double): Double = super.get(category, key, defaultValue).getDouble

	override def getDouble(category: String, key: String, defaultValue: Double, comment: String): Double = super.get(category, key, defaultValue, comment).getDouble

	override def getInt(category: String, key: String, defaultValue: Int, comment: String): Int = super.get(category, key, defaultValue, comment).getInt
}
