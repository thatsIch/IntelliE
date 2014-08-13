package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class ModificationWorkbenchModule(log: Log, modid: ID, name: ID = new WorkbenchID) extends BaseModule(
	blocks = List(new WorkbenchBlock(modid, name, log)),
	recipes = List(new WorkbenchRecipe),
	tiles = List(classOf[WorkbenchTileEntity]),
	guis = List(new WorkbenchGuiHandler(name, log))
)