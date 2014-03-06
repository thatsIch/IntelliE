package de.thatsich.intellie.functionality.router.module.block;

import de.thatsich.common.module.block.info.ABlockInfo;
import net.minecraft.creativetab.CreativeTabs;

import javax.inject.Inject;

public class BlockInfoRouter extends ABlockInfo
{
	@Inject
	protected BlockInfoRouter( BlockNameRouter name )
	{
		super( name, CreativeTabs.tabBlock );
	}

}
