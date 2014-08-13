package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import cpw.mods.fml.relauncher.{SideOnly, Side}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.string.ID
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs(icon: Item, registrable: Seq[Module], log: Log, modid: ID) extends CreativeTabs(modid)
{
	registrable.foreach
	{
		case item: Item   => item.setCreativeTab(this)
		case block: Block => block.setCreativeTab(this)

		case _ =>
	}

	@SideOnly(Side.CLIENT)
	override def getTabIconItem: Item =
	{
		this.icon
	}

	override def getTranslatedTabLabel: String = {
		val id: String = this.modid

		s"$id.tab.name"
	}
}
