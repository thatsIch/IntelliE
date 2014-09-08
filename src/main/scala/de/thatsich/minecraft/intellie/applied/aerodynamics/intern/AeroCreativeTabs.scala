package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs(icon: Item, blocks: Seq[Block], items: Seq[Item], log: Log, modid: ID) extends CreativeTabs(modid)
{
	private var blockCount = 0
	private var itemCount = 0
	this.blocks.foreach(block => {
		this.log.debug(s"Add block ${block.getClass.getSimpleName} to this creative tab")
		block.setCreativeTab(this)
		this.blockCount += 1
	})
	this.items.foreach(item => {
		if (!item.getToolClasses(null).contains("fake"))
		{
			this.log.debug(s"Add item ${item.getClass.getSimpleName} to this creative tab")
			item.setCreativeTab(this)
			this.itemCount += 1
		}
	})
	this.log.info(s"Added $blockCount blocks and $itemCount items to AeroCreativeTabs.")

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
