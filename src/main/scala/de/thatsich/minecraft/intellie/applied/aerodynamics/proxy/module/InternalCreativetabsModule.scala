package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.creativetab.AeroCreativeTabsDefinitions
import de.thatsich.minecraft.intellie.common.Definitions
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.item.Item


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalCreativetabsModule(icon: Item, modid: ID, log: Log) extends CreativetabsModule
{
	override lazy val definitions: Definitions = new AeroCreativeTabsDefinitions(this.icon, this.modid, this.log)
}
