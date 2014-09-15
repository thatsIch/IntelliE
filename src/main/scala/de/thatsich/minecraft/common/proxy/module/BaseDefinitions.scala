package de.thatsich.minecraft.common.proxy.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.{Definitions, Module, Recipe}
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
abstract class BaseDefinitions(val blocks: Seq[Block] = Vector(),
                               val crafthandlers: Seq[Class[_ <: ICraftHandler]] = Vector(),
                               val entites: Seq[Entity] = Vector(),
                               val fakes: Seq[Item] = Vector(),
                               val guis: Seq[BlockGuiHandler] = Vector(),
                               val items: Seq[Item] = Vector(),
                               val modules: Seq[Module] = Vector(),
                               val recipes: Seq[Recipe] = Vector(),
                               val tiles: Seq[Class[_ <: TileEntity]] = Vector())
extends Definitions

