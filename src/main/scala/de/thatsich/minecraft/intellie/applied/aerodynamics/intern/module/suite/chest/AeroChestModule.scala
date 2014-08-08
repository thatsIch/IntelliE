package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.chest


import de.thatsich.minecraft.common.module.BaseModule
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
object AeroChestModule extends AeroChestModule(new AeroChestItem)

class AeroChestModule(itemAeroChest: AeroChestItem) extends BaseModule(Some[Item](itemAeroChest), None, None, None)