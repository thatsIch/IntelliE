package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.item.PoweredItemDamageDisplay
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item.ArmorType.ArmorType
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
abstract class BasePoweredItemArmor(armorType: ArmorType, modid: ID, itemName: ID, log: Log)
	extends BaseItemArmor(armorType, modid, itemName, log)
	        with PoweredItemDamageDisplay
{
	override def addInformation(itemStack: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(itemStack)
		val maxPower = this.getAEMaxPower(itemStack)

		val percent = (currentPower / maxPower * 100).toInt

		val list = information.asInstanceOf[java.util.List[String]]

		val message = s"Stored Energy: $currentPower AE - $percent%"


		list.add(message)
	}
}
