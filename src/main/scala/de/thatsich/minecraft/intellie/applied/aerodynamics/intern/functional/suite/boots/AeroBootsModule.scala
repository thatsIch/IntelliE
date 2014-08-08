package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.boots


import de.thatsich.minecraft.common.module.BaseModule
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
object AeroBootsModule extends AeroBootsModule(AeroBootsItem)

class AeroBootsModule(itemAeroBoots: AeroBootsItem) extends BaseModule(Some[Item](itemAeroBoots), None, None, None)