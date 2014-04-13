package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.{AeroModules, OAeroConfigFiles}
import de.thatsich.minecraft.core.module.IModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.ItemAeroChest
import net.minecraft.item.ItemArmor

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object aerodynamics
{
	implicit val log: ILog = new Log("Aero")
	implicit val registries: IRegistries = new Registries
	implicit val configFiles: IConfigFiles = OAeroConfigFiles

	implicit val itemAeroChest: ItemAeroChest = new ItemAeroChest(ItemArmor.ArmorMaterial.DIAMOND, 1, 1)

	implicit val modules: IModules = new AeroModules
}
