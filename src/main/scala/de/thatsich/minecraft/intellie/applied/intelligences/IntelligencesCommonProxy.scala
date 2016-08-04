package de.thatsich.minecraft.intellie.applied.intelligences

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.proxy.module.item.{NBTKeys, SimpleFakeItem}
import de.thatsich.minecraft.common.util.nbt.NBTTags
import de.thatsich.minecraft.common.util.string.Abbreviation
import de.thatsich.minecraft.common.util.string.id.{SimpleID, SimpleModID}
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.creativetab.IntelligencesCreativetabIcon
import de.thatsich.minecraft.intellie.applied.intelligences.proxy.{IntelligencesAbbreviation, IntelligencesCreativeTabs, InternalIntelligencesItemRegistry, InternalIntelligencesModules}
import net.minecraft.item.Item

/**
  * Created by thatsIch on 04.08.2016.
  */
class IntelligencesCommonProxy extends CommonProxy with IntelligencesProxy {
	/**
	  * Instance of the mod
	  *
	  * @return mod instance
	  */
	final lazy val mod = AppliedIntelligences
	final lazy val modid = new SimpleModID(this.mod.id)
	/**
	  * Modules of functionality of the mod.
	  * Can contain blocks, items, recipes etc
	  *
	  * @return modules of mod
	  */
	final lazy val modules: IntelligencesModules = new InternalIntelligencesModules(this.icon, this.modid, this.log)
	/**
	  * gets the abbreviation of the mod.
	  * Is used for the logger
	  *
	  * @return abbreviation of mod
	  */
	final lazy val abbr: Abbreviation = new IntelligencesAbbreviation

	private final lazy val icon = new IntelligencesCreativetabIcon(this.modid)

	/**
	  * Creative tab of Aerodynamics
	  */
	new IntelligencesCreativeTabs(this.icon, this.registry.blocks, this.registry.items, this.log, this.modid)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit = {
		this.itemregistry.registerAll()
	}

	override lazy val itemregistry: InternalIntelligencesItemRegistry = new InternalIntelligencesItemRegistry(this.getNBTItems, this.modid, this.log)

	private def getNBTItems: Seq[Item] = {
		val buffer = scala.collection.mutable.LinkedHashSet[Item]()
		val filter = scala.collection.mutable.Set[String]()

		this.registry.items.foreach {
			case keys: NBTKeys =>
				val tags: Seq[NBTTags] = keys.getNBTKeys
				tags.foreach(tag => tag.values.foreach(bound => {
					val boundname: String = bound.toString
					if (!filter.contains(boundname)) {
						filter += boundname
						val boundid = new SimpleID(boundname)

						buffer += new SimpleFakeItem(boundid, this.modid, this.log)
					}
				}))
			case _ =>
		}

		buffer.toVector
	}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit = {}

	def onInheritatedInit(event: FMLInitializationEvent): Unit = {}
}
