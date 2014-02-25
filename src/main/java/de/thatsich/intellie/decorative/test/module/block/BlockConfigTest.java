package de.thatsich.intellie.decorative.test.module.block;

import com.google.inject.Singleton;
import de.thatsich.common.module.block.ABlockConfig;


@Singleton
public class BlockConfigTest extends ABlockConfig
{
	protected BlockConfigTest ()
	{
		super( "blockTest" );
	}
}
