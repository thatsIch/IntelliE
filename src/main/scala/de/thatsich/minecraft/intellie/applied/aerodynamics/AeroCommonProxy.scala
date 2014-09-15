package de.thatsich.minecraft.intellie.applied.aerodynamics


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.proxy.module.item.{NBTKeys, SimpleFakeItem}
import de.thatsich.minecraft.common.util.nbt.NBTTags
import de.thatsich.minecraft.common.util.string.Abbreviation
import de.thatsich.minecraft.common.util.string.id.{SimpleID, SimpleModID}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.creativetab.AeroCreativeTabIcon
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.{AeroAbbreviation, AeroCreativeTabs, AeroModules, InternalAeroModules, InternalNBTItemRegistry}
import net.minecraft.item.Item


/**
 * Proxy class shared beetween server and client
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
abstract class AeroCommonProxy extends CommonProxy with AeroProxy
{
	/**
	 * Instance of the mod
	 *
	 * @return mod instance
	 */
	final lazy val mod = AppliedAerodynamics
	final lazy val modid = new SimpleModID(this.mod.id)
	/**
	 * Modules of functionality of the mod.
	 * Can contain blocks, items, recipes etc
	 *
	 * @return modules of mod
	 */
	final lazy val modules: AeroModules = new InternalAeroModules(this.icon, this.modid, this.log)
	/**
	 * gets the abbreviation of the mod.
	 * Is used for the logger
	 *
	 * @return abbreviation of mod
	 */
	final lazy val abbr: Abbreviation = new AeroAbbreviation

	private final lazy val icon = new AeroCreativeTabIcon(this.modid)

	/**
	 * Creative tab of Aerodynamics
	 */
	new AeroCreativeTabs(this.icon, this.registry.blocks, this.registry.items, this.log, this.modid)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit =
	{
		this.nbtitemregistry.registerAll()
	}

	override lazy val nbtitemregistry: InternalNBTItemRegistry = new InternalNBTItemRegistry(this.getNBTItems, this.modid, this.log)

	private def getNBTItems: Seq[Item] =
	{
		val buffer = scala.collection.mutable.LinkedHashSet[Item]()
		val filter = scala.collection.mutable.Set[String]()

		this.registry.items.foreach
		{
			case keys: NBTKeys =>
				val tags: Seq[NBTTags] = keys.getNBTKeys
				tags.foreach(tag => tag.values.foreach(bound =>
				{
					val boundname: String = bound
					if (!filter.contains(boundname))
					{
						filter += boundname
						val boundid = new SimpleID(boundname)

						buffer += new SimpleFakeItem(boundid, this.modid, this.log)
					}
				}))
			case _             =>
		}

		buffer.toVector
	}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit =
	{}

	def onInheritatedInit(event: FMLInitializationEvent): Unit =
	{}
}
