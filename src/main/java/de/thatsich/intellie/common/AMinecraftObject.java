package de.thatsich.intellie.common;

import de.thatsich.intellie.common.module.block.IBlock;
import de.thatsich.intellie.common.module.item.IItem;
import de.thatsich.intellie.common.module.tileentity.ITileEntity;
import de.thatsich.intellie.common.registries.BlockRegistry;
import de.thatsich.intellie.common.registries.ConfigRegistry;
import de.thatsich.intellie.common.registries.ItemRegistry;
import de.thatsich.intellie.common.registries.TileEntityRegistry;
import de.thatsich.intellie.common.util.IMinecraftObject;

import javax.inject.Inject;


public abstract class AMinecraftObject implements IMinecraftObject
{
	@Inject BlockRegistry blocks;
	@Inject ConfigRegistry configs;
	@Inject ItemRegistry items;
	@Inject TileEntityRegistry tileEntities;

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
