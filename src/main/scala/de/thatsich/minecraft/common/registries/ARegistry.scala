package de.thatsich.minecraft.common.registries

import scala.collection.mutable
import de.thatsich.minecraft.common.logger.ILog

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ARegistry[ T ](log: ILog) extends IRegistry[ T ]
{
	protected val set: mutable.Queue[ T ] = new mutable.Queue[ T ]()

	def add(elem: T)
	{
		this.set += elem
		this.log.info("Queued " + elem + " for registration")
	}
}
