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
	val items: List[Item]
	val blocks: List[Block]
	val tiles: List[Class[TileEntity]]
	val entites: List[Entity]
	val recipes: List[Recipe]
	val guis: List[BlockGuiHandler]
	val crafthandlers: List[Class[ICraftHandler]]
}