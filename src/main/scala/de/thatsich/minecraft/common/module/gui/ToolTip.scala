package de.thatsich.minecraft.common.module.gui


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
trait ToolTip
{
	def toolTipMessage: String

	def toolTipXActivationPos: Int

	def toolTipYActivationPos: Int

	def toolTipActivationWidth: Int

	def toolTipActivationHeight: Int

	def toolTipIsVisisble: Boolean
}
