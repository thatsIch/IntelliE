package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ID


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
	guis = Vector(new WorkbenchGuiHandler(name, log, craftStorage)),
	crafthandlers = Vector(classOf[WorkbenchCraftHandler])
)