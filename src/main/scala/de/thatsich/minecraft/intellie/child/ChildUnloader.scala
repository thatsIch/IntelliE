package de.thatsich.minecraft.intellie.child


import java.lang.reflect.Field
import java.util

import com.google.common.collect.ImmutableList.Builder
import com.google.common.collect.{ImmutableList, ImmutableMap, Lists, Maps}
import com.google.common.eventbus.EventBus
import cpw.mods.fml.common.event.FMLModDisabledEvent
import cpw.mods.fml.common.{LoadController, Loader, ModContainer}
import de.thatsich.minecraft.common.log.Log

import scala.collection.JavaConverters._


trait ChildUnloader
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

			val mods = modsField.get(loader).asInstanceOf[ImmutableList[ModContainer]]
			val namedMods = namedModsField.get(loader).asInstanceOf[ImmutableMap[String, ModContainer]]
			val modController = modControllerField.get(loader).asInstanceOf[LoadController]
			val activeModList = activeModListField.get(modController).asInstanceOf[util.ArrayList[ModContainer]]
			val eventChannels = eventChannelsField.get(modController).asInstanceOf[ImmutableMap[String, EventBus]]

			val modsWithoutID = this.removeFromImmutableList(mods, id)
			val nameModsWithoutID = this.removeFromImmutableModContainerMap(namedMods, id)
			val activeModListWithoutID = this.removeFromArrayList(activeModList, id)
			val eventBus = eventChannels.get(id)
			val eventChannelsWithoutID = this.removeFromImmutableEventBusMap(eventChannels, id)

			eventBus.post(new FMLModDisabledEvent)
			modsField.set(loader, modsWithoutID)
			namedModsField.set(loader, nameModsWithoutID)
			activeModListField.set(modController, activeModListWithoutID)
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

	private def removeFromImmutableList(list: ImmutableList[ModContainer], elem: String): ImmutableList[ModContainer] =
	{
		val tempList = list.asScala
		val builder: Builder[ModContainer] = ImmutableList.builder[ModContainer]()

		for (mc <- tempList)
		{
			if (mc.getModId != elem)
			{
				builder.add(mc)
			}
		}

		builder.build()
	}

	private def removeFromArrayList(list: util.ArrayList[ModContainer], elem: String): util.ArrayList[ModContainer] =
	{
		val tempList = list.asScala
		val newList = Lists.newArrayList[ModContainer]()

		for (mc <- tempList)
		{
			if (mc.getModId != elem)
			{
				newList.add(mc)
			}
		}

		newList
	}

	private def removeFromImmutableModContainerMap(map: ImmutableMap[String, ModContainer], key: String): ImmutableMap[String, ModContainer] =
	{
		val tempMap = Maps.newHashMap[String, ModContainer](map)
		tempMap.remove(key)
		val newMap = ImmutableMap.copyOf[String, ModContainer](tempMap)

		newMap
	}

	private def removeFromImmutableEventBusMap(map: ImmutableMap[String, EventBus], key: String): ImmutableMap[String, EventBus] =
	{
		val tempMap = Maps.newHashMap[String, EventBus](map)
		tempMap.remove(key)
		val newMap = ImmutableMap.copyOf[String, EventBus](tempMap)

		newMap
	}
}
