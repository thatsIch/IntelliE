package de.thatsich.minecraft.intellie.applied.aerodynamics


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.registry.fake.NBTKeyCollector
import de.thatsich.minecraft.common.proxy.CommonProxy
import de.thatsich.minecraft.common.util.string.id.SimpleModID
import de.thatsich.minecraft.common.util.string.{Abbreviation, ModID}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.creativetab.AeroCreativeTabIcon
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.{AeroAbbreviation, AeroCreativeTabs, AeroModules, InternalAeroModules, InternalNBTKeyRegistry, NBTKeyRegistry}
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

	override lazy val nbtkeyregistry: NBTKeyRegistry = this.getNBTKeyRegistry(this.registry.items, this.modid, this.log)

	def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit =
	{
		// registers all nbt key items
		this.nbtkeyregistry.allKeysAsItemStack.foreach(stack =>
		{
			val item = stack.getItem
			val name = this.getItemName(item)
			GameRegistry.registerItem(item, name)
		})
	}

	/**
 * Gets the name which will be stored in the end in the registry
 *
 * @param item to be extracted name of item
 *
 * @return stripped down version of the itemname
 */
	private def getItemName(item: Item): String =
	{
		val unlocalizedName: String = item.getUnlocalizedName
		val position: Int = unlocalizedName.lastIndexOf('.') + 1
		val name: String = unlocalizedName.substring(position)

		name
	}

	def onInheritatedPostInit(event: FMLPostInitializationEvent): Unit =
	{}

	def onInheritatedInit(event: FMLInitializationEvent): Unit =
	{}

	private def getNBTKeyRegistry(items: Seq[Item], modid: ModID, log: Log): NBTKeyRegistry =
	{
		val registry = new InternalNBTKeyRegistry(modid, log)
		val collector = new NBTKeyCollector(items)
		val keys = collector.getNBTKeys

		keys foreach registry.addNBTKey

		registry
	}
}
