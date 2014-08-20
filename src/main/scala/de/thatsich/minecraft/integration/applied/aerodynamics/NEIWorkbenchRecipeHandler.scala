package de.thatsich.minecraft.integration.applied.aerodynamics


import codechicken.nei.recipe.TemplateRecipeHandler
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.util.{StatCollector, ResourceLocation}


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
class NEIWorkbenchRecipeHandler extends TemplateRecipeHandler
{
	def getGuiTexture: String =
	{
		val resloc = new ResourceLocation(AppliedAerodynamics.id, "textures/gui/workbench.png")

		resloc.toString
	}

	def getRecipeName: String = StatCollector.translateToLocal("appaero.gui.workbench.name")
}
