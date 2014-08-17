package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import java.util

import net.minecraft.block.BlockDispenser
import net.minecraft.command.IEntitySelector
import net.minecraft.dispenser.{BehaviorDefaultDispenseItem, IBlockSource}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{EntityLiving, EntityLivingBase}
import net.minecraft.item.ItemStack
import net.minecraft.util.{AxisAlignedBB, EnumFacing}


/**
 *
 *
 * @author thatsIch
 * @since 17.08.2014.
 */
class AeroDispenseBehavior extends BehaviorDefaultDispenseItem
{
	override def dispenseStack(block: IBlockSource, is: ItemStack): ItemStack =
	{
		val enumfacing: EnumFacing = BlockDispenser.func_149937_b(block.getBlockMetadata)
		val x: Int = block.getXInt + enumfacing.getFrontOffsetX
		val y: Int = block.getYInt + enumfacing.getFrontOffsetY
		val z: Int = block.getZInt + enumfacing.getFrontOffsetZ
		val axisalignedbb: AxisAlignedBB = AxisAlignedBB.getBoundingBox(x.asInstanceOf[Double], y.asInstanceOf[Double], z.asInstanceOf[Double], (x + 1).asInstanceOf[Double], (y + 1).asInstanceOf[Double], (z + 1).asInstanceOf[Double])
		val entities: util.List[_] = block.getWorld.selectEntitiesWithinAABB(classOf[EntityLivingBase], axisalignedbb, new IEntitySelector.ArmoredMob(is))

		if (entities.size > 0)
		{
			val entitylivingbase: EntityLivingBase = entities.get(0).asInstanceOf[EntityLivingBase]
			val isPlayer: Int = if (entitylivingbase.isInstanceOf[EntityPlayer]) 1 else 0
			val armorPos: Int = EntityLiving.getArmorPosition(is)
			val copy: ItemStack = is.copy
			copy.stackSize = 1
			entitylivingbase.setCurrentItemOrArmor(armorPos - isPlayer, copy)

			entitylivingbase match
			{
				case living: EntityLiving => living.setEquipmentDropChance(armorPos, 2.0F)
				case _                    =>
			}
			is.stackSize -= 1

			is
		}
		else
		{
			super.dispenseStack(block, is)
		}
	}
}
