package de.thatsich.common;

import de.thatsich.common.module.block.IBlock;
import de.thatsich.common.module.item.IItem;
import de.thatsich.common.module.tileentity.ITileEntity;
import de.thatsich.common.registries.RegistryBlock;
import de.thatsich.common.registries.RegistryConfig;
import de.thatsich.common.registries.RegistryItem;
import de.thatsich.common.registries.RegistryTileEntity;
import de.thatsich.common.util.IMinecraftObject;

import javax.inject.Inject;


public abstract class AMinecraftObject implements IMinecraftObject
{
	@Inject RegistryBlock blocks;
	@Inject RegistryConfig configs;
	@Inject RegistryItem items;
	@Inject RegistryTileEntity tileEntities;

	protected AMinecraftObject ( IItem item, IBlock block, ITileEntity tileEntity )
	{
		if ( item != null )
		{
			this.items.addItem( item );
		}

		if ( block != null )
		{
			this.blocks.addBlock( block );
		}

		// TODO configs and TEs
	}
}
