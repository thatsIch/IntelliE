package de.thatsich.intellie.functionality.router.module.block;

import com.google.inject.Singleton;

import de.thatsich.common.module.block.ABlockConfig;


@Singleton
public class BlockConfigRouter extends ABlockConfig
{
	protected BlockConfigRouter()
	{
		super( "blockRouter" );
	}
}
