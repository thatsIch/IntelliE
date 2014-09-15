package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy


import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.{InternalSkystoneIngotModule, SkystoneIngotModule, CreativetabsModule, DisassemblerModule, InternalCreativetabsModule, InternalDisassemblerModule, InternalSuiteModule, InternalWorkbenchModule, SuiteModule, WorkbenchModule}
import net.minecraft.item.Item


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class InternalAeroModules(icon: Item, modid: ModID, log: Log) extends AeroModules
{
	val workbench: WorkbenchModule = new InternalWorkbenchModule(this.modid, this.log)
	val disassembler: DisassemblerModule = new InternalDisassemblerModule(this.modid, this.log)
	val suite: SuiteModule = new InternalSuiteModule(this.modid, this.log)
	val skystoneingot: SkystoneIngotModule = new InternalSkystoneIngotModule(this.modid, this.log)
	val creativetabs: CreativetabsModule = new InternalCreativetabsModule(this.icon, this.modid, this.log)

	val vectorized = Vector[Module](this.workbench, this.disassembler, this.suite, this.skystoneingot, this.creativetabs)
}
