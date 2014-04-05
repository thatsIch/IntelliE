package de.thatsich.intellie.common.registries;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;

/**
 @author thatsIch
 @since 24.03.2014. */
@Singleton
public class BlockRenderingRegistry implements IRegistry<ISimpleBlockRenderingHandler>
{
	private final Collection<ISimpleBlockRenderingHandler> blockRenderers;
	private final ILog log;

	@Inject
	public BlockRenderingRegistry( final ILog log )
	{
		this.log = log;
		this.blockRenderers = new LinkedList<>();
	}

	@Override
	public void add( final ISimpleBlockRenderingHandler handler )
	{
		this.blockRenderers.add( handler );
		this.log.debug( "Added BlockRenderer %s", handler );
	}

	@Override
	public void register()
	{
		for( ISimpleBlockRenderingHandler handler : this.blockRenderers )
		{
			RenderingRegistry.registerBlockHandler( handler );
		}
		this.log.info( "Registered all BlockRenderers" );
	}
}
