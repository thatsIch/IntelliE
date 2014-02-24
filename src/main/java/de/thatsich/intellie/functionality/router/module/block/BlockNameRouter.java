package de.thatsich.intellie.functionality.router.module.block;

import com.google.inject.Singleton;

import de.thatsich.common.module.block.info.ABlockName;

@Singleton
public class BlockNameRouter extends ABlockName
{
	protected BlockNameRouter()
	{
		super( "Router" );
	}
}
