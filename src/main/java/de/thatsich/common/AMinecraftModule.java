package de.thatsich.common;

import de.thatsich.common.handler.RegistryBlock;
import de.thatsich.common.module.IModule;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.item.IItem;

import javax.inject.Inject;


public abstract class AMinecraftModule implements IModule
{
	private final ABlock block;

	@Inject
	protected AMinecraftModule( IItem item, ABlock block, AContainerBlock containerBlock)
	{
		this.block = block;
	}
	
	@Inject
	private void init( RegistryBlock blocks ) {
		blocks.addBlock( this.block );
	}
}
