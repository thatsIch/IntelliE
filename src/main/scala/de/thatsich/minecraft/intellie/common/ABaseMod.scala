package de.thatsich.minecraft.intellie.common

import de.thatsich.minecraft.intellie.common.logger.ILog
import cpw.mods.fml.common.Mod
import java.lang.reflect.Field
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent, FMLPostInitializationEvent}
import de.thatsich.minecraft.intellie.common.registries.IRegistries
import de.thatsich.minecraft.intellie.common.config.IConfigFiles

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ABaseMod(protected val log: ILog, protected val registries: IRegistries, protected val configFiles: IConfigFiles)
	extends IEventProxy
{
	// implicit config

	/**
	 * Retrieves the modname from the @Mod Annotation
	 * If Modname is too long, it takes the first letters of each capital word
	 * MyMod will generate MM
	 *
	 * @return Modname
	 */
	private def getModName: String =
	{
		val annotation: Mod = this.getClass.getAnnotation(classOf[ Mod ])

		annotation.name
	}

	/**
	 * retrieves the proxy class of the child by reflecting it
	 *
	 * @return proxy
	 */
	private def getProxy: ICommonProxy =
	{
		val clazz = this.getClass
		val potentialProxy: Array[ Field ] = clazz.getDeclaredFields
		for( field <- potentialProxy )
		{
			val obj: Object = field.get(null)
			obj match
			{
				case proxy: ICommonProxy => return proxy
				case _ =>
			}
		}
		this.log.warn("No proxy found.")
		throw new IllegalArgumentException("No proxy was given.")
	}

	def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Begin")
		this.registries.preInit(event)
		val proxy = this.getProxy
		proxy.initRenders
		proxy.initSounds
		this.log.info("PreInit End")
	}

	def init(event: FMLInitializationEvent)
	{
		this.log.info("Init Begin")
		this.registries.init(event)
		this.log.info("Init End")
	}

	def postInit(event: FMLPostInitializationEvent)
	{
		this.log.info("PostInit Begin")
		this.registries.postInit(event)
		this.log.info("PostInit End")
	}
}
