package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.creativetab


import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.Item


/**this.log.debug(s"Add item ${item.getClass.getSimpleName} to this creative tab")
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class AeroCreativeTabIcon(id: ID) extends Item
{
	private val modid: String = this.id

	this.setUnlocalizedName(s"$modid.creativeTabIcon")
	this.setTextureName(s"$modid:creativeicon")
	this.setHarvestLevel("fake", 0)
}
