package de.thatsich.common;

import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.block.IBlock;
import de.thatsich.common.module.block.IContainerBlock;
import de.thatsich.common.module.item.IItem;
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

	protected AMinecraftObject ( IItem item, ABlock block, AContainerBlock containerBlock )
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

	/**
	 * Constructor for plain items
	 * like tools, armor etc
	 *
	 * @param item Item which needs to be handled
	 */
	protected AMinecraftObject ( IItem item )
	{
		this.items.addItem( item );
	}

	/**
	 * Constructor for Blocks with specific ItemBlock
	 *
	 * @param item  ItemBlock
	 * @param block Block
	 */
	protected AMinecraftObject ( IItem item, IBlock block )
	{
		this.items.addItem( item );
		this.blocks.addBlock( block );
	}

	/**
	 * Constructor for plain Blocks
	 *
	 * @param block Block
	 */
	protected AMinecraftObject ( IBlock block )
	{
		this.blocks.addBlock( block );
	}

	protected AMinecraftObject ( IItem item, IContainerBlock block )
	{
		this.items.addItem( item );
		this.blocks.addBlock( block );
	}
}
