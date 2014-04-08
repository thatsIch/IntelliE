package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.{FMLCommonHandler, SidedProxy, Optional, Mod}
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.OAppliedAerodynamicsLog
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.intellie.common.{ABaseMod, ICommonProxy}
import net.minecraft.item.ItemArmor
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.{ItemGraviChestPlate, KeyHandler}
import de.thatsich.minecraft.intellie.common.registries.ORegistries

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = "appaero",
	name = "AppliedAerodynamics",
	version = "${version}",
	dependencies = "required-after:intellie",
	modLanguage = "scala"
)
object AppliedAerodynamics
	extends ABaseMod(OAppliedAerodynamicsLog, ORegistries)
{
	final val ITEM_GRAVI_CHEST_PLATE: ItemArmor = new ItemGraviChestPlate(ItemArmor.ArmorMaterial.DIAMOND, 1, 1)

	@SidedProxy(
		modId = "appaero",
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroCommonProxy"
	)
	var s_proxy: ICommonProxy = null

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Start")

		GameRegistry.registerItem(AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE, AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE.getUnlocalizedName)

		this.log.info("PreInit End")
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def init(event: FMLInitializationEvent)
	{
		this.log.info("Init Start")

		FMLCommonHandler.instance.bus.register(new KeyHandler)

		this.log.info("Init End")
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def postInit(event: FMLPostInitializationEvent)
	{
		this.log.info("PostInit Start")

		this.log.info("PostInit End")
	}
}
