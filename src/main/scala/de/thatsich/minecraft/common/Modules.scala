package de.thatsich.minecraft.common


import de.thatsich.minecraft.common.module.Module


/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
trait Modules
{
	protected val modules: Seq[Module]
}

object Modules
{
	implicit def modulesToList(modules: Modules): Seq[AnyRef] =
	{
		val seqOfModule: Seq[Module] = modules.modules
		val flatten: Seq[AnyRef] = seqOfModule.flatten

		flatten
	}
}
