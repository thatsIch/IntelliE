package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import net.minecraft.item.{ItemStack, Item}


/**
 * 
 *
 * @author thatsIch
 * @since 15.09.2014.
 */
class InternalNBTItemRegistry(val items: Seq[Item], modid: ModID, log: Log) extends NBTItemRegistry
{
	def registerAll(): Unit =
	{
		this.items.foreach(item =>
		{
			val name = this.getItemName(item)
			val simpleClassName: String = item.getClass.getSimpleName

			this.log.debug(s"> Adding nbt item $simpleClassName with name $name.")
			GameRegistry.registerItem(item, name)
		})
		this.log.info(s"Finished loading ${this.items.length} nbt item(s).")
	}

	/**
	 * Gets the name which will be stored in the end in the registry
	 *
	 * @param item to be extracted name of item
	 *
	 * @return stripped down version of the itemname
	 */
	private def getItemName(item: Item): String =
	{
		val unlocalizedName: String = item.getUnlocalizedName
		val position: Int = unlocalizedName.lastIndexOf('.') + 1
		val name: String = unlocalizedName.substring(position)

		name
	}

	override lazy val itemstacks: Seq[ItemStack] = this.items.map(new ItemStack(_))
}
