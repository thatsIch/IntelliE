package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IIcon
import net.minecraft.world.{IBlockAccess, World}

/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchBlock extends BlockContainer( Material.iron )
{
	private var iconSide  : IIcon = null
	private var iconTop   : IIcon = null
	private var iconBottom: IIcon = null

	this.setBlockName( "appaero.workbench" )
	this.setBlockTextureName( "workbench" )

	@SideOnly( Side.CLIENT )
	override def registerBlockIcons( register: IIconRegister ): Unit =
	{
		this.iconTop = register.registerIcon( "appaero:workbench_top" )
		this.iconSide = register.registerIcon( "appaero:workbench_side" )
		this.iconBottom = register.registerIcon( "appaero:workbench_bottom" )
	}

	@SideOnly( Side.CLIENT )
	override def getIcon( workd: IBlockAccess, x: Int, y: Int, z: Int, side: Int ): IIcon =
	{
		side match
		{
			case 0 => this.iconBottom
			case 1 => this.iconTop

			case _ => this.iconSide
		}
	}

	@SideOnly( Side.CLIENT )
	override def getIcon( side: Int, meta: Int ): IIcon =
	{
		side match
		{
			case 0 => this.iconBottom
			case 1 => this.iconTop

			case _ => this.iconSide
		}
	}

	def createNewTileEntity( p_149915_1_ : World, p_149915_2_ : Int ): TileEntity = new WorkbenchTileEntity
}
