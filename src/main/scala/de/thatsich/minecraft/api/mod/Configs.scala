package de.thatsich.minecraft.api.mod

import de.thatsich.minecraft.api.mod.config.Config

/**
 *
 *
 * @author thatsIch
 * @since 11.07.2014.
 */
trait Configs
{
	protected val configs: Seq[ Config ]
}

object Configs
{
	implicit def configsToSeq( configs: Configs ): Seq[ Config ] =
	{
		configs.configs
	}
}
