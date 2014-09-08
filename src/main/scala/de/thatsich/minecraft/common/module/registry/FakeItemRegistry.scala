package de.thatsich.minecraft.common.module.registry


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.SimpleFakeItem
import de.thatsich.minecraft.common.module.registry.fake.NBTKeyCollector
import de.thatsich.minecraft.common.string.id.SimpleID
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.{ItemStack, Item}

import scala.collection.Seq
import scala.collection.mutable.{Set => MutableSet}


/**
 * 
 *
 * @author thatsIch
 * @since 06.09.2014.
 */
class FakeItemRegistry(registrable: Seq[ItemStack], modid: ID, log: Log)
{
	/**
 * Registers all items in modules
 */
	def registerAll(): Set[Item] =
	{
		val collector = new NBTKeyCollector(this.registrable)
		val fakes = MutableSet[Item]()
		val keys = collector.getNBTKeys

		keys.foreach(key =>
		{
			val id = new SimpleID(key)
			val item = new SimpleFakeItem(this.modid, id, this.log)
			fakes += item

			this.log.debug(s"Adding fake item $key")
			GameRegistry.registerItem(item, key)
		})
		this.log.info(s"Finished loading ${keys.size} fake item(s).")

		fakes.toSet
	}
}
