package de.thatsich.intellie.applied.aerodynamics.decorative.generic;

import de.thatsich.intellie.applied.aerodynamics.decorative.generic.module.GenericBlockConfig;
import de.thatsich.intellie.applied.aerodynamics.decorative.generic.module.GenericBlockInfo;
import de.thatsich.intellie.common.module.block.ABlock;
import de.thatsich.intellie.common.registries.BlockRegistry;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 27.03.2014. */
@Singleton
public class GenericBlock extends ABlock
{
	@Inject
	public GenericBlock(
			final GenericBlockInfo info,
			final GenericBlockConfig config,
			final BlockRegistry blocks )
	{
		super( info, config, blocks );
	}
}
