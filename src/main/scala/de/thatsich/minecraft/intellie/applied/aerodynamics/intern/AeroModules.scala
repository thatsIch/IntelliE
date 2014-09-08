package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.ModificationWorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab.AeroCreativeTabsModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler.DisassemblerModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.SuiteModule
import net.minecraft.item.Item


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class AeroModules(icon: Item, modid: ID, log: Log)
{
	val disassembler = new DisassemblerModule(this.log, this.modid)
	val workbench = new ModificationWorkbenchModule(this.log, this.modid)
	val suite = new SuiteModule(this.modid, this.log)
	val creativetabs = new AeroCreativeTabsModule(this.icon, this.log, this.modid)

	val vector = Vector(this.disassembler, this.workbench, this.suite, this.creativetabs)
}
