package de.thatsich.minecraft.intellie.applied.aerodynamics

import de.thatsich.minecraft.intellie.applied.aerodynamics.module.{DisassemblerModule, SuiteModule, WorkbenchModule}
import de.thatsich.minecraft.intellie.common.Modules


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait AeroModules extends Modules
{
	def workbench: WorkbenchModule

	def disassembler: DisassemblerModule

	def suite: SuiteModule
}
