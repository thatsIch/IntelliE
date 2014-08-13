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
 * @since 13.04.2014.
 */
abstract class BaseModule(val items: List[Item] = List(),
                          val blocks: List[Block] = List(),
                          val tiles: List[Class[TileEntity]] = List(),
                          val entites: List[Entity] = List(),
                          val recipes: List[Recipe] = List(),
                          val guis: List[BlockGuiHandler] = List(),
                          val crafthandlers: List[Class[ICraftHandler]] = List()
	                         ) extends Module

