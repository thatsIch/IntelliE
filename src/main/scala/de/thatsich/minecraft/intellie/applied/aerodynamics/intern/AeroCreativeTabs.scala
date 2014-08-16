package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.string.id.ID
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
	for (module: Module <- this.registrable)
	{
		this.log.debug(s"Scanning ${module.getClass.getSimpleName} for blocks and items.")
		module.blocks.foreach(block =>
		{
			this.log.debug(s"Add block ${block.getClass.getSimpleName} to this creative tab")
			block.setCreativeTab(this)
		})
		module.items.foreach(item =>
		{
			this.log.debug(s"Add item ${item.getClass.getSimpleName} to this creative tab")
			if (!item.getToolClasses(null).contains("fake"))
			{
				item.setCreativeTab(this)
			}
		})
	}

	@SideOnly(Side.CLIENT)
	override def getTabIconItem: Item =
	{
		this.icon
	}

	override def getTranslatedTabLabel: String =
	{
		val id: String = this.modid

		s"$id.tab.name"
	}
}
