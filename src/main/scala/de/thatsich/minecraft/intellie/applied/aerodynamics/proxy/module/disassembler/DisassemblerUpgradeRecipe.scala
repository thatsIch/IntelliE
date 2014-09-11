package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import de.thatsich.minecraft.common.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.recipe.{InternalDisassemblerUpgradeRecipePath, ExternalDisassemblerUpgradeRecipePath}


/**
 *
 *
 * @author thatsIch
 * @since 14.08.2014.
 */
class DisassemblerUpgradeRecipe
	extends BaseRecipe(
		new InternalDisassemblerUpgradeRecipePath,
		new ExternalDisassemblerUpgradeRecipePath
	)
