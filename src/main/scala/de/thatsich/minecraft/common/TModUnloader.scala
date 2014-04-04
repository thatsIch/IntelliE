package de.thatsich.minecraft.common

import cpw.mods.fml.common.{ModContainer, Loader}
import de.thatsich.minecraft.intellie.common.TIELog
import java.lang.reflect.Field
import com.google.common.collect.{ImmutableMap, ImmutableList}
import scala.collection.JavaConverters._

trait TModUnloader extends TIELog
{
	def unload(id: String)
	{
		val loader = Loader.instance()

		val modsField = this.grantFieldAccess(classOf[ Loader ], "mods")
		val namedModsField = this.grantFieldAccess(classOf[ Loader ], "namedMods")

		val mods = modsField.get(loader).asInstanceOf[ ImmutableList[ ModContainer ] ].asScala.to[ List ]
		val namedMods = namedModsField.get(loader).asInstanceOf[ ImmutableMap[ String, ModContainer ] ].asScala.toMap

		val modsWithoutID = this.removeFromImmutableList(mods, id)
		val nameModsWithoutID = this.removeFromImmutableMap(namedMods, id)

		modsField.set(loader, modsWithoutID.asJava)
		namedModsField.set(loader, nameModsWithoutID.asJava)
	}

	private def grantFieldAccess(clazz: Class[ _ ], fieldName: String): Field =
	{
		val field = clazz.getDeclaredField(fieldName)
		field.setAccessible(true)
		this.log.info("Granted Access to Field " + fieldName + " of " + clazz.getSimpleName)

		field
	}

	private def removeFromImmutableList(list: List[ ModContainer ], elem: String): List[ ModContainer ] =
	{
		val removed = list.filter(_.getModId != elem)
		this.log.info("Removed Mod %s: " + removed, elem)

		removed
	}

	private def removeFromImmutableMap(map: Map[ String, ModContainer ], key: String): Map[ String, ModContainer ] =
	{
		val removed = map - key
		this.log.info("Removed ModName %s: " + removed, key)

		removed
	}
}
