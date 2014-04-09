package de.thatsich.minecraft.core.module.block

import net.minecraft.block.BlockContainer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import de.thatsich.minecraft.core.module.tileentities.ITileEntity
import de.thatsich.minecraft.core.module.ATexture
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlockContainer(info: ABlockInfo, config: ABlockConfig, gui: ABlockGui, network: ABlockNetwork, texture: ATexture, tileEntityClass: Class[ _ => ITileEntity ], itemBlockClass: Class[ _ <: ItemBlock ])
	extends BlockContainer(info.getMaterial)
	with IBlockContainer
{
	def getItemBlockClass: Class[ _ <: ItemBlock ] =
	{
		this.itemBlockClass
	}

	def createNewTileEntity(world: World, metadata: Int): TileEntity =
	{
		this.tileEntityClass.newInstance().asInstanceOf[ TileEntity ]
	}
}
