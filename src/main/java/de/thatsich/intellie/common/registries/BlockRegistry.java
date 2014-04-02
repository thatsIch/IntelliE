package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.common.module.block.ABlock;
import de.thatsich.intellie.common.module.block.IBlock;
import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;


/**
 Handles the registration of blocks and their names.
 This class is used by the framework and does not need
 to be instantiated or used in any way.
 */
@Singleton
public class BlockRegistry implements IRegistry<IBlock>
{
	private final Collection<IBlock> blocks;
	private final ILog log;

	@Inject
	public BlockRegistry( final ILog log )
	{
		this.log = log;
		this.blocks = new LinkedList<>();
	}

	public void loadConfig( final Configuration config )
	{
		this.log.info( "Loaded Configuration %s", config );
	}

	@Override
	public void add( final IBlock block )
	{
		this.blocks.add( block );
		this.log.info( "Added Block %s : %s", block, block.getUnlocalizedName() );
	}

	@Override
	public void register()
	{
		for( IBlock block : this.blocks )
		{
			ABlock concreteBlock = (ABlock) block;
			final String unlocalizedName = concreteBlock.getUnlocalizedName();
			GameRegistry.registerBlock( concreteBlock, unlocalizedName );
			this.log.debug( "Registered block with %s, %s", block, unlocalizedName );
		}
		this.log.info( "Finished registering Blocks and BlockContainer." );
	}
}
