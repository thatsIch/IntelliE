package de.thatsich.intellie.common;

import de.thatsich.intellie.common.module.block.IBlock;
import de.thatsich.intellie.common.module.item.IItem;
import de.thatsich.intellie.common.module.tileentity.ITileEntity;
import de.thatsich.intellie.common.registries.RegistryBlock;
import de.thatsich.intellie.common.registries.RegistryConfigFactory;
import de.thatsich.intellie.common.registries.RegistryItem;
import de.thatsich.intellie.common.registries.RegistryTileEntity;
import de.thatsich.intellie.common.util.IMinecraftObject;

import javax.inject.Inject;


public abstract class AMinecraftObject implements IMinecraftObject
{
	@Inject RegistryBlock blocks;
	@Inject RegistryConfigFactory configsFactory;
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
