package de.thatsich.intellie.common.module.block;

import de.thatsich.intellie.common.module.item.AItemBlock;
import net.minecraft.block.ITileEntityProvider;

/**
 @author thatsIch
 @since 06.03.14. */
public interface IBlockContainer extends IBlock, ITileEntityProvider
{
	Class<? extends AItemBlock> getItemBlockClass();
}
