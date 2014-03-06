package de.thatsich.intellie.decorative.test.module.block;

import de.thatsich.common.module.block.info.ABlockInfo;
import net.minecraft.creativetab.CreativeTabs;

import javax.inject.Inject;

public class BlockInfoTest extends ABlockInfo
{
	@Inject
	protected BlockInfoTest ( BlockNameTest name )
	{
		super( name, CreativeTabs.tabDecorations );
	}
}
