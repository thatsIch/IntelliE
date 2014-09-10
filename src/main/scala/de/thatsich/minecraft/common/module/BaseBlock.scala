package de.thatsich.minecraft.common.module


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockContainer}
import net.minecraft.util.IIcon


/**
 *
 *
 * @author thatsIch
 * @since 08.08.2014.
 */
abstract class BaseBlock(protected val modid: ID, blockName: ID, protected val log: Log, mat: Material = Material.iron) extends BlockContainer(mat)
{
	private final val name: String = this.blockName
	private final val id: String = this.modid

	this.setBlockName(this.name)
	this.setResistance(10)
	this.setHardness(2.2F)
	this.setStepSound(Block.soundTypeMetal)
	this.setHarvestLevel("pickaxe", 0)

	@SideOnly(Side.CLIENT)
	def getBlockIcon(side: Int): IIcon = this.blockIcon

	/**
	 * appaero.tile.workbench
	 * appaero.tile.workbench.name
	 *
	 * @return unlocalized name
	 */
	override def getUnlocalizedName: String =
	{
		s"$id.tile.$name"
	}

	def getName: String = this.name

	/**
	 * appaero.workbench
	 *
	 * @param name name of workbench
	 *
	 * @return itself
	 */
	override def setBlockName(name: String): Block =
	{
		val id: String = this.modid

		super.setBlockName(s"$id.$name")
	}
}
