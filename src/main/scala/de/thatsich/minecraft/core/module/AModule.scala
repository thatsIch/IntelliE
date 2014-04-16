package de.thatsich.minecraft.core.module

import net.minecraft.item.Item
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.tileentity.TileEntity
import de.thatsich.minecraft.core.registries.IRegistries

/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
abstract class AModule(item: Option[ Item ], block: Option[ Block ], entity: Option[ Entity ], tileEntity: Option[ TileEntity ])
                      (implicit registries: IRegistries)
{
	item match
	{
		case Some(_) =>
		{
			{
				registries.items.add(item.get)
			}
		}
		case None    =>
		{
			{

			}
		}
	}
}
