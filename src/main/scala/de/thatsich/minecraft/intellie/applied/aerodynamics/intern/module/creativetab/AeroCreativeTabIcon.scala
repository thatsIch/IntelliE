package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.creativetab


import de.thatsich.minecraft.intellie.common.util.string.ID
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
	this.setTextureName(s"$modid:aerochest")
	this.setHarvestLevel("fake", 0)
}
