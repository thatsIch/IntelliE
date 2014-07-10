package de.thatsich.minecraft.api.mod.module.tileentity

import net.minecraft.tileentity.{TileEntity => MCTE}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseTileEntity( val category: String, val key: String, val tileEntityID: String )
	extends MCTE
	        with TileEntity
{}