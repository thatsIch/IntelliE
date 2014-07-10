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
	final val id          : String = "intellie"
	final val name        : String = "Intelligent Energistics"
	final val version     : String = "${version}"
	final val dependencies: String = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2"
}
