package de.thatsich.intellie.decorative.test.module;

import de.thatsich.common.module.block.ABlock;
import de.thatsich.intellie.decorative.test.module.block.BlockConfigTest;
import de.thatsich.intellie.decorative.test.module.block.BlockInfoTest;
import de.thatsich.intellie.decorative.test.module.block.BlockTextureTest;

import javax.inject.Inject;

public class BlockTest extends ABlock
{
	@Inject
	public BlockTest ( BlockInfoTest info, BlockConfigTest config, BlockTextureTest texture )
	{
		super(info, config, texture );
	}
}
