package de.thatsich.minecraft.api.mod.module

import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
abstract class BaseModule( val item: Option[ Item ],
                           val block: Option[ Block ],
                           val entity: Option[ Entity ],
                           val tileEntity: Option[ TileEntity ] )
	extends Module