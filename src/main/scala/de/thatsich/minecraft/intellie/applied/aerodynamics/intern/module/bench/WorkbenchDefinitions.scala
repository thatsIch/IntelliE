package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchDefinitions(modid: ID, log: Log, name: ID = new WorkbenchID, craftStorage: WorkbenchCraftRecipeStorage = WorkbenchCraftRecipeStorage) extends BaseDefinitions(
	blocks = Vector(new WorkbenchBlock(modid, name, log)),
	recipes = Vector(new WorkbenchRecipe),
	tiles = Vector(classOf[WorkbenchTileEntity]),
	guis = Vector(new WorkbenchGuiHandler(name, log)),
	crafthandlers = Vector(classOf[WorkbenchCraftHandler])
)