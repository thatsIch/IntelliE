package de.thatsich.minecraft.common.module


/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
trait Module
{
	protected val moduleParts: Seq[AnyRef]
}

object Module
{
	implicit def moduleToSeq(module: Module): Seq[AnyRef] =
	{
		module.moduleParts
	}
}

