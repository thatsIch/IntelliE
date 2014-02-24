package de.thatsich.intellie.functionality.router.module;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.thatsich.intellie.functionality.router.module.block.BlockConfigRouter;
import de.thatsich.intellie.functionality.router.module.block.BlockGuiRouter;
import de.thatsich.intellie.functionality.router.module.block.BlockInfoRouter;
import de.thatsich.intellie.functionality.router.module.block.BlockNetworkRouter;
import de.thatsich.intellie.functionality.router.module.block.BlockTextureRouter;
import de.thatsich.intellie.functionality.router.module.block.TileEntityRouter;
import de.thatsich.common.module.block.AContainerBlock;

@Singleton
public class BlockRouter extends AContainerBlock
{
	@Inject
	public BlockRouter( BlockInfoRouter info, BlockConfigRouter config, BlockGuiRouter gui, BlockNetworkRouter network, BlockTextureRouter texture )
	{
		super( info, config, gui, network, texture, TileEntityRouter.class, ItemBlockRouter.class );
	}
}
