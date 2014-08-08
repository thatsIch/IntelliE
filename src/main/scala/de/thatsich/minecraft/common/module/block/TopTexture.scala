package de.thatsich.minecraft
package common
package module
package block


import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import net.minecraft.world.IBlockAccess


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
trait TopTexture extends BaseBlock
{
	@SideOnly(Side.CLIENT)
	override def getIcon(side: Int, metadata: Int) =
	{
		side match
		{
			case 1 => this.getBlockIcon(side)
			case _ => super.getIcon(side, metadata)
		}
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(world: IBlockAccess, x: Int, y: Int, z: Int, side: Int): IIcon =
	{
		side match
		{
			case 1 => this.getBlockIcon(side)
			case _ => super.getIcon(world, x, y, z, side)
		}
	}

	override def getTextureName: String =
	{
		val unlocal: String = this.getUnlocalizedName
		val unwrapped: String = this.getUnwrappedUnlocalizedName(unlocal)
		val id: String = this.modid

		id + ":" + unwrapped + "_top"
	}
}
