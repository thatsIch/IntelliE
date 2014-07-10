package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots

import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.item.AAEPoweredItemArmor
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class ItemAeroBoots( implicit creativeTab: CreativeTabs )
	extends AAEPoweredItemArmor( 4000000, 3 )
{
	final val disChargeOnTick = 40

	// TODO muss logic ändern, sonst kann user einfach ausziehen und hat immer noch effekt
	override def onArmorTick( world: World, player: EntityPlayer, itemStack: ItemStack ): Unit =
	{
		val currentStorage = this.getAECurrentPower( itemStack )
		var newStorage = currentStorage
		if( player.isSprinting )
		{
			newStorage = this.extractAEPower( itemStack, this.disChargeOnTick )
		}

		if( newStorage > 0 )
		{
			player.stepHeight = 1F
			player.fallDistance = 0
		}
		else
		{
			player.stepHeight = 0.5F
		}
	}

	override def getArmorTexture( stack: ItemStack, entity: Entity, slot: Int, `type`: String ): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly( Side.CLIENT )
	override def registerIcons( iconRegister: IIconRegister ): Unit =
	{
		this.itemIcon = iconRegister.registerIcon( "appaero:aeroboots" )
	}
}
