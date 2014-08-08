package de.thatsich.minecraft
package common
package module
package block


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.ID
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockContainer}


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
abstract class BaseBlock(protected val modid: ID, blockName: ID, protected val log: Log, mat: Material = Material.iron) extends BlockContainer(mat)
{
	private final val name: String = this.blockName

	this.setBlockName(this.name)

	def getUnwrappedUnlocalizedName(unlocalizedName: String): String =
	{
		unlocalizedName.substring(unlocalizedName.indexOf(".") + 1)
	}

	override def getUnlocalizedName: String =
	{
		val unwrapped: String = getUnwrappedUnlocalizedName(super.getUnlocalizedName)
		val id: String = this.modid

		s"$id:$unwrapped"
	}

	override def setBlockName(name: String): Block =
	{
		val id: String = this.modid
		super.setBlockName(s"$id.$name")
	}
}
