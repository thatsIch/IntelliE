package de.thatsich.minecraft.intellie


import cpw.mods.fml.common.{Loader, Mod}
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.util.string.BaseAbbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aeronei.AppliedAerodynamicsNei
import de.thatsich.minecraft.intellie.applied.agricultures.AppliedAgricultures
import de.thatsich.minecraft.intellie.applied.intelligences.AppliedIntelligences
import de.thatsich.minecraft.intellie.child.{ChildUnloaderConfigAccess, ChildUnloader}


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = IntelligentEnergistics.id,
	name = IntelligentEnergistics.name,
	version = IntelligentEnergistics.version,
	dependencies = IntelligentEnergistics.dependencies,
	modLanguage = "scala"
)
object IntelligentEnergistics
{
	final val id = "intellie"
	final val name = "Intelligent Energistics"
	final val version = "@version@"
	final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);required-after:appliedenergistics2@[rv1-stable-1,);after:NotEnoughItems"

	private val log = new SimpleLog(new BaseAbbreviation("IE"))

	private val unloader = new ChildUnloader
	private val unloaderConfig = new ChildUnloaderConfigAccess

	this.unloader.unload(AppliedAerodynamics.id, this.unloaderConfig.disableAero, this.log)
	this.unloader.unload(AppliedAgricultures.id, this.unloaderConfig.disableAgro, this.log)
	this.unloader.unload(AppliedIntelligences.id, this.unloaderConfig.disableInt, this.log)

	this.unloader.unload(AppliedAerodynamicsNei.id, this.unloaderConfig.disableAero || this.unloaderConfig.disableAeroNEI || this.unloaderConfig.disableNEI || !Loader.isModLoaded("NotEnoughItems"), this.log)
}
