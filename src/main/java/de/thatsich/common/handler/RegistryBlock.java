package de.thatsich.common.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.item.AItemBlock;
import de.thatsich.intellie.common.util.IELog;
import net.minecraftforge.common.config.Configuration;

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
	private final Collection<ABlock> blocks;
	private final Collection<AContainerBlock> containerBlocks;
	private final IELog log;

	/**
	 * CTOR
	 *
	 * @param log Logger
	 */
	@Inject
	public RegistryBlock ( IELog log )
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
	public void addBlock ( final ABlock block )
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
	public void addBlock ( final AContainerBlock containerBlock )
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
	private void registerContainerBlocks ( Iterable<AContainerBlock> containerBlocks )
	{
		for ( AContainerBlock block : containerBlocks )
		{
			final Class<? extends AItemBlock> itemBlockClass = block.getItemBlockClass();
			final String unlocalizedName = block.getUnlocalizedName();

			if ( itemBlockClass != null )
			{
				GameRegistry.registerBlock( block, itemBlockClass, unlocalizedName );
			} else
			{
				GameRegistry.registerBlock( block, unlocalizedName );
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
	private void registerBlocks ( Iterable<ABlock> blocks )
	{
		for ( ABlock block : blocks )
		{
			final String unlocalizedName = block.getUnlocalizedName();
			GameRegistry.registerBlock( block, unlocalizedName );
			this.log.info( "Registered block with %s, %s", block, unlocalizedName );
		}
	}

	public void loadConfig ( final Configuration config )
	{
		this.log.info( "Loaded Configuration %s", config );
	}
}
