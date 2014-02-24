package de.thatsich.intellie.decorative.test.module.block;

import com.google.inject.Singleton;
import de.thatsich.common.module.block.info.ABlockName;

@Singleton
public class BlockNameTest extends ABlockName
{
	protected BlockNameTest ()
	{
		super( "Test" );
	}
}
