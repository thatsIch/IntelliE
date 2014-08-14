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
abstract class BaseModule(val items: Seq[Item] = List(),
                          val blocks: Seq[Block] = List(),
                          val tiles: Seq[Class[_ <: TileEntity]] = List(),
                          val entites: Seq[Entity] = List(),
                          val recipes: Seq[Recipe] = List(),
                          val guis: Seq[BlockGuiHandler] = List(),
                          val crafthandlers: Seq[Class[_ <: ICraftHandler]] = List()
	                         )
	extends Module

