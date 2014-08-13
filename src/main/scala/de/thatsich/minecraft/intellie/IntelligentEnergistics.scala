package de.thatsich.minecraft.intellie


import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.intellie.child.ChildUnloader


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
object IntelligentEnergistics extends ChildUnloader
{
	final val id = "intellie"
	final val name = "Intelligent Energistics"
	final val version = "${version}"
	final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2"

	this.unload("appaero", this.disableAero)
	this.unload("appagri", this.disableAgro)
	this.unload("appint", this.disableInt)
}