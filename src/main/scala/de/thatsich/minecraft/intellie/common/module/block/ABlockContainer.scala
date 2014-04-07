package de.thatsich.minecraft.intellie.common.module.block

import net.minecraft.block.BlockContainer
import de.thatsich.minecraft.intellie.common.module.item.AItemBlock
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import de.thatsich.minecraft.intellie.common.module.tileentities.ATileEntity
import de.thatsich.minecraft.intellie.common.module.ATexture

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ABlockContainer(info: ABlockInfo, config: ABlockConfig, gui: ABlockGui, network: ABlockNetwork, texture: ATexture, tileEntityClass: Class[ _ => ATileEntity ], itemBlockClass: Class[ _ => AItemBlock ])
	extends BlockContainer(info.getMaterial)
	with IBlockContainer
{
	@Override def getItemBlockClass: Nothing =
	{
		this.itemBlockClass
	}

	@Override def createNewTileEntity(world: World, metadata: Int): TileEntity =
	{
		val tileEntity: ATileEntity = this.injector.get(this.tileEntityClass)
		this.tileEntities.add(tileEntity)

		tileEntity
	}
}
