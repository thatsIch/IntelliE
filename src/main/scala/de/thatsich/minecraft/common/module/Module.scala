package de.thatsich.minecraft.common.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.module.gui.BlockGuiHandler
import de.thatsich.minecraft.common.module.recipe.Recipe
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
trait Module
{
	val items: Seq[Item]
	val blocks: Seq[Block]
	val tiles: Seq[Class[_ <: TileEntity]]
	val entites: Seq[Entity]
	val recipes: Seq[Recipe]
	val guis: Seq[BlockGuiHandler]
	val crafthandlers: Seq[Class[_ <: ICraftHandler]]
}