package de.thatsich.minecraft.intellie.common.module.entity

import net.minecraft.entity.Entity
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AEntity(world: World) extends Entity(world) with IEntity
{

}
