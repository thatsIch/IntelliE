package de.thatsich.minecraft.intellie.api

import de.thatsich.minecraft.api.mod.ModInfo

/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
object IEModInfo extends ModInfo
{
	final val id           = "intellie"
	final val name         = "Intelligent Energistics"
	final val version      = "${version}"
	final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2"
	final val abbreviation = "IE"
}
