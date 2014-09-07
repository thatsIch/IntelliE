package de.thatsich.minecraft.intellie.applied.aerodynamics.common

import de.thatsich.minecraft.intellie.applied.aerodynamics.module.{DisassemblerModule, SuiteModule, WorkbenchModule}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait Modules
{
	val workbench: WorkbenchModule

	val disassembler: DisassemblerModule

	val suite: SuiteModule
}
