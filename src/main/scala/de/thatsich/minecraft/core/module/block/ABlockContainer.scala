package de.thatsich.minecraft.core.module.block

import de.thatsich.minecraft.core.module.BaseTexture
import de.thatsich.minecraft.core.module.tileentities.ITileEntity
import net.minecraft.block.BlockContainer
import net.minecraft.item.ItemBlock
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlockContainer( info: ABlockInfo, config: ABlockConfig, gui: ABlockGui, network: ABlockNetwork, texture: BaseTexture, tileEntityClass: Class[ _ => ITileEntity ], itemBlockClass: Class[ _ <: ItemBlock ] )
	extends BlockContainer( info.getMaterial )
	        with IBlockContainer
{
	def getItemBlockClass: Class[ _ <: ItemBlock ] =
	{
		this.itemBlockClass
	}

	def createNewTileEntity( world: World, metadata: Int ): TileEntity =
	{
		this.tileEntityClass.newInstance( ).asInstanceOf[ TileEntity ]
	}
}
