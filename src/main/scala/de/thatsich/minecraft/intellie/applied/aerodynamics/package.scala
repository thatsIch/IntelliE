package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.{OAeroModules, OAeroConfigFiles}
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
	implicit final val log: ILog = new Log("Aero")
	implicit final val registries: IRegistries = new Registries
	implicit final val configFiles: IConfigFiles = OAeroConfigFiles
	implicit final val modules: IModules = OAeroModules

	implicit final val itemAeroChest = new ItemAeroChest(ItemArmor.ArmorMaterial.DIAMOND, 1, 1)
}
