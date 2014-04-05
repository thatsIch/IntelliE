package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.intellie.common.TIELog
import de.thatsich.minecraft.common.{Config, TModUnloader}
import java.io.File
import com.google.common.base.Joiner

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = "intellie",
	name = "IntelligentEnergistics",
	version = "${version}",
	dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2",
	modLanguage = "scala"
)
object IntelligentEnergistics extends TIELog with TModUnloader
{
	private val modName = this.getClass.getSimpleName
	private val configPath = Joiner.on(File.separatorChar).join("config", "AppliedEnergistics2", "IntelliE", this.modName + ".cfg")
	private val config = new Config(this.configPath)
	private val loadAero = this.config.getBoolean("ChildMods", "enableAppliedAerodynamics", defaultValue = true)
	private val loadAgro = this.config.getBoolean("ChildMods", "enableAppliedAgricultures", defaultValue = true)
	private val loadInt = this.config.getBoolean("ChildMods", "enableAppliedIntelligences", defaultValue = true)

	if( !loadAero ) this.unload("appaero")
	if( !loadAgro ) this.unload("appagri")
	if( !loadInt ) this.unload("appint")

	this.config.save()

	@Mod.EventHandler def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Start")
		//		super.preInit (event)

		//		GameRegistry.registerItem (AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE, AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE.getUnlocalizedName)

		this.log.info("PreInit End")
	}

	@Mod.EventHandler def init(event: FMLInitializationEvent)
	{
		this.log.info("Init Start")

		this.log.info("Init End")
	}

	@Mod.EventHandler def postInit(event: FMLPostInitializationEvent)
	{
		this.log.info("PostInit Start")

		this.log.info("PostInit End")
	}
}
