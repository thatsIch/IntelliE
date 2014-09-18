package de.thatsich.minecraft.common


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.proxy.module.BlockGuiHandler
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
trait Definitions
{
	def blocks: Seq[Block]

	def crafthandlers: Seq[Class[_ <: ICraftHandler]]

	def entites: Seq[Entity]

	def fakes: Seq[Item]

	def guis: Seq[BlockGuiHandler]

	def items: Seq[Item]

	def modules: Seq[Module]

	def recipes: Seq[Recipe]

	def tiles: Seq[Class[_ <: TileEntity]]
}