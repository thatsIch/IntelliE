package de.thatsich.intellie.common.module.block;

import de.thatsich.intellie.common.IInstantiate;
import de.thatsich.intellie.common.module.IName;
import de.thatsich.intellie.common.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;


public abstract class ABlock extends Block implements IBlock, IInstantiate
{

	protected ABlock( ABlockInfo info, ABlockConfig config, BlockRegistry blocks )
	{
		super( info.getMaterial() );

		final IName blockName = info.getName();
		final String name = blockName.getUnlocalizedName();
		final float hardness = info.getHardness();
		final CreativeTabs creativeTab = info.getCreativeTab();
		final String texture = info.getTexture().getTexture();

		this.setBlockName( name );
		this.setHardness( hardness );
		this.setBlockTextureName( texture );
		this.setCreativeTab( creativeTab );

		blocks.add( this );
	}
}
