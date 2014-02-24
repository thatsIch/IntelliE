package de.thatsich.common.module.block;

import de.thatsich.common.module.block.info.ABlockInfo;
import de.thatsich.common.module.block.info.ABlockName;
import net.minecraft.block.Block;


public abstract class ABlock extends Block
{
	protected ABlock ( ABlockInfo info, ABlockConfig config, ABlockTexture texture )
	{
		super( info.getMaterial() );

		final ABlockName blockName = info.getBlockName();
		final String name = blockName.getName();
		final float hardness = info.getHardness();

		this.setBlockName( name );
		this.setHardness( hardness );
		//		this.setBlockBounds(  );
		this.setCreativeTab( info.getCreativeTab() );
	}
}
