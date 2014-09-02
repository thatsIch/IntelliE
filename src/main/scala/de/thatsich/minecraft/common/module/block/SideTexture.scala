package de.thatsich.minecraft.common.module.block


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.module.BaseBlock
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import net.minecraft.world.IBlockAccess


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
trait SideTexture extends BaseBlock
{
	var iconSide: IIcon = null

	@SideOnly(Side.CLIENT)
	override def getIcon(side: Int, metadata: Int) =
	{
		side match
		{
			case 2 | 3 | 4 | 5 => this.getSideIcon(side)
			case _             => super.getIcon(side, metadata)
		}
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(world: IBlockAccess, x: Int, y: Int, z: Int, side: Int): IIcon =
	{
		side match
		{
			case 2 | 3 | 4 | 5 => this.getSideIcon(side)
			case _             => super.getIcon(world, x, y, z, side)
		}
	}

	@SideOnly(Side.CLIENT)
	def getSideIcon(side: Int) = this.iconSide

	@SideOnly(Side.CLIENT)
	abstract override def registerBlockIcons(register: IIconRegister) =
	{
		super.registerBlockIcons(register)

		val id: String = this.modid
		val icon: String = id + ":" + this.getName + "_side"

		this.iconSide = register.registerIcon(icon)
	}
}
