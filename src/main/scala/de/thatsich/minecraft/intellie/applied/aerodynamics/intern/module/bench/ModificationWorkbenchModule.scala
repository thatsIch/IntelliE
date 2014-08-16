package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class ModificationWorkbenchModule(log: Log, modid: ID, name: ID = new WorkbenchID, craftStorage: WorkbenchCraftRecipeStorage = WorkbenchCraftRecipeStorage) extends BaseModule(
	blocks = Vector(new WorkbenchBlock(modid, name, log)),
	recipes = Vector(new WorkbenchRecipe),
	tiles = Vector(classOf[WorkbenchTileEntity]),
	guis = Vector(new WorkbenchGuiHandler(name, log)),
	crafthandlers = Vector(classOf[WorkbenchCraftHandler])
)