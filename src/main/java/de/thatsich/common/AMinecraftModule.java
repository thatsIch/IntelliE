package de.thatsich.common;

import de.thatsich.common.module.IModule;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.item.AItem;
import de.thatsich.common.registries.RegistryBlock;
import de.thatsich.common.registries.RegistryConfig;
import de.thatsich.common.registries.RegistryItem;
import de.thatsich.common.registries.RegistryTileEntity;

import javax.inject.Inject;


public abstract class AMinecraftModule implements IModule
{
	@Inject private RegistryBlock blocks;
	@Inject private RegistryConfig configs;
	@Inject private RegistryItem items;
	@Inject private RegistryTileEntity tileEntities;

	protected AMinecraftModule ( AItem item, ABlock block, AContainerBlock containerBlock )
	{
		if (item != null) {
			this.items.addItem( item );
		}

		if (block != null) {
			this.blocks.addBlock( block );
		}

		// TODO configs and TEs
	}
}
