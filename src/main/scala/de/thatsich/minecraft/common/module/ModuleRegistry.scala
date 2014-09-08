package de.thatsich.minecraft.common.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.gui.BlockGuiHandler
import de.thatsich.minecraft.common.module.recipe.Recipe
import de.thatsich.minecraft.common.module.registry.{FakeItemRegistry, BlockRegistry, CraftHandlerRegistry, EntityRegistry, GuiRegistry, ItemRegistry, RecipeRegistry, TileEntityRegistry}
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

import scala.collection._


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class ModuleRegistry(modules: Seq[Module], modid: ID, log: Log)
{
	val blocks = mutable.ArrayBuffer[Block]()
	val crafts = mutable.ArrayBuffer[Class[_ <: ICraftHandler]]()
	val entities = mutable.ArrayBuffer[Entity]()
	val fakes = mutable.ArrayBuffer[Item]()
	val guis = mutable.ArrayBuffer[BlockGuiHandler]()
	val items = mutable.ArrayBuffer[Item]()
	val recipes = mutable.ArrayBuffer[Recipe]()
	val tiles = mutable.ArrayBuffer[Class[_ <: TileEntity]]()

	this.modules.foreach(this.addModule)

	val blockRegistry = new BlockRegistry(this.blocks, this.log)
	val craftRegistry = new CraftHandlerRegistry(this.crafts, this.log)
	val entityRegistry = new EntityRegistry(this.entities, this.log)
	val fakeRegistry = new FakeItemRegistry(this.fakes, this.modid, this.log)
	val guiRegistry = new GuiRegistry(this.guis, this.log)
	val itemRegistry = new ItemRegistry(this.items, this.modid, this.log)
	val recipeRegistry = new RecipeRegistry(this.recipes, this.log)
	val tileRegistry = new TileEntityRegistry(this.tiles, this.log)

	private def addModule(module: Module): Unit =
	{
		this.blocks ++= module.blocks
		this.crafts ++= module.crafthandlers
		this.entities ++= module.entites
		this.fakes ++= module.fakes
		this.guis ++= module.guis
		this.items ++= module.items
		this.recipes ++= module.recipes
		this.tiles ++= module.tiles

		module.modules.foreach(this.addModule)
	}
}
