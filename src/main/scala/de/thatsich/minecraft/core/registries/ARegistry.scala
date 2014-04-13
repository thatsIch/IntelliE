package de.thatsich.minecraft.core.registries

import scala.collection.mutable
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ARegistry[ T ](protected val log: ILog) extends IRegistry[ T ]
{
	protected val set: mutable.Queue[ T ] = new mutable.Queue[ T ]()
	protected val map = new mutable.HashMap[ Class[ _ <: T ], T ]()

	def add(elem: T)
	{
		this.set += elem
		this.log.info("Queued " + elem + " for registration")
	}
}
