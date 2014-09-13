package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.{UniqueItem, UnstackableItem}
import de.thatsich.minecraft.common.util.string.{ModID, ID}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.ArmorType.ArmorType
import net.minecraft.block.BlockDispenser
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemArmor, ItemStack}
import net.minecraft.world.World
import net.minecraftforge.common.ISpecialArmor


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
abstract class BaseItemArmor(armorType: ArmorType, modid: ModID, itemid: ID, log: Log)
	extends ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, armorType)
	        with ISpecialArmor
	        with UnstackableItem
	        with UniqueItem
{
	private final val name: String = this.itemid
	private final val id: String = this.modid

	this.setUnlocalizedName(this.name)
	this.setTextureName(s"$id:$name")
	this.setMaxDamage(0)

	BlockDispenser.dispenseBehaviorRegistry.putObject(this, new AeroDispenseBehavior())

	override def getUnlocalizedName(is: ItemStack): String = this.getUnlocalizedName

	override def getUnlocalizedName: String = s"$id.item.$name"

	/**
	 * integrates the mod id into the item
	 *
	 * @param name name of the item
	 *
	 * @return itself
	 */
	override def setUnlocalizedName(name: String): Item = super.setUnlocalizedName(s"$id.$name")

	override def onItemRightClick(is: ItemStack, world: World, player: EntityPlayer): ItemStack =
	{
		val pos: Int = 3 - armorType.id
		val armor: ItemStack = player.getCurrentArmor(pos)

		if (armor == null)
		{
			player.setCurrentItemOrArmor(pos + 1, is.copy())
			is.stackSize = 0
		}

		is
	}

	override def isValidArmor(is: ItemStack, armorType: Int, entity: Entity): Boolean =
	{
		this.armorType.id == armorType
	}

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		val modstring: String = this.modid
		val namestring: String = this.itemid

		s"$modstring:textures/models/$namestring.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		val modstring: String = this.modid
		val namestring: String = this.itemid

		this.itemIcon = iconRegister.registerIcon(s"$modstring:$namestring")
	}
}
