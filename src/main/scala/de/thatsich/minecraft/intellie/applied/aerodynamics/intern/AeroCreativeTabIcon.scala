package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class AeroCreativeTabIcon extends Item
{
	this.setUnlocalizedName( "appaero.creativeTabIcon" )
	this.setTextureName( "appaero:aerochest" )
	GameRegistry.registerItem( this, this.getUnlocalizedName )
}
