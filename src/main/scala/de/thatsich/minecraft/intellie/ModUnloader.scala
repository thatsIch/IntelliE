package de.thatsich.minecraft.intellie

import java.lang.reflect.Field
import java.util

import com.google.common.collect.{ImmutableList, ImmutableMap}
import cpw.mods.fml.common.{LoadController, Loader, ModContainer}

import scala.collection.JavaConverters._

trait ModUnloader
{
	def unload( id: String, disableModule: Boolean ): Unit =
	{
		if( disableModule )
		{
			val loader = Loader.instance( )

			val modsField = this.grantFieldAccess( classOf[ Loader ], "mods" )
			val namedModsField = this.grantFieldAccess( classOf[ Loader ], "namedMods" )
			val modControllerField = this.grantFieldAccess( classOf[ Loader ], "modController" )
			val activeModListField = this.grantFieldAccess( classOf[ LoadController ], "activeModList" )

			val mods = modsField.get( loader ).asInstanceOf[ ImmutableList[ ModContainer ] ].asScala.to[ List ]
			val namedMods = namedModsField.get( loader ).asInstanceOf[ ImmutableMap[ String, ModContainer ] ].asScala.toMap
			val modController = modControllerField.get( loader ).asInstanceOf[ LoadController ]
			val activeModList = activeModListField.get( modController ).asInstanceOf[ util.ArrayList[ ModContainer ] ].asScala.to[ List ]

			val modsWithoutID = this.removeFromImmutableList( mods, id )
			val nameModsWithoutID = this.removeFromImmutableMap( namedMods, id )
			val activeModListWithoutID = this.removeFromImmutableList( activeModList, id )

			modsField.set( loader, modsWithoutID.asJava )
			namedModsField.set( loader, nameModsWithoutID.asJava )
			activeModListField.set( modController, activeModListWithoutID.asJava )
		}
	}

	private def grantFieldAccess( clazz: Class[ _ ], fieldName: String ): Field =
	{
		val field = clazz.getDeclaredField( fieldName )
		field.setAccessible( true )

		field
	}

	private def removeFromImmutableList( list: List[ ModContainer ], elem: String ): List[ ModContainer ] =
	{
		list.filter( _.getModId != elem )
	}

	private def removeFromImmutableMap( map: Map[ String, ModContainer ], key: String ): Map[ String, ModContainer ] =
	{
		map - key
	}
}
