package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import appeng.api.recipes.{ResolverResult, ISubItemResolver}
import de.thatsich.minecraft.intellie.applied.aerodynamics.api.AeroModInfo

/**
 *
 *
 * @author thatsIch
 * @since 02.08.2014.
 */
class AeroNameHandler extends ISubItemResolver
{
	def resolveItemByName( namespace: String, fullName: String ): AnyRef =
	{
		if( !namespace.equals( AeroModInfo.id ) ) return null

		fullName match
		{
			case "dissembler" => new ResolverResult("dissembler", 0)
			case _ => null
		}

	}
}
