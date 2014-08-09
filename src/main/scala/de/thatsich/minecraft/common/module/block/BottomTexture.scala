package de.thatsich.minecraft.common.module.block


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
trait BottomTexture extends BaseBlock
{
	var iconBot: IIcon = null

	@SideOnly(Side.CLIENT)
	def getBotIcon(side: Int) = this.iconBot

	@SideOnly(Side.CLIENT)
	override def getIcon(side: Int, metadata: Int) =
	{
		side match
		{
			case 0 => this.getBotIcon(side)
			case _ => super.getIcon(side, metadata)
		}
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(world: IBlockAccess, x: Int, y: Int, z: Int, side: Int): IIcon =
	{
		side match
		{
			case 0 => this.getBotIcon(side)
			case _ => super.getIcon(world, x, y, z, side)
		}
	}

	@SideOnly(Side.CLIENT)
	abstract override def registerBlockIcons(register: IIconRegister) =
	{
		super.registerBlockIcons(register)

		val unlocal: String = this.getUnlocalizedName
		val unwrapped: String = this.getUnwrappedUnlocalizedName(unlocal)
		val id: String = this.modid
		val icon = id + ":" + unwrapped + "_bot"

		this.iconBot = register.registerIcon(icon)
	}
}
