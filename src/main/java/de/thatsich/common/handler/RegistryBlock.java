package de.thatsich.common.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.block.ABlock;
import de.thatsich.common.module.block.AContainerBlock;
import de.thatsich.common.module.item.AItemBlock;
import de.thatsich.intellie.common.util.IELog;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Handles the registration of blocks and their names.
 * This class is used by the framework and does not need
 * to be instantiated or used in any way.
 */
@Singleton
public class RegistryBlock
{
	@Inject private IELog log;

	private final Collection<ABlock> blocks = new ArrayList<>( 10 );
	private final Collection<AContainerBlock> containerBlocks = new ArrayList<>( 10 );

	/**
	 * Adds a new module to be registered and named.
	 * Is getting called automatically by the module class
	 *
	 * @param block new to be added module.
	 */
	public void addBlock ( final ABlock block )
	{
		this.blocks.add( block );
	}

	public void addBlock ( final AContainerBlock containerBlock )
	{
		this.containerBlocks.add( containerBlock );
	}

	/**
	 * Register the block in the GameRegistry with:
	 * - block (Block)
	 * - itemBlock-Class (Class<ItemBlock>)
	 * - block key (String)
	 */
	public void registerBlocks ()
	{
		this.registerContainerBlocks( this.containerBlocks );
		this.registerBlocks( this.blocks );
	}

	private void registerBlocks ( Iterable<ABlock> blocks )
	{
		for ( ABlock block : blocks )
		{
			final String unlocalizedName = block.getUnlocalizedName();
			GameRegistry.registerBlock( block, unlocalizedName );
			this.log.info( "Registered block %s", block );
		}
	}

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
		}
	}
}
