package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.common.module.block.ABlockContainer;
import de.thatsich.intellie.common.module.block.IBlockContainer;
import de.thatsich.intellie.common.module.item.AItemBlock;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;

/**
 @author thatsIch
 @date 25.03.2014. */
@Singleton
public class BlockContainerRegistry implements IRegistry<IBlockContainer>
{
	private final Collection<IBlockContainer> blockContainers;
	private final ILog log;

	@Inject
	public BlockContainerRegistry ( ILog log )
	{
		this.blockContainers = new HashSet<>( 1 );
		this.log = log;
	}

	@Override
	public void add ( final IBlockContainer blockContainer )
	{
		this.blockContainers.add( blockContainer );
		this.log.debug( "Added %s", blockContainer );
	}

	@Override
	public void register ()
	{
		for ( IBlockContainer block : this.blockContainers )
		{
			final ABlockContainer container = (ABlockContainer) block;
			final Class<? extends AItemBlock> itemBlockClass = container.getItemBlockClass();
			final String unlocalizedName = container.getUnlocalizedName();

			if ( itemBlockClass != null )
			{
				GameRegistry.registerBlock( container, itemBlockClass, unlocalizedName );
			}
			else
			{
				GameRegistry.registerBlock( container, unlocalizedName );
			}
			this.log.debug( "Registered BlockContainer %s", block );
		}
		this.log.info( "Finished registering Blocks and BlockContainer." );
	}
}
