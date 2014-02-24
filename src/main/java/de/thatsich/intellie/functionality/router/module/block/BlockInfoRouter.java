package de.thatsich.intellie.functionality.router.module.block;

import com.google.inject.Inject;

import de.thatsich.common.module.block.info.ABlockInfo;
import net.minecraft.creativetab.CreativeTabs;

public class BlockInfoRouter extends ABlockInfo
{
	@Inject
	protected BlockInfoRouter( BlockNameRouter name )
	{
		super( name, CreativeTabs.tabBlock );
	}

}
