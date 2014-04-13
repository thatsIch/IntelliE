package de.thatsich.minecraft.core.module

import scala.collection.mutable
import de.thatsich.minecraft.core.registries.IRegistries

/**
 * Simple abstract class
 * for simplifying adding and getting
 * modules
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
abstract class AModules(implicit registries: IRegistries)
	extends IModules
{
	private[ this ] final val map = new mutable.HashMap[ Class[ _ <: AModule ], AModule ]()

	protected final def add(module: AModule)
	{
		this.map.put(module.getClass, module)
	}

	protected final def get(moduleClass: Class[ _ <: AModule ]): Option[ AModule ] =
	{
		this.map.get(moduleClass)
	}
}
