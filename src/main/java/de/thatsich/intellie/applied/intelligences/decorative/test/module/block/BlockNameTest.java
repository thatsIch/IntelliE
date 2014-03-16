package de.thatsich.intellie.applied.intelligences.decorative.test.module.block;

import de.thatsich.common.module.block.info.ABlockName;

import javax.inject.Inject;

public class BlockNameTest extends ABlockName
{
	@Inject
	BlockNameTest ()
	{
		super( "intellie.Test" );
	}
}
