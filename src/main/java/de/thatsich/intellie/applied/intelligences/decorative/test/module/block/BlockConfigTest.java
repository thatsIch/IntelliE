package de.thatsich.intellie.applied.intelligences.decorative.test.module.block;

import de.thatsich.common.module.block.ABlockConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BlockConfigTest extends ABlockConfig
{
	@Inject
	BlockConfigTest ()
	{
		super( "blockTest" );
	}
}
