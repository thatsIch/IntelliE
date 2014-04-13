package de.thatsich.minecraft.core

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent, FMLPostInitializationEvent}
import de.thatsich.minecraft.core.registries.IRegistries
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.core.log.ILog
import de.thatsich.minecraft.core.module.IModules

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ABaseMod(implicit protected val log: ILog,
                        implicit protected val modules: IModules,
                        implicit protected val registries: IRegistries,
                        implicit protected val configFiles: IConfigFiles)
	extends IEventProxy
{
	def proxy: ICommonProxy

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

	def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Begin")
		this.registries.preInit(event)

		proxy.initRenders()
		proxy.initSounds()

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
