package de.thatsich.minecraft.intellie.child


import java.lang.reflect.Field
import java.util

import com.google.common.collect.{ImmutableList, ImmutableMap, Maps}
import com.google.common.eventbus.EventBus
import cpw.mods.fml.common.event.FMLModDisabledEvent
import cpw.mods.fml.common.{LoadController, Loader, ModContainer}
import de.thatsich.minecraft.common.log.Log

import scala.collection.JavaConverters._


trait ChildUnloader extends ChildUnloaderConfigAccess
{
	def unload(id: String, disableModule: Boolean, log: Log): Unit =
	{
		if (disableModule)
		{
			val loader = Loader.instance()

			val modsField = this.grantFieldAccess(classOf[Loader], "mods")
			val namedModsField = this.grantFieldAccess(classOf[Loader], "namedMods")
			val modControllerField = this.grantFieldAccess(classOf[Loader], "modController")
			val activeModListField = this.grantFieldAccess(classOf[LoadController], "activeModList")
			val eventChannelsField = this.grantFieldAccess(classOf[LoadController], "eventChannels")

			val mods = modsField.get(loader).asInstanceOf[ImmutableList[ModContainer]].asScala.to[List]
			val namedMods = namedModsField.get(loader).asInstanceOf[ImmutableMap[String, ModContainer]].asScala.toMap
			val modController = modControllerField.get(loader).asInstanceOf[LoadController]
			val activeModList = activeModListField.get(modController).asInstanceOf[util.ArrayList[ModContainer]].asScala.to[List]
			val eventChannels = eventChannelsField.get(modController).asInstanceOf[ImmutableMap[String, EventBus]]

			val modsWithoutID = this.removeFromImmutableList(mods, id)
			val nameModsWithoutID = this.removeFromImmutableModContainerMap(namedMods, id)
			val activeModListWithoutID = this.removeFromImmutableList(activeModList, id)
			val eventBus = eventChannels.get(id)
			val eventChannelsWithoutID = this.removeFromImmutableEventBusMap(eventChannels, id)

			eventBus.post(new FMLModDisabledEvent)
			modsField.set(loader, modsWithoutID.asJava)
			namedModsField.set(loader, nameModsWithoutID.asJava)
			activeModListField.set(modController, activeModListWithoutID.asJava)
			eventChannelsField.set(modController, eventChannelsWithoutID)

			log.info(s"Unloaded childmod $id")
		}
	}

	private def grantFieldAccess(clazz: Class[_], fieldName: String): Field =
	{
		val field = clazz.getDeclaredField(fieldName)
		field.setAccessible(true)

		field
	}

	private def removeFromImmutableList(list: List[ModContainer], elem: String): List[ModContainer] =
	{
		list.filter(_.getModId != elem)
	}

	private def removeFromImmutableModContainerMap(map: Map[String, ModContainer], key: String): Map[String, ModContainer] =
	{
		map - key
	}

	private def removeFromImmutableEventBusMap(map: ImmutableMap[String, EventBus], key: String): ImmutableMap[String, EventBus] =
	{
		val tempMap = Maps.newHashMap[String, EventBus](map)
		tempMap.remove(key)
		val newMap = ImmutableMap.copyOf[String, EventBus](tempMap)

		newMap
	}
}
