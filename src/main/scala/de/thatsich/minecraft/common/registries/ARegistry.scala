package de.thatsich.minecraft.common.registries

import scala.collection.mutable
import de.thatsich.minecraft.common.logger.ALog

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ARegistry[ T ] extends IRegistry[ T ]
{
	protected val set: mutable.Queue[ T ] = new mutable.Queue[ T ]()

	def add(elem: T)(implicit log: ALog)
	{
		this.set += elem
		log.info("Queued " + elem + " for registration")
	}
}
