package de.thatsich.intellie.common.module.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;


public class AItemBlock extends ItemBlock implements IItemBlock
{
	public AItemBlock ( AItemInfo info, AItemConfig config, AItemRecipe recipe )
	{
		super( Blocks.dirt );
	}
}
