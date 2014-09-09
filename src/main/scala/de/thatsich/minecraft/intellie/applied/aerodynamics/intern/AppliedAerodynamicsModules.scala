package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.AeroModules
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.{InternalCreativetabsModule, InternalDisassemblerModule, InternalSuiteModule, InternalWorkbenchModule}
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.{CreativetabsModule, DisassemblerModule, SuiteModule, WorkbenchModule}
import de.thatsich.minecraft.intellie.common.Module
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.item.Item


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class AppliedAerodynamicsModules(icon: Item, modid: ID, log: Log) extends AeroModules
{
	val disassembler: DisassemblerModule = new InternalDisassemblerModule(this.modid, this.log)
	val workbench: WorkbenchModule = new InternalWorkbenchModule(this.modid, this.log)
	val suite: SuiteModule = new InternalSuiteModule(this.modid, this.log)
	val creativetabs: CreativetabsModule = new InternalCreativetabsModule(this.modid, this.log)

	val vectorized = Vector[Module](this.disassembler, this.workbench, this.suite, this.creativetabs)
}
