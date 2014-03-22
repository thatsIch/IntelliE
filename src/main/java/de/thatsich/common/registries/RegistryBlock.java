package de.thatsich.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.ABlockContainer;
import de.thatsich.common.module.block.IBlock;
import de.thatsich.common.module.block.IContainerBlock;
import de.thatsich.common.module.item.AItemBlock;
import de.thatsich.common.util.logging.Logger;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;


/**
 * Handles the registration of blocks and their names.
 * This class is used by the framework and does not need
 * to be instantiated or used in any way.
 */
@Singleton
public class RegistryBlock
{
	private final Collection<IBlock> blocks;
	private final Collection<IContainerBlock> containerBlocks;
	private final Logger log;

	/**
	 * CTOR
	 *
	 * @param log Logger
	 */
	@Inject
	public RegistryBlock ( Logger log )
	{
		this.log = log;
		this.blocks = new LinkedList<>();
		this.containerBlocks = new LinkedList<>();
	}

	/**
	 * Adds a new block to be registered and named.
	 * Is getting called automatically by the module class
	 *
	 * @param block new to be added block.
	 */
	public void addBlock ( final IBlock block )
	{
		this.blocks.add( block );
		this.log.info( "Added Block %s", block );
	}

	/**
	 * Adds a new blockcontainer to be registered and named.
	 * Is getting called automatically by the module class
	 *
	 * @param containerBlock new to be added blockcontainer
	 */
	public void addBlock ( final IContainerBlock containerBlock )
	{
		this.containerBlocks.add( containerBlock );
		this.log.info( "Added BlockContainer %s", containerBlock );
	}

	/**
	 * Register the blocks and containerblocks in the GameRegistry
	 */
	public void registerBlocks ()
	{
		this.registerBlocks( this.blocks );
		this.registerContainerBlocks( this.containerBlocks );
		this.log.info( "Finished registering Blocks and BlockContainer." );
	}

	/**
	 * Register the blockand containerblocks in the GameRegistry with:
	 * - block (Block)
	 * - itemBlock-Class (Class<ItemBlock>)
	 * - block key (String)
	 *
	 * @param containerBlocks blockcontainers to be added
	 */
	private void registerContainerBlocks ( Iterable<IContainerBlock> containerBlocks )
	{
		for ( IContainerBlock block : containerBlocks )
		{
			final ABlockContainer container = (ABlockContainer) block;
			final Class<? extends AItemBlock> itemBlockClass = container.getItemBlockClass();
			final String unlocalizedName = container.getUnlocalizedName();

			if ( itemBlockClass != null )
			{
				GameRegistry.registerBlock( container, itemBlockClass, unlocalizedName );
			} else
			{
				GameRegistry.registerBlock( container, unlocalizedName );
			}
			this.log.info( "Registered BlockContainer %s", block );
		}
	}

	/**
	 * Register the blocks in the GameRegistry with:
	 * - block (Block)
	 * - block key (String)
	 *
	 * @param blocks new blocks to be added
	 */
	private void registerBlocks ( Iterable<IBlock> blocks )
	{
		for ( IBlock block : blocks )
		{
			ABlock concreteBlock = (ABlock) block;
			final String unlocalizedName = concreteBlock.getUnlocalizedName();
			GameRegistry.registerBlock( concreteBlock, unlocalizedName );
			this.log.info( "Registered block with %s, %s", block, unlocalizedName );
		}
	}

	public void loadConfig ( final Configuration config )
	{
		this.log.info( "Loaded Configuration %s", config );
	}
}
