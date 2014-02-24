package de.thatsich.common;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

import de.thatsich.common.handler.RegistryBlock;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.entity.AEntity;
import de.thatsich.common.module.item.IItem;


public abstract class AMinecraftModule extends AbstractModule
{
	private final ABlock block;

	@Inject
	public AMinecraftModule( IItem item, ABlock block, AContainerBlock containerBlock, AEntity entity )
	{
		this.block = block;
	}
	
	@Inject
	private void init( RegistryBlock blocks ) {
		System.out.println("Init CALLED");
		blocks.addBlock( this.block );
	}

	@Override
	protected void configure()
	{
	}
}
