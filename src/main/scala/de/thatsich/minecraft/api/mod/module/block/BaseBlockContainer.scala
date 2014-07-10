package de.thatsich.minecraft.api.mod.module.block

import de.thatsich.minecraft.api.mod.module.BaseTexture
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
abstract class BaseBlockContainer( info: BaseBlockInfo, config: BaseBlockConfig, gui: BaseBlockGui, network: BaseBlockNetwork, texture: BaseTexture, tileEntityClass: Class[ _ => TileEntity ], itemBlockClass: Class[ _ <: ItemBlock ] )
	extends BlockContainer( info.material )
{
	def getItemBlockClass: Class[ _ <: ItemBlock ] =
	{
		this.itemBlockClass
	}

	override def createNewTileEntity( world: World, metadata: Int ): TileEntity =
	{
		this.tileEntityClass.newInstance( ).asInstanceOf[ TileEntity ]
	}
}
