package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.{AeroCreativeTabs, AeroModules, OAeroConfigFiles}
import de.thatsich.minecraft.core.module.IModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.ItemAeroChest
import net.minecraft.item.ItemArmor
import de.thatsich.minecraft.core.network.PacketPipeline
import net.minecraft.creativetab.CreativeTabs
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots.ItemAeroBoots

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object aerodynamics
{
	implicit val log        : ILog           = new Log("Aero")
	implicit val aeroTab    : CreativeTabs   = new AeroCreativeTabs
	implicit val pipeline   : PacketPipeline = new PacketPipeline
	implicit val registries : IRegistries    = new Registries
	implicit val configFiles: IConfigFiles   = OAeroConfigFiles

	implicit val itemAeroChest: ItemAeroChest = new ItemAeroChest(ItemArmor.ArmorMaterial.DIAMOND, 1, 1)
	implicit val itemAeroBoots: ItemAeroBoots = new ItemAeroBoots(ItemArmor.ArmorMaterial.DIAMOND, 2, 3)

	implicit val modules: IModules = new AeroModules
}
