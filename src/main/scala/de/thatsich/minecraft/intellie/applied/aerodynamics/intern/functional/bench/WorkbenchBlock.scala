package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchBlock extends BlockContainer( Material.iron )
{
	this.setBlockName( "appaero.workbench" )
	this.setBlockTextureName( "workbench" )

	@SideOnly( Side.CLIENT )
	override def registerBlockIcons( p_149651_1_ : IIconRegister ): Unit =
	{

	}

	def createNewTileEntity( p_149915_1_ : World, p_149915_2_ : Int ): TileEntity = new WorkbenchTileEntity
}
